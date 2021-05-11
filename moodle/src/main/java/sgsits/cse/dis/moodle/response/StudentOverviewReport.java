package sgsits.cse.dis.moodle.response;

public class StudentOverviewReport {
	private String courseName;
	private Double grade,maxGrade;
	private Long courseId;
	
	public StudentOverviewReport(String courseName, Double grade, Long courseId,Double maxGrade) {
		super();
		this.courseName = courseName;
		this.grade = grade;
		this.courseId = courseId;
		this.maxGrade = maxGrade;
	}
	
	public Double getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(Double maxGrade) {
		this.maxGrade = maxGrade;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
}
