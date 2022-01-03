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

import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.model.MoodleAssign;
import sgsits.cse.dis.moodle.model.MoodleAssignGrades;
import sgsits.cse.dis.moodle.model.MoodleAssignSubmission;

import sgsits.cse.dis.moodle.model.MoodleContext;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleCourseModules;
import sgsits.cse.dis.moodle.model.MoodleEnrollement;
import sgsits.cse.dis.moodle.model.MoodleGradeGrades;
import sgsits.cse.dis.moodle.model.MoodleGradeItems;
import sgsits.cse.dis.moodle.model.MoodleRole;
import sgsits.cse.dis.moodle.model.MoodleRoleAssignments;
import sgsits.cse.dis.moodle.model.MoodleTag;
import sgsits.cse.dis.moodle.model.MoodleTagInstance;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;
import sgsits.cse.dis.moodle.repo.MoodleAssignGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignSubmissionRepo;
import sgsits.cse.dis.moodle.repo.MoodleContextRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseModulesRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleGradeGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleGradeItemsRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleAssignmentsRepo;
import sgsits.cse.dis.moodle.repo.MoodleRoleRepo;
import sgsits.cse.dis.moodle.repo.MoodleTagInstanceRepo;
import sgsits.cse.dis.moodle.repo.MoodleTagRepo;
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
	private MoodleGradeGradesRepo moodleGradeGradesRepo;
	@Autowired
	private MoodleGradeItemsRepo moodleGradeItemsRepo;
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
	
	@Autowired
	public MoodleCourseModulesRepo moodleCourseModulesRepo;
	@Autowired
	public MoodleTagRepo moodleTagRepo;
	@Autowired
	public MoodleTagInstanceRepo moodleTagInstanceRepo;



	@Override
	public List<CoursesOfStudentData> getAllCoursesOfStudent(Long userId, String userType) throws NotFoundException{
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
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
			
			allCoursesOfStudent.add(new CoursesOfStudentData(userId, course.get(0).getIdnumber(), course.get(0).getFullname(),course.get(0).getId()));
		}
		
		return allCoursesOfStudent;
	}

	@Override
	public List<StudentSubjectReportData> getStudentSubjectReport(Long userId, Long courseId, String userType)  throws NotFoundException {
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
		List<StudentSubjectReportData> studentSubjectReport = new ArrayList<StudentSubjectReportData>();
		
		List<MoodleCourse> courseDetails = moodleCourseRepo.findAllById(courseId);
		List<Students> teacher = getTeacherOfCourse(courseId);
		
		Optional<List<MoodleAssign>> allAssignmentsOfCourse = moodleAssignRepo.findByCourse(courseId);
		
		for (MoodleAssign assignment : allAssignmentsOfCourse.get()) {
			List<MoodleAssignGrades> assignGrades = moodleAssignGradesRepo.findByAssignmentAndUseridOrderByAttemptnumberDesc(assignment.getId(), userId);
			
			List<MoodleAssignSubmission> assignSubmission = moodleAssignSubmissionRepo.findByAssignmentAndUserid(assignment.getId(), userId);
			
			Long tagId = 0L;
			String tagName = null;
			String tagRawName = null;
			Optional<MoodleCourseModules> courseModules = moodleCourseModulesRepo.findAllByInstanceAndCourse(assignment.getId(), courseId);
			if (courseModules.isPresent()) {
				Optional<MoodleTagInstance> tagInstance = moodleTagInstanceRepo.findAllByItemid(courseModules.get().getId());
				if (tagInstance.isPresent()) {
					Optional<MoodleTag> tagDetails = moodleTagRepo.findAllById(tagInstance.get().getTagid());
					if (tagDetails.isPresent()) {
						tagId = tagDetails.get().getId();
						tagName = tagDetails.get().getName();
						tagRawName = tagDetails.get().getRawname();
					}
				}
			}
			
			MoodleUser grader = new MoodleUser();
			Double gradeObtained = 0D;
			Optional<MoodleGradeItems> gradeItemsDetailed  ;
			 Optional<MoodleGradeGrades> gradeGradesDetails ;
			 gradeItemsDetailed  = moodleGradeItemsRepo.findByCourseidAndIteminstance(assignment.getCourse(), assignment.getId());
			 gradeGradesDetails = moodleGradeGradesRepo.findByItemidAndUserid(gradeItemsDetailed.get().getId(),userId);
			
			
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
			String dateOfSubmission = (submitted == false) ? "Not submitted" : getDateFromUnixDate(assignSubmission.get(0).getTimemodified());
			
			studentSubjectReport.add(new StudentSubjectReportData(courseId,
																	courseDetails.get(0).getIdnumber(),
																	courseDetails.get(0).getFullname(),
																	teacher.get(0).getId(),
																	teacher.get(0).getFirstname(),
																	teacher.get(0).getLastname(),
																	assignment.getName(),
																	dueDate,
																	submitted,
																	dateOfCreation,
																	dateOfSubmission,
																	(gradeObtained ==null || gradeObtained == -1D)?0D:(gradeGradesDetails.get().getFinalgrade()==null)?gradeObtained:gradeGradesDetails.get().getFinalgrade(),
																	assignment.getGrade(),
																	grader.getId(),
																	grader.getFirstname(),
																	grader.getLastname(),
																	tagId,
																	tagName,
																	tagRawName
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
				if(role.get().getShortname().equals("editingteacher")||role.get().getShortname().equals("teacher")||role.get().getShortname().equals("coursecreator"))
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
	public List<StudentSubjectReportData> getReportForPendingAssignments(Long userId, String userType) throws NotFoundException {
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
		List<StudentSubjectReportData> pendingAssignmentsReport = new ArrayList<StudentSubjectReportData>();
		List<StudentSubjectReportData> tempPendingAssigns = new ArrayList<StudentSubjectReportData>();
		List<CoursesOfStudentData> coursesOfStudent = getAllCoursesOfStudent(userId,userType);
		
		for (CoursesOfStudentData courseElement : coursesOfStudent) {
			MoodleCourse course = moodleCourseRepo.findByIdnumber(courseElement.getCourseCode());
			tempPendingAssigns = getStudentSubjectReport(userId, course.getId(), userType);
			
			for (StudentSubjectReportData tempElement : tempPendingAssigns) {
				if (!tempElement.getSubmitted()) {
					pendingAssignmentsReport.add(tempElement);
				}
			}
		}
		
		
		return pendingAssignmentsReport;
	}

	@Override
	public Integer getNumberOfPendingAssignments(Long userId, String userType) throws NotFoundException{
		if(!userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
		Integer numOfPendingAssignments = 0;
		List<StudentSubjectReportData> pendingAssignments = getReportForPendingAssignments(userId,userType);
		numOfPendingAssignments = pendingAssignments.size();
		
		return numOfPendingAssignments;
	}

	

	@Override
	public List<Assignment> getAssignmentsOfCourse(Long id, String userType) throws NotFoundException
	{
		if(userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
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
	public	List<List<TeacherReportData>> getTeachersReport(Long courseId,Long studentId,Long assnId,String userType) throws NotFoundException
	{
		if(userType.equals("student"))
            throw new  NotFoundException("Invalid User Type");
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
			studIds = moodleGradeServiceImpl.getAllStudentsOfCourse(courseId,userType);
		}
		
		// collecting list of all assns whose data is required
		List<Assignment> assns = new ArrayList<Assignment>();
		if(assnId!=0)
		{
			MoodleAssign curr = moodleAssignRepo.findById(assnId).get();
			assns.add(new Assignment(curr.getId(), curr.getCourse(), curr.getName(),getDateFromUnixDate(curr.getDuedate())));
		}
		else
			assns = getAssignmentsOfCourse(courseId, userType);
		
		// generating final data
		for(Students stud : studIds)
		{
			List<TeacherReportData> currans = new ArrayList<TeacherReportData>();
			
			
			for(Assignment assn : assns)
			{
				MoodleAssignSubmission sub = moodleAssignSubmissionRepo.findByUseridAndAssignmentOrderByAttemptnumberDesc(
						stud.getId(), assn.getAssignId()).get().get(0);

				Optional<MoodleGradeItems> gradeItemsDetailed  = moodleGradeItemsRepo.findByCourseidAndIteminstance(assn.getCourseId(), assn.getAssignId());
				 Optional<MoodleGradeGrades> gradeGradesDetails = moodleGradeGradesRepo.findByItemidAndUserid(gradeItemsDetailed.get().getId(),sub.getUserid());
					
				Optional<MoodleAssignGrades> grade = moodleAssignGradesRepo.findByUseridAndAssignmentAndAttemptnumber(
						sub.getUserid(),sub.getAssignment(),sub.getAttemptnumber());
				
				Long tagId = 0L;
				String tagName = null;
				String tagRawName = null;
				Optional<MoodleCourseModules> courseModules = moodleCourseModulesRepo.findAllByInstanceAndCourse(assn.getAssignId(), courseId);
				if (courseModules.isPresent()) {
					Optional<MoodleTagInstance> tagInstance = moodleTagInstanceRepo.findAllByItemid(courseModules.get().getId());
					if (tagInstance.isPresent()) {
						Optional<MoodleTag> tagDetails = moodleTagRepo.findAllById(tagInstance.get().getTagid());
						if (tagDetails.isPresent()) {
							tagId = tagDetails.get().getId();
							tagName = tagDetails.get().getName();
							tagRawName = tagDetails.get().getRawname();
						}
					}
				}
				
				
				TeacherReportData toAdd;
				if(!grade.isPresent()) {
				 
						
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),null,(gradeGradesDetails.get().getFinalgrade()==null)?0D:gradeGradesDetails.get().getFinalgrade(),
							getDateFromUnixDate(sub.getTimecreated()),
							(sub.getStatus().equals("new")?"Not Submitted":(gradeGradesDetails.get().getFinalgrade()!=null)?"submitted and graded":"submitted but not graded"),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true), tagId, tagName, tagRawName);
					
				
				}
				else
				{
					MoodleUser grader = moodleUserRepo.findById(grade.get().getGrader()).get();
					String graderName = grader.getFirstname() + " " + grader.getLastname();
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),
							graderName,(grade.get().getGrade()==null || grade.get().getGrade()==-1D)?(gradeGradesDetails.get().getFinalgrade()==null)?0D:gradeGradesDetails.get().getFinalgrade():grade.get().getGrade(),getDateFromUnixDate(sub.getTimecreated()),
							(sub.getStatus().equals("new")?"Not submitted":"submitted"),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true), tagId, tagName, tagRawName);
				}
				currans.add(toAdd);
			}
			ans.add(currans);
		}
		return ans;
	}
}
