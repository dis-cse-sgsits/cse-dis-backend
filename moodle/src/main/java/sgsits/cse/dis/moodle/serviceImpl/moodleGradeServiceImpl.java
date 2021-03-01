package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import sgsits.cse.dis.moodle.response.Students;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@Component
public class moodleGradeServiceImpl implements moodleGradeService, Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	public MoodleUserRepo moodleUserRepo;
	@Autowired
	public MoodleUserEnrollmentRepo moodleUserEnrollmentRepo;
	@Autowired
	public MoodleEnrollmentRepo moodleEnrollmentRepo;
	@Autowired
	public MoodleCourseRepo moodleCourseRepo;
	@Autowired
	public MoodleRoleAssignmentsRepo moodleRoleAssignmentsRepo;
	@Autowired
	public MoodleRoleRepo moodleRoleRepo;
	@Autowired
	public MoodleContextRepo moodlecontextRepo;

	@Override
	public List<Course> getAllCoursesByGrader(String username)
	{	
		Long userid = moodleUserRepo.findByUsername(username).get(0).getId();
		List<MoodleUserEnrollment> enrollList = moodleUserEnrollmentRepo.findByUserid(userid);
		List<Course> courses = new ArrayList<Course>();
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
	public List<Students> getAllStudentsOfCourse(Long courseId) {
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
			if(role_assn.isEmpty())
				continue;
			Long role_id = role_assn.get().getRoleid();
			return moodleRoleRepo.findById(role_id);
		}
		return null;
	}
}
