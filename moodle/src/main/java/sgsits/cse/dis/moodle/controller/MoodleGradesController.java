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
import sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.response.GradeItemsData;
import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.service.moodleGradeService;
import sgsits.cse.dis.moodle.constants.GradesURLConstants;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/grades")
public class MoodleGradesController {
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	private moodleGradeService moodleGradeServiceImpl;
	
	@ApiOperation(value = "Get Grade Items Of Course", response = GradeItemsData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_GRADE_ITEMS_OF_COURSE, produces = "application/json")
	public ResponseEntity<List<GradeItemsData>> getGradeItemsOfCourse(@PathVariable("courseid") String courseId) {
		return new ResponseEntity<List<GradeItemsData>>(moodleGradeServiceImpl.getGradeItemsOfCourse(courseId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Grader Report", response = GraderReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_GRADER_REPORT, produces = "application/json")
	public ResponseEntity<List<List<GraderReportData>>> getGraderReport(@PathVariable("courseid") String courseId, @PathVariable("itemid") String itemId) {
		return new ResponseEntity<List<List<GraderReportData>>>(moodleGradeServiceImpl.getGraderReport(courseId, itemId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get User Report", response = GraderReportData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = GradesURLConstants.GET_USER_REPORT, produces = "application/json")
	public ResponseEntity<List<List<GraderReportData>>> getUserReport(@PathVariable("courseid") String courseId, @PathVariable("userid") String userId) {
		return new ResponseEntity<List<List<GraderReportData>>>(moodleGradeServiceImpl.getUserReport(courseId, userId),HttpStatus.OK);
	}
}
