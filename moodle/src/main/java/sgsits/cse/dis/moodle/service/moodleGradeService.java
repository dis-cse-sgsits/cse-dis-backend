package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;


import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.response.StudentOverviewReport;
import sgsits.cse.dis.moodle.response.GradeItemsData;

import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.Students;


@Service
public interface moodleGradeService {
	List<GradeItemsData> getGradeItemsOfCourse(String courseId);

	List<List<GraderReportData>> getGraderReport(String courseId, String itemId);

	List<List<GraderReportData>> getUserReport(String courseId, String userId);

	List<Course> getAllCoursesByGrader(String username);

	List<Students> getAllStudentsOfCourse(Long courseId);
	
	List<StudentOverviewReport> getStudentsOverviewReport(Long userId);

	List<GraderReportData> getStudentsUserReport(String courseId, String userId);
}
