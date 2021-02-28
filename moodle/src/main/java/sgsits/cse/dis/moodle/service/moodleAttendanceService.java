package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;

@Service
public interface moodleAttendanceService {
	//List<MoodleUser> getAllStudentAttendanceListByUsername(String username) throws EventDoesNotExistException;
    //List<MoodleUser> getAllStudentAttendance();
    //List<MoodleAttendanceUser> getAllStudentCourse();
	//public List<StudentAttendanceData> getStudentAttendance();
	//public List<StudentAttendanceData> getStudentAttendanceList(String username,String coursename);
	public List<StudentAttendanceData> getAllStudentDetails(String coursecode,String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException;
	public List<String> getIndividualUserGradeCategory(String userid) throws NotFoundException;
	public List<String> getIndividualUserGradeCategoryName(String userid) throws NotFoundException;
	public List<Long> getTableid(String username,String coursename);
	
}
