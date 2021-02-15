package sgsits.cse.dis.moodle.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.moodle.constants.AttendanceURLConstants;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.serviceImpl.moodleServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/moodle")
public class MoodleAttendanceController {
	@Autowired
	public  moodleServicesImpl moodleServicesImpl;
		/*
	@GetMapping(path=AttendanceURLConstants.GET_STUDENT_ID, produces = "application/json")
	public  ResponseEntity<List<MoodleUser>> getAllStudentAttendance(){
		List<MoodleUser> MoodleUser = new ArrayList<>();
		MoodleUser = moodleServicesImpl.getAllStudentAttendance();
		return new ResponseEntity<List<MoodleUser>>(MoodleUser,HttpStatus.OK);
	}
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_COURSEID,produces = "application/json")
	public  ResponseEntity<List<MoodleAttendanceUser>> getAllStudentCourse(){
		List<MoodleAttendanceUser> MoodleAttendanceUser = new ArrayList<>();
		MoodleAttendanceUser = moodleServicesImpl.getAllStudentCourse();
		return new ResponseEntity<List<MoodleAttendanceUser>>(MoodleAttendanceUser,HttpStatus.OK);
}
@ApiOperation(value = "Get faculty rooms", response = RoomAssociationData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_ROOMS,produces="application/json")
	public List<RoomAssociationData> getRoomsAndAssociation(){
		return infrastructureService.getRooms();
	}

	
	@ApiOperation(value = "Get Student Attendance List", response = StudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_STUDENT_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<StudentAttendanceData> getStudentAttendanceList(@PathVariable("username") String username,@PathVariable("coursename") String coursename){
		return moodleServicesImpl.getStudentAttendanceList(username,coursename);
		
	}
	
*/
	@ApiOperation(value = "Get Student Attendance Detail List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_TABLEID,produces="application/json")
	public List<Long> getTableid(@PathVariable("username") String username,@PathVariable("coursecode") String coursecode){
		return moodleServicesImpl.getTableid(username,coursecode);
	}
	
	@ApiOperation(value = "Get Student Attendance Detail List Date wise", response = StudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<StudentAttendanceData> getAllStudentDetails(@PathVariable("username") String username,@PathVariable("coursecode") String coursecode){
		return moodleServicesImpl.getAllStudentDetails(username,coursecode);
	}
	
	@ApiOperation(value = "Get All Student Attendance Detail List", response = TotalStudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(@PathVariable("username") String username,@PathVariable("coursecode") String coursecode){
		return moodleServicesImpl.getAllStudentTotalAttendance(username,coursecode);
	}
	@ApiOperation(value = "Get Individual Student Attendance Subjectwise", response = TotalStudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_INDIVIDUAL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(@PathVariable("username") String username){
		return moodleServicesImpl.getIndividualStudentAttendance(username);
	}
	
}
