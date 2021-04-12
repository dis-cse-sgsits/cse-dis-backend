package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;


import sgsits.cse.dis.moodle.response.CoursesOfStudentData;
import sgsits.cse.dis.moodle.response.StudentSubjectReportData;
import sgsits.cse.dis.moodle.exception.NotFoundException;
import sgsits.cse.dis.moodle.response.Assignment;
import sgsits.cse.dis.moodle.response.TeacherReportData;

@Service
public interface moodleAssignmentService {

	List<CoursesOfStudentData> getAllCoursesOfStudent(Long userId, String userType) throws NotFoundException;

	List<StudentSubjectReportData> getStudentSubjectReport(Long userId, Long courseId, String userType)  throws NotFoundException;

	List<StudentSubjectReportData> getReportForPendingAssignments(Long userId, String userType) throws NotFoundException;

	Integer getNumberOfPendingAssignments(Long userId, String userType) throws NotFoundException;


	List<Assignment> getAssignmentsOfCourse(Long id, String userType) throws NotFoundException;
	List<List<TeacherReportData>> getTeachersReport(Long courseId,Long studentId,Long assnId,String userType) throws NotFoundException;

}
