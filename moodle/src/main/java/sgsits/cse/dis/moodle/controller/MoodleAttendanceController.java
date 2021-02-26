package sgsits.cse.dis.moodle.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.moodle.constants.AttendanceURLConstants;
import sgsits.cse.dis.moodle.feignClient.UserClient;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.serviceImpl.moodleAttendanceServicesImpl;
import  sgsits.cse.dis.moodle.jwt.JwtResolver;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/moodle")
public class MoodleAttendanceController {
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	public  moodleAttendanceServicesImpl moodleAttendanceServicesImpl;
	
	@ApiOperation(value = "Get Student Attendance Detail List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_TABLEID,produces="application/json")
	public List<Long> getTableid(@PathVariable("username") String username,@PathVariable("coursecode") String coursecode){
		return moodleAttendanceServicesImpl.getTableid(username,coursecode);
	}
	
	@ApiOperation(value = "Get Student Attendance Detail List Date wise", response = StudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<StudentAttendanceData> getAllStudentDetails(@RequestParam(value="coursecode") String coursecode,HttpServletRequest request) throws NotFoundException{
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return moodleAttendanceServicesImpl.getAllStudentDetails(coursecode,userid,userType);
	}
	
	@ApiOperation(value = "Get All Student Attendance Detail List", response = TotalStudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(@RequestParam(value="coursecode") String coursecode,HttpServletRequest request) throws NotFoundException{
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return moodleAttendanceServicesImpl.getAllStudentTotalAttendance(coursecode,userid,userType);
	}
	
	@ApiOperation(value = "Get Individual Student Attendance Subjectwise", response = TotalStudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_INDIVIDUAL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(HttpServletRequest request) throws NotFoundException{
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		    return  moodleAttendanceServicesImpl.getIndividualStudentAttendance(userid,userType);
		
		
	}
	
}
