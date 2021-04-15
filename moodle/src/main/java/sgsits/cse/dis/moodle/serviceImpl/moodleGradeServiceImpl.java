package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import sgsits.cse.dis.moodle.model.MoodleGradeGrades;
import sgsits.cse.dis.moodle.model.MoodleGradeItems;


import sgsits.cse.dis.moodle.repo.MoodleGradeGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleGradeItemsRepo;

import sgsits.cse.dis.moodle.response.GradeItemsData;
import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.response.StudentOverviewReport;
import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.model.MoodleContext;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleEnrollement;
import sgsits.cse.dis.moodle.model.MoodleRole;
import sgsits.cse.dis.moodle.model.MoodleRoleAssignments;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;
import sgsits.cse.dis.moodle.repo.MoodleContextRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleAssignmentsRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.CoursesOfStudentData;
import sgsits.cse.dis.moodle.response.Students;
import sgsits.cse.dis.moodle.service.moodleAssignmentService;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@Component
public class moodleGradeServiceImpl implements moodleGradeService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MoodleGradeItemsRepo moodleGradeItemsRepo;
	@Autowired
	private MoodleCourseRepo moodleCourseRepo;
	@Autowired
	private MoodleGradeGradesRepo moodleGradeGradesRepo;
	@Autowired
	private MoodleUserRepo moodleUserRepo;

	@Autowired
	public MoodleUserEnrollmentRepo moodleUserEnrollmentRepo;
	@Autowired
	public MoodleEnrollmentRepo moodleEnrollmentRepo;
	@Autowired
	public MoodleRoleAssignmentsRepo moodleRoleAssignmentsRepo;
	@Autowired
	public MoodleRoleRepo moodleRoleRepo;
	@Autowired
	public MoodleContextRepo moodlecontextRepo;
	@Autowired
	public moodleAssignmentService moodleAssignmentServiceImpl;
	
	@Override
	public List<GradeItemsData> getGradeItemsOfCourse(String courseId) {
		List<GradeItemsData> gradeItems = new ArrayList<GradeItemsData>();
		
		List<MoodleGradeItems> gradeItemsDetailed = new ArrayList<MoodleGradeItems>();
		Long courseIdL = Long.parseLong(courseId);
		gradeItemsDetailed = moodleGradeItemsRepo.findByCourseid(courseIdL);
		for (MoodleGradeItems gradeItem : gradeItemsDetailed) {
			gradeItems.add(new GradeItemsData(gradeItem.getId(), gradeItem.getCourseid(), gradeItem.getItemname()));
		}
		
		return gradeItems;
	}
	
	@Override
	public List<List<GraderReportData>> getGraderReport(Long courseIdL, Long itemIdL, String userType) throws NotFoundException {
		
		List<List<GraderReportData>> graderReport = new ArrayList<List<GraderReportData>>();

		if(userType.equals("student"))
			throw new  NotFoundException("Invalid User Type");
		
		// List for taking courseCode and courseName
		List<MoodleCourse> courseDetails = moodleCourseRepo.findAllById(courseIdL);
		
		List<MoodleGradeItems> gradeItemsDetailed = new ArrayList<MoodleGradeItems>();
		
		if (itemIdL == 0L) {
			gradeItemsDetailed = moodleGradeItemsRepo.findByCourseid(courseIdL);
		}
		else {
			gradeItemsDetailed = moodleGradeItemsRepo.findByIdAndCourseid(itemIdL, courseIdL);
		}
		
		for (MoodleGradeItems gradeItem : gradeItemsDetailed) {
			List<MoodleGradeGrades> gradeGradesDetails = moodleGradeGradesRepo.findByItemid(gradeItem.getId());
			
			// initializing 2d empty list of lists for entering final data if empty
			if (graderReport.isEmpty()) {
				for (int i=0; i<gradeGradesDetails.size(); i++) {
					graderReport.add(new ArrayList<GraderReportData>());
				}
			}
			
			for (int i=0; i<gradeGradesDetails.size(); i++) {
				MoodleUser currUser = moodleUserRepo.findAllById(gradeGradesDetails.get(i).getUserid());
				
				Double finalGrade = gradeGradesDetails.get(i).getFinalgrade();
				Double totalGrade = gradeGradesDetails.get(i).getRawgrademax();
				Double percentage = null;
				if (finalGrade != null) {
					percentage = (finalGrade/totalGrade) * 100;
				}
				graderReport.get(i).add(new GraderReportData(currUser.getId(),
																currUser.getFirstname(),
																currUser.getLastname(),
																courseDetails.get(0).getShortname(),
																courseDetails.get(0).getFullname(),
																gradeItem.getItemname(),
																finalGrade,
																totalGrade,
																percentage));
		    }
			
			
		}
		
		return graderReport;
	}
	
	@Override
	public List<List<GraderReportData>> getUserReport(Long courseIdL, Long userIdL, String userType) throws NotFoundException {
		List<List<GraderReportData>> userReport = new ArrayList<List<GraderReportData>>();
		List<List<GraderReportData>> tempUserReport = new ArrayList<List<GraderReportData>>();
		if(userType.equals("student"))
			throw new  NotFoundException("Invalid User Type");
		
		tempUserReport = getGraderReport(courseIdL,0L, userType);
		
		if (userIdL == 0) {
			userReport = tempUserReport;
		}
		else {
			for (List<GraderReportData> item : tempUserReport) {
				if (item.get(0).getUserId() == userIdL) {
					userReport.add(item);
					break;
				}
			}
		}
		return userReport;
	}

	

	@Override
	public List<Course> getAllCoursesByGrader(String username, String userType) throws NotFoundException
	{	
		Long userid = moodleUserRepo.findByUsername(username).get(0).getId();
		List<MoodleUserEnrollment> enrollList = moodleUserEnrollmentRepo.findByUserid(userid);
		List<Course> courses = new ArrayList<Course>();
		if(userType.equals("student"))
			throw new  NotFoundException("Invalid User Type");
		
		for(MoodleUserEnrollment enroll : enrollList)
		{
			Optional<MoodleEnrollement> en = moodleEnrollmentRepo.findById(enroll.getEnrolid());
			if(en.isPresent())
			{
				Optional<MoodleCourse> course = moodleCourseRepo.findById(en.get().getCourseid());
				if(course.isPresent())
					courses.add(new Course(course.get().getId(),course.get().getFullname(),course.get().getShortname()));
			}
		}
		return courses;
	}

	@Override
	public List<Students> getAllStudentsOfCourse(Long courseId, String userType) throws NotFoundException {
		List<MoodleEnrollement> enrolls = moodleEnrollmentRepo.findByCourseid(courseId);
		List<MoodleUserEnrollment> userenrolls = new ArrayList<MoodleUserEnrollment>();
		List<Students> studs = new ArrayList<Students>();
		if(userType.equals("student"))
			throw new  NotFoundException("Invalid User Type");
		for(MoodleEnrollement e : enrolls)
		{
			List<MoodleUserEnrollment> id = moodleUserEnrollmentRepo.findByEnrolid(e.getId());
			for(MoodleUserEnrollment ue : id)
			{
				userenrolls.add(ue);
			}
		}
		
		for(MoodleUserEnrollment ue : userenrolls)
		{
			Optional<MoodleUser> curr = moodleUserRepo.findById(ue.getUserid());
			if(curr.isPresent())
			{
				Optional<MoodleRole> role = getRoleOfUser(curr.get().getId(), courseId);
				if(role.get().getShortname().equals("student"))
					studs.add(new Students(curr.get().getId(), curr.get().getUsername(), curr.get().getFirstname(), curr.get().getLastname()));				
			}
		}
		return studs;
	}
	
	Optional<MoodleRole> getRoleOfUser(Long userId, Long courseId)
	{
		List<MoodleContext> con = moodlecontextRepo.findByInstanceid(courseId);
		for(MoodleContext c : con)
		{
			Optional<MoodleRoleAssignments> role_assn = moodleRoleAssignmentsRepo.findByContextidAndUserid(c.getId(), userId);
			if(!role_assn.isPresent())
				continue;
			Long role_id = role_assn.get().getRoleid();
			return moodleRoleRepo.findById(role_id);
		}
		return null;
	}

	@Override
	public List<StudentOverviewReport> getStudentsOverviewReport(Long userId, String userType) throws NotFoundException {
		List<CoursesOfStudentData> courseList = moodleAssignmentServiceImpl.getAllCoursesOfStudent(userId,userType);
		List<StudentOverviewReport> ans = new ArrayList<StudentOverviewReport>();
		if(!userType.equals("student"))
			throw new  NotFoundException("Invalid User Type");
		for(CoursesOfStudentData course : courseList)
		{
			Optional<MoodleGradeItems> item = moodleGradeItemsRepo.findByCourseidAndItemname(course.getCourseId(), "course total");
			if(!item.isPresent())
				ans.add(new StudentOverviewReport(course.getCourseName(), 0.0, course.getCourseId(),0.0));
			else
			{
				Optional<MoodleGradeGrades> grade = moodleGradeGradesRepo.findByItemidAndUserid(item.get().getId(), userId);
				if(!grade.isPresent())
					ans.add(new StudentOverviewReport(course.getCourseName(), 0.0, course.getCourseId(),0.0));
				else
					ans.add(new StudentOverviewReport(course.getCourseName(), grade.get().getFinalgrade(), course.getCourseId(),grade.get().getRawgrademax()));
			}
		}
		return ans;
	}

	@Override
	public List<GraderReportData> getStudentsUserReport(Long courseId, Long userId, String userType) throws NotFoundException {
		//if(!userType.equals("student"))
		//	throw new  NotFoundException("Invalid User Type");
		
		userType = "teacher";
		
		List<List<GraderReportData>> curr = getUserReport(courseId, userId, userType);
		List<GraderReportData> ans = new ArrayList<GraderReportData>();
		if(!curr.isEmpty())
			ans = curr.get(0);
		return ans;
	}
	@Override
	public Long getStudentsUserId(String username) throws NotFoundException {
		List<MoodleUser> user = moodleUserRepo.findByUsername(username);
		if(user.isEmpty())
			throw new NotFoundException("username does not exist");
		return user.get(0).getId();
	}
}
