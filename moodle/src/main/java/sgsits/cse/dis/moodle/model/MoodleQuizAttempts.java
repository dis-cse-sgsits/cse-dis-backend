package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_quiz_attempts")
public class MoodleQuizAttempts {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="quiz",nullable = false)
	private Long quiz;
	
	@Column(name="userid",nullable = false)
	private Long userid;
	
	@Column(name="attempt",nullable = false)
	private Integer attempt;
	
	@Column(name="uniqueid",nullable = false, unique = true)
	private Long uniqueid;
	
	@Column(name="layout",nullable = false)
	private String layout;
	
	@Column(name="currentpage",nullable = false)
	private Long currentpage;
	
	@Column(name="preview",nullable = false)
	private Integer preview;
	
	@Column(name="state",nullable = false)
	private String state;
	
	@Column(name="timestart",nullable = false)
	private Long timestart;
	
	@Column(name="timefinish",nullable = false)
	private Long timefinish;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	@Column(name="timemodifiedoffline",nullable = false)
	private Long timemodifiedoffline;
	
	@Column(name="timecheckstate")
	private Long timecheckstate;
	
	@Column(name="sumgrades")
	private Long sumgrades;

	public MoodleQuizAttempts(Long id, Long quiz, Long userid, Integer attempt, Long uniqueid, String layout,
			Long currentpage, Integer preview, String state, Long timestart, Long timefinish, Long timemodified,
			Long timemodifiedoffline, Long timecheckstate, Long sumgrades) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.userid = userid;
		this.attempt = attempt;
		this.uniqueid = uniqueid;
		this.layout = layout;
		this.currentpage = currentpage;
		this.preview = preview;
		this.state = state;
		this.timestart = timestart;
		this.timefinish = timefinish;
		this.timemodified = timemodified;
		this.timemodifiedoffline = timemodifiedoffline;
		this.timecheckstate = timecheckstate;
		this.sumgrades = sumgrades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuiz() {
		return quiz;
	}

	public void setQuiz(Long quiz) {
		this.quiz = quiz;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getAttempt() {
		return attempt;
	}

	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}

	public Long getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(Long uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public Long getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Long currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getPreview() {
		return preview;
	}

	public void setPreview(Integer preview) {
		this.preview = preview;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getTimestart() {
		return timestart;
	}

	public void setTimestart(Long timestart) {
		this.timestart = timestart;
	}

	public Long getTimefinish() {
		return timefinish;
	}

	public void setTimefinish(Long timefinish) {
		this.timefinish = timefinish;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}

	public Long getTimemodifiedoffline() {
		return timemodifiedoffline;
	}

	public void setTimemodifiedoffline(Long timemodifiedoffline) {
		this.timemodifiedoffline = timemodifiedoffline;
	}

	public Long getTimecheckstate() {
		return timecheckstate;
	}

	public void setTimecheckstate(Long timecheckstate) {
		this.timecheckstate = timecheckstate;
	}

	public Long getSumgrades() {
		return sumgrades;
	}

	public void setSumgrades(Long sumgrades) {
		this.sumgrades = sumgrades;
	}
}
