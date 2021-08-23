package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mdl_attendance_teacher")
public class MoodleAttendanceTeacher {
    
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;	
	@Column(name="subjectid",nullable = false)
	private String subjectid;
	@Column(name="takenby",nullable = false)
	private Long takenby;
	@Column(name="date_attendance",nullable=false)
	private String date_attendance;
	
	@Column(name="slot",nullable = false)
	private Long slot;
	@Column(name="stringnew",unique=true)
	private String stringnew;
	@Column(name="time")
	private String time;
	public MoodleAttendanceTeacher() {
		super();
	}
	public MoodleAttendanceTeacher(String subjectid, Long takenby, String date_attendance, Long slot) {
		super();
		this.subjectid = subjectid;
		this.takenby = takenby;
		this.date_attendance = date_attendance;
		this.slot = slot;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public Long getTakenby() {
		return takenby;
	}
	public void setTakenby(Long takenby) {
		this.takenby = takenby;
	}
	public String getDate_attendance() {
		return date_attendance;
	}
	public void setDate_attendance(String date_attendance) {
		this.date_attendance = date_attendance;
	}
	public Long getSlot() {
		return slot;
	}
	public void setSlot(Long slot) {
		this.slot = slot;
	}
	public String getStringnew() {
		return stringnew;
	}
	public void setStringnew(String stringnew) {
		this.stringnew = stringnew;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
