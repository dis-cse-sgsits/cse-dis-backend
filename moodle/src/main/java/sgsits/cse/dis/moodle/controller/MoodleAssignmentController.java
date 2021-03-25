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
import sgsits.cse.dis.moodle.constants.AssignmentsURLConstants;
import sgsits.cse.dis.moodle.jwt.JwtResolver;

import sgsits.cse.dis.moodle.response.CoursesOfStudentData;
import sgsits.cse.dis.moodle.response.StudentSubjectReportData;

import sgsits.cse.dis.moodle.response.Assignment;
import sgsits.cse.dis.moodle.response.TeacherReportData;

import sgsits.cse.dis.moodle.service.moodleAssignmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/assns")
public class MoodleAssignmentController {
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private moodleAssignmentService moodleAssignmentServiceImpl;
	

	@ApiOperation(value = "Get All Courses Of Student", response = CoursesOfStudentData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_ALL_COURSES_OF_STUDENT, produces = "application/json")
	public ResponseEntity<List<CoursesOfStudentData>> getAllCoursesOfStudent(@PathVariable("userid") Long userId) {
		return new ResponseEntity<List<CoursesOfStudentData>>(moodleAssignmentServiceImpl.getAllCoursesOfStudent(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Student Subject Report", response = StudentSubjectReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_STUDENT_SUBJECT_REPORT, produces = "application/json")
	public ResponseEntity<List<StudentSubjectReportData>> getStudentSubjectReport(@PathVariable("userid") Long userId, @PathVariable("courseid") Long courseId) {
		return new ResponseEntity<List<StudentSubjectReportData>>(moodleAssignmentServiceImpl.getStudentSubjectReport(userId, courseId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Report For Pending Assignments", response = StudentSubjectReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_REPORT_FOR_PENDING_ASSIGNMENTS, produces = "application/json")
	public ResponseEntity<List<StudentSubjectReportData>> getReportForPendingAssignments(@PathVariable("userid") Long userId) {
		return new ResponseEntity<List<StudentSubjectReportData>>(moodleAssignmentServiceImpl.getReportForPendingAssignments(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Number Of Pending Assignments", response = Integer.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_NUMBER_OF_PENDING_ASSIGNMENTS, produces = "application/json")
	public ResponseEntity<Integer> getNumberOfPendingAssignments(@PathVariable("userid") Long userId) {
		return new ResponseEntity<Integer>(moodleAssignmentServiceImpl.getNumberOfPendingAssignments(userId),HttpStatus.OK);
	}

	@ApiOperation(value = "Get Grade Items Of Course", response = Assignment.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_ASSIGNMENTS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<Assignment>> getAssignmentOfCourse(@PathVariable("courseid") Long courseId)
	{
		return new ResponseEntity<List<Assignment>>(moodleAssignmentServiceImpl.getAssignmentsOfCourse(courseId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get teacher's report", response = TeacherReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = AssignmentsURLConstants.GET_TEACHERS_REPORT, produces = "application/json")
	public ResponseEntity<List<List<TeacherReportData>>> getTeachersReport(@PathVariable("courseid") Long courseId,@PathVariable("studentid") Long studentId,@PathVariable("assnid") Long assnId)
	{
		return new ResponseEntity<List<List<TeacherReportData>>>(moodleAssignmentServiceImpl.getTeachersReport(courseId,studentId,assnId), HttpStatus.OK);
	}
}
