package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_assign")
public class MoodleAssign {
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
	
	@Column(name="alwaysshowdescription",nullable = false)
	private Integer alwaysshowdescription;
	
	@Column(name="nosubmissions",nullable = false)
	private Integer nosubmissions;
	
	@Column(name="submissiondrafts",nullable = false)
	private Integer submissiondrafts;
	
	@Column(name="sendnotifications",nullable = false)
	private Integer sendnotifications;
	
	@Column(name="sendlatenotifications",nullable = false)
	private Integer sendlatenotifications;
	
	@Column(name="duedate",nullable = false)
	private Long duedate;
	
	@Column(name="allowsubmissionsfromdate",nullable = false)
	private Long allowsubmissionsfromdate;
	
	@Column(name="grade",nullable = false)
	private Long grade;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	@Column(name="requiresubmissionstatement",nullable = false)
	private Integer requiresubmissionstatement;
	
	@Column(name="completionsubmit",nullable = false)
	private Integer completionsubmit;
	
	@Column(name="cutoffdate",nullable = false)
	private Long cutoffdate;
	
	@Column(name="gradingduedate",nullable = false)
	private Long gradingduedate;
	
	@Column(name="teamsubmission",nullable = false)
	private Integer teamsubmission;
	
	@Column(name="requireallteammemberssubmit",nullable = false)
	private Integer requireallteammemberssubmit;
	
	@Column(name="teamsubmissiongroupingid",nullable = false)
	private Long teamsubmissiongroupingid;
	
	@Column(name="blindmarking",nullable = false)
	private Integer blindmarking;
	
	@Column(name="revealidentities",nullable = false)
	private Integer revealidentities;
	
	@Column(name="attemptreopenmethod",nullable = false)
	private String attemptreopenmethod;
	
	@Column(name="maxattempts",nullable = false)
	private Integer maxattempts;
	
	@Column(name="markingworkflow",nullable = false)
	private Integer markingworkflow;
	
	@Column(name="markingallocation",nullable = false)
	private Integer markingallocation;
	
	@Column(name="sendstudentnotifications",nullable = false)
	private Integer sendstudentnotifications;
	
	@Column(name="preventsubmissionnotingroup",nullable = false)
	private Integer preventsubmissionnotingroup;

	public MoodleAssign() {
		super();
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

	public Integer getAlwaysshowdescription() {
		return alwaysshowdescription;
	}

	public void setAlwaysshowdescription(Integer alwaysshowdescription) {
		this.alwaysshowdescription = alwaysshowdescription;
	}

	public Integer getNosubmissions() {
		return nosubmissions;
	}

	public void setNosubmissions(Integer nosubmissions) {
		this.nosubmissions = nosubmissions;
	}

	public Integer getSubmissiondrafts() {
		return submissiondrafts;
	}

	public void setSubmissiondrafts(Integer submissiondrafts) {
		this.submissiondrafts = submissiondrafts;
	}

	public Integer getSendnotifications() {
		return sendnotifications;
	}

	public void setSendnotifications(Integer sendnotifications) {
		this.sendnotifications = sendnotifications;
	}

	public Integer getSendlatenotifications() {
		return sendlatenotifications;
	}

	public void setSendlatenotifications(Integer sendlatenotifications) {
		this.sendlatenotifications = sendlatenotifications;
	}

	public Long getDuedate() {
		return duedate;
	}

	public void setDuedate(Long duedate) {
		this.duedate = duedate;
	}

	public Long getAllowsubmissionsfromdate() {
		return allowsubmissionsfromdate;
	}

	public void setAllowsubmissionsfromdate(Long allowsubmissionsfromdate) {
		this.allowsubmissionsfromdate = allowsubmissionsfromdate;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}

	public Integer getRequiresubmissionstatement() {
		return requiresubmissionstatement;
	}

	public void setRequiresubmissionstatement(Integer requiresubmissionstatement) {
		this.requiresubmissionstatement = requiresubmissionstatement;
	}

	public Integer getCompletionsubmit() {
		return completionsubmit;
	}

	public void setCompletionsubmit(Integer completionsubmit) {
		this.completionsubmit = completionsubmit;
	}

	public Long getCutoffdate() {
		return cutoffdate;
	}

	public void setCutoffdate(Long cutoffdate) {
		this.cutoffdate = cutoffdate;
	}

	public Long getGradingduedate() {
		return gradingduedate;
	}

	public void setGradingduedate(Long gradingduedate) {
		this.gradingduedate = gradingduedate;
	}

	public Integer getTeamsubmission() {
		return teamsubmission;
	}

	public void setTeamsubmission(Integer teamsubmission) {
		this.teamsubmission = teamsubmission;
	}

	public Integer getRequireallteammemberssubmit() {
		return requireallteammemberssubmit;
	}

	public void setRequireallteammemberssubmit(Integer requireallteammemberssubmit) {
		this.requireallteammemberssubmit = requireallteammemberssubmit;
	}

	public Long getTeamsubmissiongroupingid() {
		return teamsubmissiongroupingid;
	}

	public void setTeamsubmissiongroupingid(Long teamsubmissiongroupingid) {
		this.teamsubmissiongroupingid = teamsubmissiongroupingid;
	}

	public Integer getBlindmarking() {
		return blindmarking;
	}

	public void setBlindmarking(Integer blindmarking) {
		this.blindmarking = blindmarking;
	}

	public Integer getRevealidentities() {
		return revealidentities;
	}

	public void setRevealidentities(Integer revealidentities) {
		this.revealidentities = revealidentities;
	}

	public String getAttemptreopenmethod() {
		return attemptreopenmethod;
	}

	public void setAttemptreopenmethod(String attemptreopenmethod) {
		this.attemptreopenmethod = attemptreopenmethod;
	}

	public Integer getMaxattempts() {
		return maxattempts;
	}

	public void setMaxattempts(Integer maxattempts) {
		this.maxattempts = maxattempts;
	}

	public Integer getMarkingworkflow() {
		return markingworkflow;
	}

	public void setMarkingworkflow(Integer markingworkflow) {
		this.markingworkflow = markingworkflow;
	}

	public Integer getMarkingallocation() {
		return markingallocation;
	}

	public void setMarkingallocation(Integer markingallocation) {
		this.markingallocation = markingallocation;
	}

	public Integer getSendstudentnotifications() {
		return sendstudentnotifications;
	}

	public void setSendstudentnotifications(Integer sendstudentnotifications) {
		this.sendstudentnotifications = sendstudentnotifications;
	}

	public Integer getPreventsubmissionnotingroup() {
		return preventsubmissionnotingroup;
	}

	public void setPreventsubmissionnotingroup(Integer preventsubmissionnotingroup) {
		this.preventsubmissionnotingroup = preventsubmissionnotingroup;
	}
}
