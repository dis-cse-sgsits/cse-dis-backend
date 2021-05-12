package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_user_enrolments")
public class MoodleUserEnrollment {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;	
	@Column(name="enrolid",nullable = false)
	private Long enrolid;	
	@Column(name="status",nullable = false)
	private Long status	;
	@Column(name="userid",nullable = false)
	private Long userid;	
	@Column(name="timestart",nullable = false)
	private Long timestart;	
	@Column(name="timeend",nullable = false)
	private Long timeend;
	@Column(name="modifierid",nullable = false)
	private Long modifierid;
	@Column(name="timecreated",nullable = false)
	private Long timecreated;	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEnrolid() {
		return enrolid;
	}
	public void setEnrolid(Long enrolid) {
		this.enrolid = enrolid;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getTimestart() {
		return timestart;
	}
	public void setTimestart(Long timestart) {
		this.timestart = timestart;
	}
	public Long getTimeend() {
		return timeend;
	}
	public void setTimeend(Long timeend) {
		this.timeend = timeend;
	}
	public Long getModifierid() {
		return modifierid;
	}
	public void setModifierid(Long modifierid) {
		this.modifierid = modifierid;
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
	
	
	
}
