package sgsits.cse.dis.moodle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.response.GradeItemsData;
import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.response.StudentOverviewReport;
import sgsits.cse.dis.moodle.service.moodleGradeService;
import sgsits.cse.dis.moodle.constants.GradesURLConstants;
import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.Students;
import sgsits.cse.dis.moodle.response.TagData;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/grades")
public class MoodleGradesController {
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	private moodleGradeService moodleGradeServiceImpl;
	
	// This API return's the moodle's database userid of a username. This is a general purpose API not related to only grades.
	@ApiOperation(value = "Get Student's user id", response = Long.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_STUDENTS_USER_ID, produces = "application/json")
	public ResponseEntity<Long> getStudentsUserId(@PathVariable("username") String username, HttpServletRequest request) throws NotFoundException {
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<Long>(moodleGradeServiceImpl.getStudentsUserId(username),HttpStatus.OK);
	}
	
	// This API return's the moodle's database userid of a DIS userid. This is a general purpose API not related to only grades.
	@ApiOperation(value = "Get Moodle's user id", response = Long.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_MOODLE_USER_ID, produces = "application/json")
	public ResponseEntity<Long> getMoodleUserId(HttpServletRequest request) throws NotFoundException {
		String username=jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<Long>(moodleGradeServiceImpl.getStudentsUserId(username),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Grade Items Of Course", response = GradeItemsData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_GRADE_ITEMS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<GradeItemsData>> getGradeItemsOfCourse(@PathVariable("courseid") String courseId, HttpServletRequest request) throws NotFoundException {
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<GradeItemsData>>(moodleGradeServiceImpl.getGradeItemsOfCourse(courseId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Grader Report", response = GraderReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_GRADER_REPORT, produces = "application/json")
	public ResponseEntity<List<List<GraderReportData>>> getGraderReport(@PathVariable("courseid") Long courseId, @PathVariable("itemid") Long itemId, HttpServletRequest request) throws NotFoundException {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<List<GraderReportData>>>(moodleGradeServiceImpl.getGraderReport(courseId, itemId,userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Teacher's User Report", response = GraderReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_USER_REPORT, produces = "application/json")
	public ResponseEntity<List<List<GraderReportData>>> getUserReport(@PathVariable("courseid") Long courseId, @PathVariable("userid") Long userId, HttpServletRequest request) throws NotFoundException  {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<List<GraderReportData>>>(moodleGradeServiceImpl.getUserReport(courseId, userId, userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all courses by a grader", response = Course.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_COURSES_BY_GRADER, produces = "application/json")
	public ResponseEntity<List<Course>> getAllCoursesByGrader(@PathVariable("username") String username, HttpServletRequest request) throws NotFoundException  {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<Course>>(moodleGradeServiceImpl.getAllCoursesByGrader(username, userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all students of a course", response = Students.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_STUDENTS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<Students>> getAllStudentsOfCourse(@PathVariable("courseId") Long courseId, HttpServletRequest request) throws NotFoundException {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<Students>>(moodleGradeServiceImpl.getAllStudentsOfCourse(courseId, userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get student's overview report", response = StudentOverviewReport.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_STUDENTS_OVREVIEW_REPORT, produces = "application/json")
	public ResponseEntity<List<StudentOverviewReport>> getStudentsOverviewReport(HttpServletRequest request) throws NotFoundException{
		String username = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		Long userId = moodleGradeServiceImpl.getStudentsUserId(username);
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<StudentOverviewReport>>(moodleGradeServiceImpl.getStudentsOverviewReport(userId,userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Student's User Report", response = GraderReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_STUDENTS_USER_REPORT, produces = "application/json")
	public ResponseEntity<List<GraderReportData>> getStudentsUserReport(@PathVariable("courseid") Long courseId, HttpServletRequest request) throws NotFoundException{
		String username = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		Long userId = moodleGradeServiceImpl.getStudentsUserId(username);
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<GraderReportData>>(moodleGradeServiceImpl.getStudentsUserReport(courseId, userId, userType),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get All Tags Of Course", response = TagData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_ALL_TAGS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<TagData>> getAllTagsOfCourse(@PathVariable("courseid") Long courseId, HttpServletRequest request) throws NotFoundException{
		String username = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		Long userId = moodleGradeServiceImpl.getStudentsUserId(username);
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<List<TagData>>(moodleGradeServiceImpl.getAllTagsOfCourse(courseId, userId, userType),HttpStatus.OK);
	}
}
