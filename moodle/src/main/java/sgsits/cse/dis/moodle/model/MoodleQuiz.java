package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_quiz")
public class MoodleQuiz {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;

	@Column(name="course",nullable = false)
	private Long course;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="intro",nullable = false)
	private String intro;
	
	@Column(name="introformat",nullable = false)
	private Integer introformat;
	
	@Column(name="timeopen",nullable = false)
	private Long timeopen;
	
	@Column(name="timeclose",nullable = false)
	private Long timeclose;
	
	@Column(name="timelimit",nullable = false)
	private Long timelimit;
	
	@Column(name="overduehandling",nullable = false)
	private String overduehandling;
	
	@Column(name="graceperiod",nullable = false)
	private Long graceperiod;
	
	@Column(name="preferredbehaviour",nullable = false)
	private String preferredbehaviour;
	
	@Column(name="canredoquestions",nullable = false)
	private Integer canredoquestions;
	
	@Column(name="attempts",nullable = false)
	private Integer attempts;
	
	@Column(name="attemptonlast",nullable = false)
	private Integer attemptonlast;
	
	@Column(name="grademethod",nullable = false)
	private Integer grademethod;
	
	@Column(name="decimalpoints",nullable = false)
	private Integer decimalpoints;
	
	@Column(name="questiondecimalpoints",nullable = false)
	private Integer questiondecimalpoints;
	
	@Column(name="reviewattempt",nullable = false)
	private Integer reviewattempt;
	
	@Column(name="reviewcorrectness",nullable = false)
	private Integer reviewcorrectness;
	
	@Column(name="reviewmarks",nullable = false)
	private Integer reviewmarks;
	
	@Column(name="reviewspecificfeedback",nullable = false)
	private Integer reviewspecificfeedback;
	
	@Column(name="reviewgeneralfeedback",nullable = false)
	private Integer reviewgeneralfeedback;
	
	@Column(name="reviewrightanswer",nullable = false)
	private Integer reviewrightanswer;
	
	@Column(name="reviewoverallfeedback",nullable = false)
	private Integer reviewoverallfeedback;
	
	@Column(name="questionsperpage",nullable = false)
	private Long questionsperpage;
	
	@Column(name="navmethod",nullable = false)
	private String navmethod;
	
	@Column(name="shuffleanswers",nullable = false)
	private Integer shuffleanswers;
	
	@Column(name="sumgrades",nullable = false)
	private Double sumgrades;
	
	@Column(name="grade",nullable = false)
	private Double grade;
	
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="subnet",nullable = false)
	private String subnet;
	
	@Column(name="browsersecurity",nullable = false)
	private String browsersecurity;
	
	@Column(name="delay1",nullable = false)
	private Long delay1;
	
	@Column(name="delay2",nullable = false)
	private Long delay2;
	
	@Column(name="showuserpicture",nullable = false)
	private Integer showuserpicture;
	
	@Column(name="showblocks",nullable = false)
	private Integer showblocks;
	
	@Column(name="completionattemptsexhausted")
	private Integer completionattemptsexhausted;
	
	@Column(name="completionpass")
	private Integer completionpass;
	
	@Column(name="allowofflineattempts")
	private Integer allowofflineattempts;

	public MoodleQuiz(Long id, Long course, String name, String intro, Integer introformat, Long timeopen,
			Long timeclose, Long timelimit, String overduehandling, Long graceperiod, String preferredbehaviour,
			Integer canredoquestions, Integer attempts, Integer attemptonlast, Integer grademethod,
			Integer decimalpoints, Integer questiondecimalpoints, Integer reviewattempt, Integer reviewcorrectness,
			Integer reviewmarks, Integer reviewspecificfeedback, Integer reviewgeneralfeedback,
			Integer reviewrightanswer, Integer reviewoverallfeedback, Long questionsperpage, String navmethod,
			Integer shuffleanswers, Double sumgrades, Double grade, Long timecreated, Long timemodified,
			String password, String subnet, String browsersecurity, Long delay1, Long delay2, Integer showuserpicture,
			Integer showblocks, Integer completionattemptsexhausted, Integer completionpass,
			Integer allowofflineattempts) {
		super();
		this.id = id;
		this.course = course;
		this.name = name;
		this.intro = intro;
		this.introformat = introformat;
		this.timeopen = timeopen;
		this.timeclose = timeclose;
		this.timelimit = timelimit;
		this.overduehandling = overduehandling;
		this.graceperiod = graceperiod;
		this.preferredbehaviour = preferredbehaviour;
		this.canredoquestions = canredoquestions;
		this.attempts = attempts;
		this.attemptonlast = attemptonlast;
		this.grademethod = grademethod;
		this.decimalpoints = decimalpoints;
		this.questiondecimalpoints = questiondecimalpoints;
		this.reviewattempt = reviewattempt;
		this.reviewcorrectness = reviewcorrectness;
		this.reviewmarks = reviewmarks;
		this.reviewspecificfeedback = reviewspecificfeedback;
		this.reviewgeneralfeedback = reviewgeneralfeedback;
		this.reviewrightanswer = reviewrightanswer;
		this.reviewoverallfeedback = reviewoverallfeedback;
		this.questionsperpage = questionsperpage;
		this.navmethod = navmethod;
		this.shuffleanswers = shuffleanswers;
		this.sumgrades = sumgrades;
		this.grade = grade;
		this.timecreated = timecreated;
		this.timemodified = timemodified;
		this.password = password;
		this.subnet = subnet;
		this.browsersecurity = browsersecurity;
		this.delay1 = delay1;
		this.delay2 = delay2;
		this.showuserpicture = showuserpicture;
		this.showblocks = showblocks;
		this.completionattemptsexhausted = completionattemptsexhausted;
		this.completionpass = completionpass;
		this.allowofflineattempts = allowofflineattempts;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getIntroformat() {
		return introformat;
	}

	public void setIntroformat(Integer introformat) {
		this.introformat = introformat;
	}

	public Long getTimeopen() {
		return timeopen;
	}

	public void setTimeopen(Long timeopen) {
		this.timeopen = timeopen;
	}

	public Long getTimeclose() {
		return timeclose;
	}

	public void setTimeclose(Long timeclose) {
		this.timeclose = timeclose;
	}

	public Long getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Long timelimit) {
		this.timelimit = timelimit;
	}

	public String getOverduehandling() {
		return overduehandling;
	}

	public void setOverduehandling(String overduehandling) {
		this.overduehandling = overduehandling;
	}

	public Long getGraceperiod() {
		return graceperiod;
	}

	public void setGraceperiod(Long graceperiod) {
		this.graceperiod = graceperiod;
	}

	public String getPreferredbehaviour() {
		return preferredbehaviour;
	}

	public void setPreferredbehaviour(String preferredbehaviour) {
		this.preferredbehaviour = preferredbehaviour;
	}

	public Integer getCanredoquestions() {
		return canredoquestions;
	}

	public void setCanredoquestions(Integer canredoquestions) {
		this.canredoquestions = canredoquestions;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Integer getAttemptonlast() {
		return attemptonlast;
	}

	public void setAttemptonlast(Integer attemptonlast) {
		this.attemptonlast = attemptonlast;
	}

	public Integer getGrademethod() {
		return grademethod;
	}

	public void setGrademethod(Integer grademethod) {
		this.grademethod = grademethod;
	}

	public Integer getDecimalpoints() {
		return decimalpoints;
	}

	public void setDecimalpoints(Integer decimalpoints) {
		this.decimalpoints = decimalpoints;
	}

	public Integer getQuestiondecimalpoints() {
		return questiondecimalpoints;
	}

	public void setQuestiondecimalpoints(Integer questiondecimalpoints) {
		this.questiondecimalpoints = questiondecimalpoints;
	}

	public Integer getReviewattempt() {
		return reviewattempt;
	}

	public void setReviewattempt(Integer reviewattempt) {
		this.reviewattempt = reviewattempt;
	}

	public Integer getReviewcorrectness() {
		return reviewcorrectness;
	}

	public void setReviewcorrectness(Integer reviewcorrectness) {
		this.reviewcorrectness = reviewcorrectness;
	}

	public Integer getReviewmarks() {
		return reviewmarks;
	}

	public void setReviewmarks(Integer reviewmarks) {
		this.reviewmarks = reviewmarks;
	}

	public Integer getReviewspecificfeedback() {
		return reviewspecificfeedback;
	}

	public void setReviewspecificfeedback(Integer reviewspecificfeedback) {
		this.reviewspecificfeedback = reviewspecificfeedback;
	}

	public Integer getReviewgeneralfeedback() {
		return reviewgeneralfeedback;
	}

	public void setReviewgeneralfeedback(Integer reviewgeneralfeedback) {
		this.reviewgeneralfeedback = reviewgeneralfeedback;
	}

	public Integer getReviewrightanswer() {
		return reviewrightanswer;
	}

	public void setReviewrightanswer(Integer reviewrightanswer) {
		this.reviewrightanswer = reviewrightanswer;
	}

	public Integer getReviewoverallfeedback() {
		return reviewoverallfeedback;
	}

	public void setReviewoverallfeedback(Integer reviewoverallfeedback) {
		this.reviewoverallfeedback = reviewoverallfeedback;
	}

	public Long getQuestionsperpage() {
		return questionsperpage;
	}

	public void setQuestionsperpage(Long questionsperpage) {
		this.questionsperpage = questionsperpage;
	}

	public String getNavmethod() {
		return navmethod;
	}

	public void setNavmethod(String navmethod) {
		this.navmethod = navmethod;
	}

	public Integer getShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(Integer shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

	public Double getSumgrades() {
		return sumgrades;
	}

	public void setSumgrades(Double sumgrades) {
		this.sumgrades = sumgrades;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getBrowsersecurity() {
		return browsersecurity;
	}

	public void setBrowsersecurity(String browsersecurity) {
		this.browsersecurity = browsersecurity;
	}

	public Long getDelay1() {
		return delay1;
	}

	public void setDelay1(Long delay1) {
		this.delay1 = delay1;
	}

	public Long getDelay2() {
		return delay2;
	}

	public void setDelay2(Long delay2) {
		this.delay2 = delay2;
	}

	public Integer getShowuserpicture() {
		return showuserpicture;
	}

	public void setShowuserpicture(Integer showuserpicture) {
		this.showuserpicture = showuserpicture;
	}

	public Integer getShowblocks() {
		return showblocks;
	}

	public void setShowblocks(Integer showblocks) {
		this.showblocks = showblocks;
	}

	public Integer getCompletionattemptsexhausted() {
		return completionattemptsexhausted;
	}

	public void setCompletionattemptsexhausted(Integer completionattemptsexhausted) {
		this.completionattemptsexhausted = completionattemptsexhausted;
	}

	public Integer getCompletionpass() {
		return completionpass;
	}

	public void setCompletionpass(Integer completionpass) {
		this.completionpass = completionpass;
	}

	public Integer getAllowofflineattempts() {
		return allowofflineattempts;
	}

	public void setAllowofflineattempts(Integer allowofflineattempts) {
		this.allowofflineattempts = allowofflineattempts;
	}
}
