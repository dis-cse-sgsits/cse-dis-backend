package sgsits.cse.dis.moodle.response;

import java.util.List;

public class QuestionData {
	private Long quizId;
	private String quizName;
	private String questionText;
	private String questionType;
	private List<String> options;
	private String correctAnswer;
	private String userResponse;
	private Double obtainedMarks;
	private Double maxMarks;
	private Double penalty;
	private String gradeStatus;
	private Long slot;
	private String status;
	
	public QuestionData(Long quizId, String quizName, String questionText, String questionType, List<String> options,
			String correctAnswer, String userResponse, Double obtainedMarks, Double maxMarks, Double penalty,
			String gradeStatus, Long slot, String status) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		this.questionText = questionText;
		this.questionType = questionType;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.userResponse = userResponse;
		this.obtainedMarks = obtainedMarks;
		this.maxMarks = maxMarks;
		this.penalty = penalty;
		this.gradeStatus = gradeStatus;
		this.slot = slot;
		this.status = status;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}

	public Double getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(Double obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public Double getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(Double maxMarks) {
		this.maxMarks = maxMarks;
	}

	public Double getPenalty() {
		return penalty;
	}

	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	public String getGradeStatus() {
		return gradeStatus;
	}

	public void setGradeStatus(String gradeStatus) {
		this.gradeStatus = gradeStatus;
	}

	public Long getSlot() {
		return slot;
	}

	public void setSlot(Long slot) {
		this.slot = slot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
