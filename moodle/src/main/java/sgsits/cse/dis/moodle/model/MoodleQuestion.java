package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_question")
public class MoodleQuestion {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="category",nullable = false)
	private Long category;
	
	@Column(name="parent",nullable = false)
	private Long parent;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="questiontext",nullable = false)
	private String questiontext;
	
	@Column(name="questiontextformat",nullable = false)
	private Integer questiontextformat;
	
	@Column(name="generalfeedback",nullable = false)
	private String generalfeedback;
	
	@Column(name="generalfeedbackformat",nullable = false)
	private Integer generalfeedbackformat;
	
	@Column(name="defaultmark",nullable = false)
	private Double defaultmark;
	
	@Column(name="penalty",nullable = false)
	private Double penalty;
	
	@Column(name="qtype",nullable = false)
	private String qtype;
	
	@Column(name="length",nullable = false)
	private Long length;
	
	@Column(name="stamp",nullable = false)
	private String stamp;
	
	@Column(name="version",nullable = false)
	private String version;

	@Column(name="hidden",nullable = false)
	private Integer hidden;
	
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	@Column(name="createdby")
	private Long createdby;
	
	@Column(name="modifiedby")
	private Long modifiedby;
	
	

	public MoodleQuestion() {
		super();
	}

	public MoodleQuestion(Long id, Long category, Long parent, String name, String questiontext,
			Integer questiontextformat, String generalfeedback, Integer generalfeedbackformat, Double defaultmark,
			Double penalty, String qtype, Long length, String stamp, String version, Integer hidden, Long timecreated,
			Long timemodified, Long createdby, Long modifiedby) {
		super();
		this.id = id;
		this.category = category;
		this.parent = parent;
		this.name = name;
		this.questiontext = questiontext;
		this.questiontextformat = questiontextformat;
		this.generalfeedback = generalfeedback;
		this.generalfeedbackformat = generalfeedbackformat;
		this.defaultmark = defaultmark;
		this.penalty = penalty;
		this.qtype = qtype;
		this.length = length;
		this.stamp = stamp;
		this.version = version;
		this.hidden = hidden;
		this.timecreated = timecreated;
		this.timemodified = timemodified;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestiontext() {
		return questiontext;
	}

	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}

	public Integer getQuestiontextformat() {
		return questiontextformat;
	}

	public void setQuestiontextformat(Integer questiontextformat) {
		this.questiontextformat = questiontextformat;
	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public void setGeneralfeedback(String generalfeedback) {
		this.generalfeedback = generalfeedback;
	}

	public Integer getGeneralfeedbackformat() {
		return generalfeedbackformat;
	}

	public void setGeneralfeedbackformat(Integer generalfeedbackformat) {
		this.generalfeedbackformat = generalfeedbackformat;
	}

	public Double getDefaultmark() {
		return defaultmark;
	}

	public void setDefaultmark(Double defaultmark) {
		this.defaultmark = defaultmark;
	}

	public Double getPenalty() {
		return penalty;
	}

	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	public Long getTimecreated() {
		return timecreated;
	}

	public void setTimecreated(Long timecreated) {
		this.timecreated = timecreated;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	
	
}
