package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_question_answers")
public class MoodleQuestionAnswers {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="question",nullable = false)
	private Long question;
	
	@Column(name="answer",nullable = false)
	private String answer;
	
	@Column(name="answerformat",nullable = false)
	private Integer answerformat;
	
	@Column(name="fraction",nullable = false)
	private Double fraction;
	
	@Column(name="feedback",nullable = false)
	private String feedback;
	
	@Column(name="feedbackformat",nullable = false)
	private Integer feedbackformat;
	
	

	public MoodleQuestionAnswers() {
		super();
	}

	public MoodleQuestionAnswers(Long id, Long question, String answer, Integer answerformat, Double fraction,
			String feedback, Integer feedbackformat) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.answerformat = answerformat;
		this.fraction = fraction;
		this.feedback = feedback;
		this.feedbackformat = feedbackformat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestion() {
		return question;
	}

	public void setQuestion(Long question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getAnswerformat() {
		return answerformat;
	}

	public void setAnswerformat(Integer answerformat) {
		this.answerformat = answerformat;
	}

	public Double getFraction() {
		return fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getFeedbackformat() {
		return feedbackformat;
	}

	public void setFeedbackformat(Integer feedbackformat) {
		this.feedbackformat = feedbackformat;
	}
	
	

}
