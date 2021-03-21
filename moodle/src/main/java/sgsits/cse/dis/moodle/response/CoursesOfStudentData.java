package sgsits.cse.dis.moodle.response;

public class CoursesOfStudentData {
	private Long userId,courseId;
	private String courseCode;
	private String courseName;
	
	public CoursesOfStudentData(Long userId, String courseCode, String courseName,Long courseId) {
		super();
		this.userId = userId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseId = courseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
}
