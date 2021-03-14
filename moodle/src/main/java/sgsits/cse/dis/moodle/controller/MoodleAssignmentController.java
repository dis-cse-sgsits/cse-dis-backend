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
