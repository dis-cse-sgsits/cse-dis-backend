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
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.repo.MoodleAssignGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignRepo;
import sgsits.cse.dis.moodle.repo.MoodleAssignSubmissionRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.Assignment;
import sgsits.cse.dis.moodle.response.Students;
import sgsits.cse.dis.moodle.response.TeacherReportData;
import sgsits.cse.dis.moodle.service.moodleAssignmentService;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@Component
public class moodleAssignmentServiceImpl implements moodleAssignmentService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MoodleAssignRepo moodleAssignRepo;
	@Autowired
	private MoodleUserRepo moodleUserRepo;
	@Autowired
	private moodleGradeService moodleGradeServiceImpl;
	@Autowired
	private MoodleAssignGradesRepo moodleAssignGradesRepo;
	@Autowired
	private MoodleCourseRepo moodleCourseRepo;
	@Autowired
	private MoodleAssignSubmissionRepo moodleAssignSubmissionRepo;

	@Override
	public List<Assignment> getAssignmentsOfCourse(Long id)
	{
		Optional<List<MoodleAssign>> assn = moodleAssignRepo.findByCourse(id);
		List<Assignment> res =  new ArrayList<Assignment>();
		if(assn.isEmpty())
			return res;
		for(MoodleAssign curr : assn.get())
		{
			res.add(new Assignment(curr.getId(), curr.getCourse(), curr.getName(),getDateFromUnixDate(curr.getDuedate())));
		}
		return res;
	}
	
	public String getDateFromUnixDate(Long unixDate) {
        Date date = new Date(unixDate*1000);
        
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = formatter.format(date);
        return stringDate;
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
				if(grade.isEmpty())
				{
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),null,null,
							getDateFromUnixDate(sub.getTimecreated()),getDateFromUnixDate(sub.getTimemodified()),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true));
				}
				else
				{
					MoodleUser grader = moodleUserRepo.findById(grade.get().getGrader()).get();
					String graderName = grader.getFirstname() + " " + grader.getLastname();
					toAdd = new TeacherReportData(
							stud.getFirstname()+" "+stud.getLastname(),courseName,assn.getAssignName(),graderName,
							grade.get().getGrade(),getDateFromUnixDate(sub.getTimecreated()),
							getDateFromUnixDate(sub.getTimemodified()),
							assn.getDueDate(),(sub.getStatus().equals("new")?false:true));
				}
				currans.add(toAdd);
			}
			ans.add(currans);
		}
		return ans;
	}
}
