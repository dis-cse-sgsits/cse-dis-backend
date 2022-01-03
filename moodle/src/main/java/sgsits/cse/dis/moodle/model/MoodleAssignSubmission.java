package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_assign_submission")
public class MoodleAssignSubmission {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="assignment",nullable = false)
	private Long assignment;
	
	@Column(name="userid",nullable = false)
	private Long userid;
	
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	@Column(name="status")
	private String status;
	
	@Column(name="groupid", nullable = false)
	private Long groupid;
	
	@Column(name="attemptnumber",nullable = false)
	private Long attemptnumber;
	
	@Column(name="latest",nullable = false)
	private Integer latest;

	public MoodleAssignSubmission() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssignment() {
		return assignment;
	}

	public void setAssignment(Long assignment) {
		this.assignment = assignment;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public Long getAttemptnumber() {
		return attemptnumber;
	}

	public void setAttemptnumber(Long attemptnumber) {
		this.attemptnumber = attemptnumber;
	}

	public Integer getLatest() {
		return latest;
	}

	public void setLatest(Integer latest) {
		this.latest = latest;
	}
	
	
}
