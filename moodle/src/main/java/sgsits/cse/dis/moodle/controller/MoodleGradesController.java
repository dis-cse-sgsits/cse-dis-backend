package sgsits.cse.dis.moodle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.moodle.constants.GradesURLConstants;
import sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.Students;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/grades")
public class MoodleGradesController {
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	private moodleGradeService gradeServiceImpl;
	
	@ApiOperation(value = "Get all courses by a grader", response = Course.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_COURSES_BY_GRADER, produces = "application/json")
	public ResponseEntity<List<Course>> getAllCoursesByGrader(@PathVariable("username") String username) {
		return new ResponseEntity<List<Course>>(gradeServiceImpl.getAllCoursesByGrader(username),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all students of a course", response = Students.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_STUDENTS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<Students>> getAllStudentsOfCourse(@PathVariable("courseId") Long courseId) {
		return new ResponseEntity<List<Students>>(gradeServiceImpl.getAllStudentsOfCourse(courseId),HttpStatus.OK);
	}
}
