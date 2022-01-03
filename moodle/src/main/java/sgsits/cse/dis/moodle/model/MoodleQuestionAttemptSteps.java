package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_question_attempt_steps")
public class MoodleQuestionAttemptSteps {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="questionattemptid",nullable = false)
	private Long questionattemptid;
	
	@Column(name="sequencenumber",nullable = false)
	private Long sequencenumber;
	
	@Column(name="state",nullable = false)
	private String state;
	
	@Column(name="fraction")
	private Double fraction;
	
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	
	@Column(name="userid")
	private Long userid;
	
	

	public MoodleQuestionAttemptSteps() {
		super();
	}

	public MoodleQuestionAttemptSteps(Long id, Long questionattemptid, Long sequencenumber, String state,
			Double fraction, Long timecreated, Long userid) {
		super();
		this.id = id;
		this.questionattemptid = questionattemptid;
		this.sequencenumber = sequencenumber;
		this.state = state;
		this.fraction = fraction;
		this.timecreated = timecreated;
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionattemptid() {
		return questionattemptid;
	}

	public void setQuestionattemptid(Long questionattemptid) {
		this.questionattemptid = questionattemptid;
	}

	public Long getSequencenumber() {
		return sequencenumber;
	}

	public void setSequencenumber(Long sequencenumber) {
		this.sequencenumber = sequencenumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getFraction() {
		return fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	public Long getTimecreated() {
		return timecreated;
	}

	public void setTimecreated(Long timecreated) {
		this.timecreated = timecreated;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
}
