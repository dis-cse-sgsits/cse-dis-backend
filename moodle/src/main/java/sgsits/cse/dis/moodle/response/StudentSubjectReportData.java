package sgsits.cse.dis.moodle.response;

import java.util.Date;

public class StudentSubjectReportData {
	private Long courseId;
	private String courseCode;
	private String courseName;
	private Long courseTeacherId;
	private String courseTeacherFirstName;
	private String courseTeacherLastName;
	private String assignmentName;
	private String dueDate;
	private Boolean submitted;
	private String dateOfCreation;
	private String dateOfSubmission;
	private Double gradeObtained; 
	private Long gradeMaximum;
	private Long graderId;
	private String graderFirstName;
	private String graderLastName;
	
	public StudentSubjectReportData(Long courseId, String courseCode, String courseName, Long courseTeacherId,
			String courseTeacherFirstName, String courseTeacherLastName, String assignmentName, String dueDate,
			Boolean submitted, String dateOfCreation, String dateOfSubmission, Double gradeObtained, Long gradeMaximum,
			Long graderId, String graderFirstName, String graderLastName) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseTeacherId = courseTeacherId;
		this.courseTeacherFirstName = courseTeacherFirstName;
		this.courseTeacherLastName = courseTeacherLastName;
		this.assignmentName = assignmentName;
		this.dueDate = dueDate;
		this.submitted = submitted;
		this.dateOfCreation = dateOfCreation;
		this.dateOfSubmission = dateOfSubmission;
		this.gradeObtained = gradeObtained;
		this.gradeMaximum = gradeMaximum;
		this.graderId = graderId;
		this.graderFirstName = graderFirstName;
		this.graderLastName = graderLastName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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

	public Long getCourseTeacherId() {
		return courseTeacherId;
	}

	public void setCourseTeacherId(Long courseTeacherId) {
		this.courseTeacherId = courseTeacherId;
	}

	public String getCourseTeacherFirstName() {
		return courseTeacherFirstName;
	}

	public void setCourseTeacherFirstName(String courseTeacherFirstName) {
		this.courseTeacherFirstName = courseTeacherFirstName;
	}

	public String getCourseTeacherLastName() {
		return courseTeacherLastName;
	}

	public void setCourseTeacherLastName(String courseTeacherLastName) {
		this.courseTeacherLastName = courseTeacherLastName;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
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

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public Double getGradeObtained() {
		return gradeObtained;
	}

	public void setGradeObtained(Double gradeObtained) {
		this.gradeObtained = gradeObtained;
	}

	public Long getGradeMaximum() {
		return gradeMaximum;
	}

	public void setGradeMaximum(Long gradeMaximum) {
		this.gradeMaximum = gradeMaximum;
	}

	public Long getGraderId() {
		return graderId;
	}

	public void setGraderId(Long graderId) {
		this.graderId = graderId;
	}

	public String getGraderFirstName() {
		return graderFirstName;
	}

	public void setGraderFirstName(String graderFirstName) {
		this.graderFirstName = graderFirstName;
	}

	public String getGraderLastName() {
		return graderLastName;
	}

	public void setGraderLastName(String graderLastName) {
		this.graderLastName = graderLastName;
	}
	

}
