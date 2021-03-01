package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.Students;

@Service
public interface moodleGradeService {

	List<Course> getAllCoursesByGrader(String username);

	List<Students> getAllStudentsOfCourse(Long courseId);

}
