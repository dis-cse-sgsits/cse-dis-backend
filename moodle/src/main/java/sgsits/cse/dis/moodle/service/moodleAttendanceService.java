package sgsits.cse.dis.moodle.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.response.Course;

@Service
public interface moodleAttendanceService {
	public List<StudentAttendanceData> getAllStudentDetails(String coursecode,String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException;
	public List<Course> getIndividualUserCourseDetails(String username) throws NotFoundException;
	public List<Long> getTableid(String username,String coursename);
	
}
