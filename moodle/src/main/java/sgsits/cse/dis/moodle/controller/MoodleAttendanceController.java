package sgsits.cse.dis.moodle.controller;



import java.util.HashSet;
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
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.MoodleCourseCategoriesResponse;
import sgsits.cse.dis.moodle.response.MoodleTeacherAttendanceData;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.serviceImpl.moodleAttendanceServicesImpl;
import  sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacherBulk;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleCourseCategories;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/moodle")
public class MoodleAttendanceController {
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	public  moodleAttendanceServicesImpl moodleAttendanceServicesImpl;
	
	@ApiOperation(value = "Get Student Attendance Detail List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_TABLEID,produces="application/json")
	public Long  getTableid(@PathVariable("username") String username,@PathVariable("coursecode") String coursecode){
		return moodleAttendanceServicesImpl.getTableid(username,coursecode);
	}
	@ApiOperation(value = "Get Student Attendance Detail List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_TOTAL_BULK_SLOT,produces="application/json")
	public List<MoodleTeacherAttendanceData> CalculateTeacherBulkAttendance(@PathVariable("username") String coursecode,@PathVariable("coursecode") String username){
		return moodleAttendanceServicesImpl.CalculateTeacherBulkAttendance(username,coursecode);
	}
	@ApiOperation(value = "Get Course Category List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_COURSE_CATEGORY_LIST,produces="application/json")
	public List<MoodleCourseCategories>   getCourseCategoryList(){
		return moodleAttendanceServicesImpl.getCourseCategoryList();
	}
	@ApiOperation(value = "Get Course Category List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_CATEGORY_COURSE_NAME_LIST,produces="application/json")
	public List<MoodleCourse>  getCourseCategoryNameList(@PathVariable("categoryId")Long categoryId){
		return moodleAttendanceServicesImpl.getCourseCategoryNameList(categoryId);
	}
	@ApiOperation(value = "Get Less Percentage Student Attendance List", httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_STUDENT_LESS_PERCENTAGE_LIST,produces="application/json")
	public List<List<MoodleCourseCategoriesResponse>> getLessStudentAttendancePercentageList(@PathVariable("categoryid")Long categoryId,@PathVariable("courseid")Long courseid,@PathVariable("percentage")Double percentage,HttpServletRequest request) throws NotFoundException{
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return moodleAttendanceServicesImpl.getLessStudentAttendancePercentageList(categoryId,courseid,userid,percentage,userType);
	}

	@ApiOperation(value = "Get User Enrolled Course Code", response = Course.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_USER_COURSE_DETAIL,produces="application/json")
	public List<Course>  getIndividualUserCourseDetails(HttpServletRequest request) throws NotFoundException {
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return  moodleAttendanceServicesImpl.getIndividualUserCourseDetails(userid);
	}
	
	@ApiOperation(value = "Get Student Attendance Detail List Date wise", response = StudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<StudentAttendanceData> getAllStudentDetails(@RequestParam(value="coursecode" , required=true) String coursecode,HttpServletRequest request) throws NotFoundException{
		String userid=jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return moodleAttendanceServicesImpl.getAllStudentDetails(coursecode,userid,userType);
	}
	
	@ApiOperation(value = "Get All Student Attendance Detail List", response = TotalStudentAttendanceData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=AttendanceURLConstants.GET_ALL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE,produces="application/json")
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(@RequestParam(value="coursecode", required= true) String coursecode,HttpServletRequest request) throws NotFoundException{
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
