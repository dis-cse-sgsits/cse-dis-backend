package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;


import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.response.StudentOverviewReport;
import sgsits.cse.dis.moodle.response.GradeItemsData;
import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.Students;


@Service
public interface moodleGradeService {
	List<GradeItemsData> getGradeItemsOfCourse(String courseId);

	List<List<GraderReportData>> getGraderReport(Long courseId, Long itemId, String userType) throws NotFoundException;

	List<List<GraderReportData>> getUserReport(Long courseId, Long userId, String userType) throws NotFoundException;

	List<Course> getAllCoursesByGrader(String username, String userType) throws NotFoundException;

	List<Students> getAllStudentsOfCourse(Long courseId, String userType) throws NotFoundException;
	
	List<StudentOverviewReport> getStudentsOverviewReport(Long userId,String userType) throws NotFoundException;

	List<GraderReportData> getStudentsUserReport(Long courseId, Long userId, String userType) throws NotFoundException;
	
	Long getStudentsUserId(String username) throws NotFoundException;
}
