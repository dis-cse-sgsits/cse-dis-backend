package sgsits.cse.dis.moodle.response;

public class GraderReportData {
	private Long userId;
	private String firstName;
	private String lastName;
	private String courseCode;
	private String courseName;
	private String gradeItemName;
	private Double gradeObtained;
	private Double gradeTotal;
	private Double percentage;
	
	public GraderReportData(Long userId, String firstName, String lastName, String courseCode, String courseName,
			String gradeItemName, Double gradeObtained, Double gradeTotal, Double percentage) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.gradeItemName = gradeItemName;
		this.gradeObtained = gradeObtained;
		this.gradeTotal = gradeTotal;
		this.percentage = percentage;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getGradeItemName() {
		return gradeItemName;
	}

	public void setGradeItemName(String gradeItemName) {
		this.gradeItemName = gradeItemName;
	}

	public Double getGradeObtained() {
		return gradeObtained;
	}

	public void setGradeObtained(Double gradeObtained) {
		this.gradeObtained = gradeObtained;
	}

	public Double getGradeTotal() {
		return gradeTotal;
	}

	public void setGradeTotal(Double gradeTotal) {
		this.gradeTotal = gradeTotal;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
}
