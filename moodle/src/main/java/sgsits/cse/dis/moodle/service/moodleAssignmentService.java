package sgsits.cse.dis.moodle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.moodle.response.Assignment;
import sgsits.cse.dis.moodle.response.TeacherReportData;

@Service
public interface moodleAssignmentService {
	List<Assignment> getAssignmentsOfCourse(Long id);
	List<List<TeacherReportData>> getTeachersReport(Long courseId,Long studentId,Long assnId);
}
