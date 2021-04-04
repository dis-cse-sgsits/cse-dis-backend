package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.moodle.model.MoodleAssign;
import sgsits.cse.dis.moodle.model.MoodleAssignGrades;
import sgsits.cse.dis.moodle.model.MoodleAssignSubmission;

import sgsits.cse.dis.moodle.model.MoodleContext;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleEnrollement;
import sgsits.cse.dis.moodle.model.MoodleRole;
import sgsits.cse.dis.moodle.model.MoodleRoleAssignments;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;
import sgsits.cse.dis.moodle.repo.MoodleAssignGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignSubmissionRepo;
import sgsits.cse.dis.moodle.repo.MoodleContextRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleAssignmentsRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.CoursesOfStudentData;
import sgsits.cse.dis.moodle.response.StudentSubjectReportData;
import sgsits.cse.dis.moodle.response.Students;


import sgsits.cse.dis.moodle.response.Assignment;

import sgsits.cse.dis.moodle.response.TeacherReportData;

import sgsits.cse.dis.moodle.service.moodleAssignmentService;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@Component
public class moodleAssignmentServiceImpl implements moodleAssignmentService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MoodleUserEnrollmentRepo moodleUserEnrollmentRepo;
	@Autowired
	private MoodleEnrollmentRepo moodleEnrollmentRepo;
	@Autowired
	private MoodleCourseRepo moodleCourseRepo;
	@Autowired
	private MoodleUserRepo moodleUserRepo;
	@Autowired
	private MoodleAssignRepo moodleAssignRepo;
	@Autowired
	private MoodleAssignGradesRepo moodleAssignGradesRepo;
	@Autowired
	private MoodleAssignSubmissionRepo moodleAssignSubmissionRepo;
	
	@Autowired
	public MoodleRoleAssignmentsRepo moodleRoleAssignmentsRepo;
	@Autowired
	public MoodleRoleRepo moodleRoleRepo;
	@Autowired
	public MoodleContextRepo moodlecontextRepo;
	

	@Autowired
	private moodleGradeService moodleGradeServiceImpl;



	@Override
	public List<CoursesOfStudentData> getAllCoursesOfStudent(Long userId) {
		List<CoursesOfStudentData> allCoursesOfStudent = new ArrayList<CoursesOfStudentData>();
		
		List<MoodleUserEnrollment> userEnrollList = moodleUserEnrollmentRepo.findByUserid(userId);
		
		List<MoodleEnrollement> enrollList = new ArrayList<MoodleEnrollement>();
		
		for (MoodleUserEnrollment userEnroll : userEnrollList) {
			Optional<MoodleEnrollement> enroll = moodleEnrollmentRepo.findById(userEnroll.getEnrolid());
			if (enroll.isPresent()) {
				enrollList.add(enroll.get());
			}
		}
		
		for (MoodleEnrollement enroll : enrollList) {
			List<MoodleCourse> course = moodleCourseRepo.findAllById(enroll.getCourseid());
			
			allCoursesOfStudent.add(new CoursesOfStudentData(userId, course.get(0).getShortname(), course.get(0).getFullname(),course.get(0).getId()));
		}
		
		return allCoursesOfStudent;
	}

	@Override
	public List<StudentSubjectReportData> getStudentSubjectReport(Long userId, Long courseId) {
		List<StudentSubjectReportData> studentSubjectReport = new ArrayList<StudentSubjectReportData>();
		
		List<MoodleCourse> courseDetails = moodleCourseRepo.findAllById(courseId);
		List<Students> teacher = getTeacherOfCourse(courseId);
		
		Optional<List<MoodleAssign>> allAssignmentsOfCourse = moodleAssignRepo.findByCourse(courseId);
		
		for (MoodleAssign assignment : allAssignmentsOfCourse.get()) {
			List<MoodleAssignGrades> assignGrades = moodleAssignGradesRepo.findByAssignmentAndUseridOrderByAttemptnumberDesc(assignment.getId(), userId);
			
			List<MoodleAssignSubmission> assignSubmission = moodleAssignSubmissionRepo.findByAssignmentAndUserid(assignment.getId(), userId);
			
			MoodleUser grader = new MoodleUser();
			Double gradeObtained = 0D;
			
			if (!assignGrades.isEmpty()) {
				grader = moodleUserRepo.findAllById(assignGrades.get(0).getGrader());
				
				gradeObtained = assignGrades.get(0).getGrade();
				if (gradeObtained == null || gradeObtained == -1D) {
					gradeObtained = 0D;
				}
			}
					
			String dueDate = getDateFromUnixDate(assignment.getDuedate());
			String dateOfCreation = getDateFromUnixDate(assignSubmission.get(0).getTimecreated());

			
			Boolean submitted = (assignSubmission.get(0).getStatus().equals("new")) ? false : true;
			String dateOfSubmission = (submitted == false) ? null : getDateFromUnixDate(assignSubmission.get(0).getTimemodified());
			
			studentSubjectReport.add(new StudentSubjectReportData(courseId,
																	courseDetails.get(0).getShortname(),
																	courseDetails.get(0).getFullname(),
																	teacher.get(0).getId(),
																	teacher.get(0).getFirstname(),
																	teacher.get(0).getLastname(),
																	assignment.getName(),
																	dueDate,
																	submitted,
																	dateOfCreation,
																	dateOfSubmission,
																	gradeObtained,
																	assignment.getGrade(),
																	grader.getId(),
																	grader.getFirstname(),
																	grader.getLastname()
																	));
					
		}
		
		return studentSubjectReport;
	}
	
	public List<Students> getTeacherOfCourse(Long courseId) {
		List<MoodleEnrollement> enrolls = moodleEnrollmentRepo.findByCourseid(courseId);
		List<MoodleUserEnrollment> userenrolls = new ArrayList<MoodleUserEnrollment>();
		List<Students> studs = new ArrayList<Students>();
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
				if(role.get().getShortname().equals("editingteacher"))
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
	
	public String getDateFromUnixDate(Long unixDate) {
		Date date = new Date(unixDate*1000);
		
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String stringDate = formatter.format(date);
	    return stringDate;
	}

	@Override
	public List<StudentSubjectReportData> getReportForPendingAssignments(Long userId) {
		List<StudentSubjectReportData> pendingAssignmentsReport = new ArrayList<StudentSubjectReportData>();
		List<StudentSubjectReportData> tempPendingAssigns = new ArrayList<StudentSubjectReportData>();
		List<CoursesOfStudentData> coursesOfStudent = getAllCoursesOfStudent(userId);
		
		for (CoursesOfStudentData courseElement : coursesOfStudent) {
			MoodleCourse course = moodleCourseRepo.findAllByShortname(courseElement.getCourseCode());
			tempPendingAssigns = getStudentSubjectReport(userId, course.getId());
			
			for (StudentSubjectReportData tempElement : tempPendingAssigns) {
				if (!tempElement.getSubmitted()) {
					pendingAssignmentsReport.add(tempElement);
				}
			}
		}
		
		
		return pendingAssignmentsReport;
	}

	@Override
	public Integer getNumberOfPendingAssignments(Long userId) {
		Integer numOfPendingAssignments = 0;
		List<StudentSubjectReportData> pendingAssignments = getReportForPendingAssignments(userId);
		numOfPendingAssignments = pendingAssignments.size();
		
		return numOfPendingAssignments;
	}

	

	@Override
	public List<Assignment> getAssignmentsOfCourse(Long id)
	{
		Optional<List<MoodleAssign>> assn = moodleAssignRepo.findByCourse(id);
		List<Assignment> res =  new ArrayList<Assignment>();
		if(!assn.isPresent())
			return res;
		for(MoodleAssign curr : assn.get())
		{
			res.add(new Assignment(curr.getId(), curr.getCourse(), curr.getName(),getDateFromUnixDate(curr.getDuedate())));
		}
		return res;
	}
	

	
	@Override
	public	List<List<TeacherReportData>> getTeachersReport(Long courseId,Long studentId,Long assnId)
	{
		List<List<TeacherReportData>> ans = new ArrayList<List<TeacherReportData>>();
		String courseName = moodleCourseRepo.findById(courseId).get().getFullname();
		
		// collecting list of all students whose data is required
		List<Students> studIds = new ArrayList<Students>();
		if(studentId!=0)
		{
			MoodleUser user = moodleUserRepo.findById(studentId).get();
			studIds.add(new Students(user.getId(),user.getUsername(),user.getFirstname(),user.getLastname()));
		}
		else
		{
			studIds = moodleGradeServiceImpl.getAllStudentsOfCourse(courseId);
		}
		
		// collecting list of all assns whose data is required
		List<Assignment> assns = new ArrayList<Assignment>();
		if(assnId!=0)
		{
			MoodleAssign curr = moodleAssignRepo.findById(assnId).get();
			assns.add(new Assignment(curr.getId(), curr.getCourse(), curr.getName(),getDateFromUnixDate(curr.getDuedate())));
		}
		else
			assns = getAssignmentsOfCourse(courseId);
		
		// generating final data
		for(Students stud : studIds)
		{
			List<TeacherReportData> currans = new ArrayList<TeacherReportData>();
			for(Assignment assn : assns)
			{
				MoodleAssignSubmission sub = moodleAssignSubmissionRepo.findByUseridAndAssignmentOrderByAttemptnumberDesc(
						stud.getId(), assn.getAssignId()).get().get(0);


				Optional<MoodleAssignGrades> grade = moodleAssignGradesRepo.findByUseridAndAssignmentAndAttemptnumber(
						sub.getUserid(),sub.getAssignment(),sub.getAttemptnumber());
				
				TeacherReportData toAdd;
				if(!grade.isPresent())
				{
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),null,null,
							getDateFromUnixDate(sub.getTimecreated()),
							(sub.getStatus().equals("new")?null:getDateFromUnixDate(sub.getTimemodified())),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true));
				}
				else
				{
					MoodleUser grader = moodleUserRepo.findById(grade.get().getGrader()).get();
					String graderName = grader.getFirstname() + " " + grader.getLastname();
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),
							graderName,grade.get().getGrade(),getDateFromUnixDate(sub.getTimecreated()),
							(sub.getStatus().equals("new")?null:getDateFromUnixDate(sub.getTimemodified())),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true));
				}
				currans.add(toAdd);
			}
			ans.add(currans);
		}
		return ans;
	}
}
