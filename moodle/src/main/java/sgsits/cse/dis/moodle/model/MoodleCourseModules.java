package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_course_modules")
public class MoodleCourseModules {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="course",nullable = false)
	private Long course;
	
	@Column(name="module",nullable = false)
	private Long module;
	
	@Column(name="instance",nullable = false)
	private Long instance;
	
	@Column(name="section",nullable = false)
	private Long section;
	
	@Column(name="idnumber")
	private String idnumber;
	
	@Column(name="added",nullable = false)
	private Long added;
	
	@Column(name="score",nullable = false)
	private Integer score;
	
	@Column(name="indent",nullable = false)
	private Integer indent;
	
	@Column(name="visible",nullable = false)
	private Integer visible;
	
	@Column(name="visibleoncoursepage",nullable = false)
	private Integer visibleoncoursepage;
	
	@Column(name="visibleold",nullable = false)
	private Integer visibleold;
	
	@Column(name="groupmode",nullable = false)
	private Integer groupmode;
	
	@Column(name="groupingid",nullable = false)
	private Long groupingid;
	
	@Column(name="completion",nullable = false)
	private Integer completion;
	
	@Column(name="completiongradeitemnumber")
	private Long completiongradeitemnumber;
	
	@Column(name="completionview",nullable = false)
	private Integer completionview;
	
	@Column(name="completionexpected",nullable = false)
	private Long completionexpected;
	
	@Column(name="showdescription",nullable = false)
	private Long showdescription;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name="deletioninprogress",nullable = false)
	private Integer deletioninprogress;
	
	

	public MoodleCourseModules() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoodleCourseModules(Long id, Long course, Long module, Long instance, Long section, String idnumber,
			Long added, Integer score, Integer indent, Integer visible, Integer visibleoncoursepage, Integer visibleold,
			Integer groupmode, Long groupingid, Integer completion, Long completiongradeitemnumber,
			Integer completionview, Long completionexpected, Long showdescription, String availability,
			Integer deletioninprogress) {
		super();
		this.id = id;
		this.course = course;
		this.module = module;
		this.instance = instance;
		this.section = section;
		this.idnumber = idnumber;
		this.added = added;
		this.score = score;
		this.indent = indent;
		this.visible = visible;
		this.visibleoncoursepage = visibleoncoursepage;
		this.visibleold = visibleold;
		this.groupmode = groupmode;
		this.groupingid = groupingid;
		this.completion = completion;
		this.completiongradeitemnumber = completiongradeitemnumber;
		this.completionview = completionview;
		this.completionexpected = completionexpected;
		this.showdescription = showdescription;
		this.availability = availability;
		this.deletioninprogress = deletioninprogress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}

	public Long getModule() {
		return module;
	}

	public void setModule(Long module) {
		this.module = module;
	}

	public Long getInstance() {
		return instance;
	}

	public void setInstance(Long instance) {
		this.instance = instance;
	}

	public Long getSection() {
		return section;
	}

	public void setSection(Long section) {
		this.section = section;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Long getAdded() {
		return added;
	}

	public void setAdded(Long added) {
		this.added = added;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getIndent() {
		return indent;
	}

	public void setIndent(Integer indent) {
		this.indent = indent;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public Integer getVisibleoncoursepage() {
		return visibleoncoursepage;
	}

	public void setVisibleoncoursepage(Integer visibleoncoursepage) {
		this.visibleoncoursepage = visibleoncoursepage;
	}

	public Integer getVisibleold() {
		return visibleold;
	}

	public void setVisibleold(Integer visibleold) {
		this.visibleold = visibleold;
	}

	public Integer getGroupmode() {
		return groupmode;
	}

	public void setGroupmode(Integer groupmode) {
		this.groupmode = groupmode;
	}

	public Long getGroupingid() {
		return groupingid;
	}

	public void setGroupingid(Long groupingid) {
		this.groupingid = groupingid;
	}

	public Integer getCompletion() {
		return completion;
	}

	public void setCompletion(Integer completion) {
		this.completion = completion;
	}

	public Long getCompletiongradeitemnumber() {
		return completiongradeitemnumber;
	}

	public void setCompletiongradeitemnumber(Long completiongradeitemnumber) {
		this.completiongradeitemnumber = completiongradeitemnumber;
	}

	public Integer getCompletionview() {
		return completionview;
	}

	public void setCompletionview(Integer completionview) {
		this.completionview = completionview;
	}

	public Long getCompletionexpected() {
		return completionexpected;
	}

	public void setCompletionexpected(Long completionexpected) {
		this.completionexpected = completionexpected;
	}

	public Long getShowdescription() {
		return showdescription;
	}

	public void setShowdescription(Long showdescription) {
		this.showdescription = showdescription;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getDeletioninprogress() {
		return deletioninprogress;
	}

	public void setDeletioninprogress(Integer deletioninprogress) {
		this.deletioninprogress = deletioninprogress;
	}
	
	
}
