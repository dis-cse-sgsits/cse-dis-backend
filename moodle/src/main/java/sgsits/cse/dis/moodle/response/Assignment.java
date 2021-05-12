package sgsits.cse.dis.moodle.response;

public class Assignment {
	private Long assignId,courseId;
	private String assignName;
	private String dueDate;
	
	public Assignment(Long assignId, Long courseId, String assignName,String dueDate) {
		super();
		this.assignId = assignId;
		this.courseId = courseId;
		this.assignName = assignName;
		this.dueDate = dueDate;
	}
	
	public Long getAssignId() {
		return assignId;
	}
	public void setAssignId(Long assignId) {
		this.assignId = assignId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getAssignName() {
		return assignName;
	}
	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}	
	
}
