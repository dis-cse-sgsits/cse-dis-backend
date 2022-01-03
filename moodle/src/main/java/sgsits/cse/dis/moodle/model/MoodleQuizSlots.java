package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_quiz_slots")
public class MoodleQuizSlots {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="slot",nullable = false)
	private Long slot;
	
	@Column(name="quizid",nullable = false)
	private Long quizid;
	
	@Column(name="page",nullable = false)
	private Long page;
	
	@Column(name="requireprevious",nullable = false)
	private Integer requireprevious;
	
	@Column(name="questionid",nullable = false)
	private Long questionid;
	
	@Column(name="maxmark",nullable = false)
	private Double maxmark;

	
	
	public MoodleQuizSlots() {
		super();
	}

	public MoodleQuizSlots(Long id, Long slot, Long quizid, Long page, Integer requireprevious, Long questionid,
			Double maxmark) {
		super();
		this.id = id;
		this.slot = slot;
		this.quizid = quizid;
		this.page = page;
		this.requireprevious = requireprevious;
		this.questionid = questionid;
		this.maxmark = maxmark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSlot() {
		return slot;
	}

	public void setSlot(Long slot) {
		this.slot = slot;
	}

	public Long getQuizid() {
		return quizid;
	}

	public void setQuizid(Long quizid) {
		this.quizid = quizid;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Integer getRequireprevious() {
		return requireprevious;
	}

	public void setRequireprevious(Integer requireprevious) {
		this.requireprevious = requireprevious;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public Double getMaxmark() {
		return maxmark;
	}

	public void setMaxmark(Double maxmark) {
		this.maxmark = maxmark;
	}
}
