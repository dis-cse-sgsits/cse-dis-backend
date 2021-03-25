package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;


import sgsits.cse.dis.moodle.response.CoursesOfStudentData;
import sgsits.cse.dis.moodle.response.StudentSubjectReportData;
import sgsits.cse.dis.moodle.response.Assignment;
import sgsits.cse.dis.moodle.response.TeacherReportData;

@Service
public interface moodleAssignmentService {

	List<CoursesOfStudentData> getAllCoursesOfStudent(Long userId);

	List<StudentSubjectReportData> getStudentSubjectReport(Long userId, Long courseId);

	List<StudentSubjectReportData> getReportForPendingAssignments(Long userId);

	Integer getNumberOfPendingAssignments(Long userId);


	List<Assignment> getAssignmentsOfCourse(Long id);
	List<List<TeacherReportData>> getTeachersReport(Long courseId,Long studentId,Long assnId);

}
