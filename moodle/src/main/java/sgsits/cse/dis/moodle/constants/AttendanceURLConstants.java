package sgsits.cse.dis.moodle.constants;

public class AttendanceURLConstants {
	public static final String GET_USER_COURSE_DETAIL="/getUserCourseDetail/";
	public static final String GET_ALL_STUDENT_ATTENDANCE_DETAILS_SUBJECTWISE="/getAllStudentAttendance/";
	public static final String GET_ALL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE="/getAllStudentTotalAttendance/";
	public static final String GET_INDIVIDUAL_STUDENT_TOTAL_ATTENDANCE_DETAILS_SUBJECTWISE="/getIndividualStudentAttendance/";
	public static final String GET_ALL_TABLEID="/getAllStudent/{username}/{coursecode}";
    public static final String GET_TOTAL_BULK_SLOT="/getBulkSlot/{username}/{coursecode}";
    public static final String GET_COURSE_CATEGORY_LIST="/getCourseCategoryList/";
    public static final String GET_CATEGORY_COURSE_NAME_LIST="/getCategoryCourseNameList/{categoryId}";
    public static final String GET_STUDENT_LESS_PERCENTAGE_LIST="/getStudentAttendancePercentageList/{categoryid}/{courseid}/{percentage}";
}
