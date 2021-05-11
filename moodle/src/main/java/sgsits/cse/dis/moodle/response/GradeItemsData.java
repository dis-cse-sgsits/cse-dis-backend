package sgsits.cse.dis.moodle.response;

public class GradeItemsData {
	private Long gradeItemId;
	private Long courseId;
	private String itemName;
	private String itemType;
	private String itemModule;
	private Long itemInstance;
	private Long tagId;
	private String tagName;
	private String tagRawName;
	
	
	
	public GradeItemsData(Long gradeItemId, Long courseId, String itemName, String itemType,
			String itemModule, Long itemInstance, Long tagId, String tagName, String tagRawName) {
		super();
		this.gradeItemId = gradeItemId;
		this.courseId = courseId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemModule = itemModule;
		this.itemInstance = itemInstance;
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagRawName = tagRawName;
	}


	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemModule() {
		return itemModule;
	}

	public void setItemModule(String itemModule) {
		this.itemModule = itemModule;
	}

	public Long getItemInstance() {
		return itemInstance;
	}

	public void setItemInstance(Long itemInstance) {
		this.itemInstance = itemInstance;
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
