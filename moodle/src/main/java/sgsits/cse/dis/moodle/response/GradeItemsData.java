package sgsits.cse.dis.moodle.response;

public class GradeItemsData {
	private Long gradeItemId;
	private Long courseId;
	private String itemName;
	
	public GradeItemsData(Long gradeItemId, Long courseId, String itemName) {
		super();
		this.gradeItemId = gradeItemId;
		this.courseId = courseId;
		this.itemName = itemName;
	}

	public Long getGradeItemId() {
		return gradeItemId;
	}

	public void setGradeItemId(Long gradeItemId) {
		this.gradeItemId = gradeItemId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	

}
