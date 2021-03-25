package sgsits.cse.dis.moodle.constants;

public class AssignmentsURLConstants {

	
	public static final String GET_ALL_COURSES_OF_STUDENT = "/getAllCoursesOfStudent/{userid}";
	public static final String GET_STUDENT_SUBJECT_REPORT = "/getStudentSubjectReport/{userid}/{courseid}";
	public static final String GET_REPORT_FOR_PENDING_ASSIGNMENTS = "/getReportForPendingAssignments/{userid}";
	public static final String GET_NUMBER_OF_PENDING_ASSIGNMENTS = "/getNumberOfPendingAssignments/{userid}";

	public static final String GET_ASSIGNMENTS_OF_COURSE = "/getAssignmentsOfCourse/{courseid}";
	public static final String GET_TEACHERS_REPORT = "/getTeachersReport/{courseid}/{studentid}/{assnid}";
}
