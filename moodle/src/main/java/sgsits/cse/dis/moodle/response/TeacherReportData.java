package sgsits.cse.dis.moodle.response;

public class TeacherReportData {
	private String studentName,courseName,assnName,graderName;
	private Double grade;
	private String creationDate,submissionDate,dueDate;
	private Boolean submitted;
	private Long tagId;
	private String tagName;
	private String tagRawName;
	
	public TeacherReportData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TeacherReportData(String studentName, String courseName, String assnName, String graderName, Double grade,
			String creationDate, String submissionDate, String dueDate, Boolean submitted, Long tagId, String tagName,
			String tagRawName) {
		super();
		this.studentName = studentName;
		this.courseName = courseName;
		this.assnName = assnName;
		this.graderName = graderName;
		this.grade = grade;
		this.creationDate = creationDate;
		this.submissionDate = submissionDate;
		this.dueDate = dueDate;
		this.submitted = submitted;
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagRawName = tagRawName;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAssnName() {
		return assnName;
	}
	public void setAssnName(String assnName) {
		this.assnName = assnName;
	}
	public String getGraderName() {
		return graderName;
	}
	public void setGraderName(String graderName) {
		this.graderName = graderName;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Boolean getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Boolean submitted) {
		this.submitted = submitted;
	}
	public Long getTagId() {
		return tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagRawName() {
		return tagRawName;
	}
	public void setTagRawName(String tagRawName) {
		this.tagRawName = tagRawName;
	}
	
	
}
