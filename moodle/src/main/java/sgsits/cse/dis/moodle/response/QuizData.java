package sgsits.cse.dis.moodle.response;

public class QuizData {
	private Long courseId;
	private String courseCode;
	private String courseName;
	private Long quizId;
	private String quizName;
	private String dateOfCreation;
	private Double grade;
	private Double total;
	
	public QuizData(Long courseId, String courseCode, String courseName, Long quizId, String quizName,
			String dateOfCreation, Double grade, Double total) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.quizId = quizId;
		this.quizName = quizName;
		this.dateOfCreation = dateOfCreation;
		this.grade = grade;
		this.total = total;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
