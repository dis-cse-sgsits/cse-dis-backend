package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_course_categories")
public class MoodleCourseCategories {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="idnumber")
	private String idnumber;
	@Column(name="description")
	private String description;
	@Column(name="descriptionformat")
	private Long descriptionformat;
	@Column(name="parent")
	private Long parent;
	@Column(name="sortorder")
	private Long sortorder;
	@Column(name="coursecount")
	private Long coursecount;
	@Column(name="visible")
	private Long visible;
	@Column(name="visibleold")
	private Long visibleold;
	@Column(name="timemodified")
	private Long timemodified;
	@Column(name="depth")
	private Long depth;
	@Column(name="path")
	private String path;
	@Column(name="theme")
	private String theme;
	
	public MoodleCourseCategories(Long id, String name, String idnumber, String description, Long descriptionformat,
			Long parent, Long sortorder, Long coursecount, Long visible, Long visibleold, Long timemodified, Long depth,
			String path, String theme) {
		super();
		this.id = id;
		this.name = name;
		this.idnumber = idnumber;
		this.description = description;
		this.descriptionformat = descriptionformat;
		this.parent = parent;
		this.sortorder = sortorder;
		this.coursecount = coursecount;
		this.visible = visible;
		this.visibleold = visibleold;
		this.timemodified = timemodified;
		this.depth = depth;
		this.path = path;
		this.theme = theme;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getDescriptionformat() {
		return descriptionformat;
	}
	public void setDescriptionformat(Long descriptionformat) {
		this.descriptionformat = descriptionformat;
	}
	public Long getParent() {
		return parent;
	}
	public void setParent(Long parent) {
		this.parent = parent;
	}
	public Long getSortorder() {
		return sortorder;
	}
	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}
	public Long getCoursecount() {
		return coursecount;
	}
	public void setCoursecount(Long coursecount) {
		this.coursecount = coursecount;
	}
	public Long getVisible() {
		return visible;
	}
	public void setVisible(Long visible) {
		this.visible = visible;
	}
	public Long getVisibleold() {
		return visibleold;
	}
	public void setVisibleold(Long visibleold) {
		this.visibleold = visibleold;
	}
	public MoodleCourseCategories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getTimemodified() {
		return timemodified;
	}
	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}
