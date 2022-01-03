package sgsits.cse.dis.moodle.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.StudentOverallAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacherBulk;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleCourseCategories;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.MoodleCourseCategoriesResponse;
import sgsits.cse.dis.moodle.response.MoodleTeacherAttendanceData;

@Service
public interface moodleAttendanceService {
	public List<StudentAttendanceData> getAllStudentDetails(String coursecode,String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(String userid,String userType) throws NotFoundException;
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException;
	public List<Course> getIndividualUserCourseDetails(String username) throws NotFoundException;
	public Long  getTableid(String username,String coursename);
	public List<MoodleTeacherAttendanceData> CalculateTeacherBulkAttendance(String coursecode,String username);
	public List<MoodleCourseCategories>   getCourseCategoryList();
	public List<MoodleCourse>  getCourseCategoryNameList(Long categoryId);
	public List<List<MoodleCourseCategoriesResponse>> getLessStudentAttendancePercentageList(Long categoryId,String userId,Double percentage,String usertype) throws NotFoundException;
	public List<List<StudentOverallAttendanceData>> getOverallStudentAttendancePercentageAndCount(Long categoryid,String userId,Double percentage,String usertype) throws NotFoundException;
}
