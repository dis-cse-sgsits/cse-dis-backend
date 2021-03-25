package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_question_attempts")
public class MoodleQuestionAttempts {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="questionusageid",nullable = false)
	private Long questionusageid;
	
	@Column(name="slot",nullable = false)
	private Long slot;
	
	@Column(name="behaviour",nullable = false)
	private String behaviour;
	
	@Column(name="questionid",nullable = false)
	private Long questionid;
	
	@Column(name="variant",nullable = false)
	private Long variant;
	
	@Column(name="maxmark",nullable = false)
	private Double maxmark;
	
	@Column(name="minfraction",nullable = false)
	private Double minfraction;
	
	@Column(name="maxfraction",nullable = false)
	private Double maxfraction;
	
	@Column(name="flagged",nullable = false)
	private Integer flagged;
	
	@Column(name="questionsummary")
	private String questionsummary;
	
	@Column(name="rightanswer")
	private String rightanswer;
	
	@Column(name="responsesummary")
	private String responsesummary;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	

	public MoodleQuestionAttempts() {
		super();
	}

	public MoodleQuestionAttempts(Long id, Long questionusageid, Long slot, String behaviour, Long questionid,
			Long variant, Double maxmark, Double minfraction, Double maxfraction, Integer flagged,
			String questionsummary, String rightanswer, String responsesummary, Long timemodified) {
		super();
		this.id = id;
		this.questionusageid = questionusageid;
		this.slot = slot;
		this.behaviour = behaviour;
		this.questionid = questionid;
		this.variant = variant;
		this.maxmark = maxmark;
		this.minfraction = minfraction;
		this.maxfraction = maxfraction;
		this.flagged = flagged;
		this.questionsummary = questionsummary;
		this.rightanswer = rightanswer;
		this.responsesummary = responsesummary;
		this.timemodified = timemodified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionusageid() {
		return questionusageid;
	}

	public void setQuestionusageid(Long questionusageid) {
		this.questionusageid = questionusageid;
	}

	public Long getSlot() {
		return slot;
	}

	public void setSlot(Long slot) {
		this.slot = slot;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public Long getVariant() {
		return variant;
	}

	public void setVariant(Long variant) {
		this.variant = variant;
	}

	public Double getMaxmark() {
		return maxmark;
	}

	public void setMaxmark(Double maxmark) {
		this.maxmark = maxmark;
	}

	public Double getMinfraction() {
		return minfraction;
	}

	public void setMinfraction(Double minfraction) {
		this.minfraction = minfraction;
	}

	public Double getMaxfraction() {
		return maxfraction;
	}

	public void setMaxfraction(Double maxfraction) {
		this.maxfraction = maxfraction;
	}

	public Integer getFlagged() {
		return flagged;
	}

	public void setFlagged(Integer flagged) {
		this.flagged = flagged;
	}

	public String getQuestionsummary() {
		return questionsummary;
	}

	public void setQuestionsummary(String questionsummary) {
		this.questionsummary = questionsummary;
	}

	public String getRightanswer() {
		return rightanswer;
	}

	public void setRightanswer(String rightanswer) {
		this.rightanswer = rightanswer;
	}

	public String getResponsesummary() {
		return responsesummary;
	}

	public void setResponsesummary(String responsesummary) {
		this.responsesummary = responsesummary;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}
	
	
}
