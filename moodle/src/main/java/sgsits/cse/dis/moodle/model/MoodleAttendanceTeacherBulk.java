package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mdl_attendance_teacher_bulk")
public class MoodleAttendanceTeacherBulk {

	@Id
	
	@Column(name="id",nullable = false, unique = true)
	private Long id;	
	@Column(name="subjectid",nullable = false)
	private Long subjectid;
	@Column(name="teacherid",nullable = false)
	private Long teacherid;
	@Column(name="date_attendance",nullable=false)
	private String date_attendance;
	@Column(name="slot",nullable = false)
	private Long slot;
	@Column(name="uploadtime",nullable=false)
	private String uploadtime;
	
	
	public MoodleAttendanceTeacherBulk() {
		super();
	}
	public MoodleAttendanceTeacherBulk(Long subjectid, Long teacherid, String date_attendance, Long slot,
			String uploadtime) {
		super();
		this.subjectid = subjectid;
		this.teacherid = teacherid;
		this.date_attendance = date_attendance;
		this.slot = slot;
		this.uploadtime = uploadtime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public Long getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
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
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	
}
