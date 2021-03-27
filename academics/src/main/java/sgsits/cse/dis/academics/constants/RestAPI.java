package sgsits.cse.dis.academics.constants;

public class RestAPI {

	public static final String GET_SEM_TIME_TABLE_SETTINGS = "/getSemTimeTableSettings";
	public static final String SAVE_SEM_TIME_TABLE_SETTINGS = "/saveSemTimeTableSettings";
	public static final String GET_FACULTY_NAME_LIST = "/getFacultyNameList";
	public static final String GET_COURSE_NAME_BY_COURSE_ID = "getCourseNameByCourseId/{courseId}";
	public static final String GET_COURSE_ID_BY_COURSE_NAME = "getCourseIdByCourseName/{courseName}";
	public static final String GET_COURSE_LIST = "/getCourseList";
	public static final String GET_SUBJECT_CODES_LIST_BY_YEAR_AND_SEMESTER = "getSubjectCodesListByYearAndSemsterAndCourse/{year}/{sem}/{course}";
	public static final String GET_INFRASTRUCTURE_BY_TYPE = "/getInfrastructureByType/{type}";
	public static final String ADD_SEMESTER_TIME_TABLE = "/addSemTimeTable";
	public static final String GET_SUBJECT_CODES_BY_FACULTY_ID_AND_SESSION = "/getSubjectCodesByFacultyIdAndSession/{facultyId}/{session}";
	public static final String GET_TIMETABLE_BY_FACULTY_ID_SESSION_AND_SUBJECT_CODE = "/getTimeTableByFacultyIdSessionAndSubjectCode/{facultyId}/{session}/{subjectCode}";
	public static final String ADD_EXPERT = "/addExpert";
	public static final String ADD_EXPERT_LECTURE = "/addExpertLecture";
	public static final String GET_EXPERT_LECTURES_BY_STATUS = "/getExpertLecturesByStatus/{status}";
	public static final String VIEW_EXPERT_LECTURE_DETAILS = "/viewExpertLectureDetails/{expertLectureId}";
	public static final String GET_EXPERT_NAMES_AND_DESIGNATIONS = "/getExpertNamesAndDesignations";
	public static final String EDIT_EXPERT = "/editExpert";
	public static final String FIND_EXPERT = "/findExpert";
	public static final String SEARCH_EXPERT_LECTURES = "/searchExpertLectures";
	public static final String UPDATE_EXPERT_LECTURE_STATUS = "/updateExpertLectureStatus/{expertLectureId}";
    public static final String FETCH_ME_STUDENTS_BY_YEAR = "/fetchMEStudentsByYear/{year}";
	public static final String APPROVE_STUDENTS_FOR_SCHOLARSHIP = "/grantScholarship";
	public static final String VIEW_SCHOLARSHIP_STUDENTS = "/viewScholarshipStudents/{year}";
	public static final String CANCEL_SCHOLARSHIP = "/cancelScholarship";
    public static final String DELETE_EXPERT = "/deleteExpert";
    public static final String ADD_INDUSTRY_VISIT = "/addIndustryVisit";
    public static final String GET_INDUSTRY_VISITS = "/getIndustryVisits/{status}";
    public static final String VIEW_INDUSTRY_VISIT_DETAILS = "/viewIndustryVisitDetails";
	public static final String SEARCH_INDUSTRY_VISITS = "/searchIndustryVisits";
	public static final String UPDATE_INDUSTRY_VISIT_STATUS = "/updateIndustryVisitStatus";
	public static final String EDIT_INDUSTRY_VISIT = "/editIndustryVisit";
	public static final String DELETE_INDUSTRY_VISIT = "/deleteIndustryVisit";
    public static final String EDIT_EXPERT_LECTURE = "/editExpertLecture";
	public static final String DELETE_EXPERT_LECTURE = "/deleteExpertLecture";
}
