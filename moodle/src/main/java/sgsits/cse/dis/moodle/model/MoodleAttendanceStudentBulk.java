package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mdl_attendance_student_bulk")
public class MoodleAttendanceStudentBulk {
	@Id
	
	@Column(name="id",nullable = false, unique = true)
	private Long id;	
	@Column(name="tableid",nullable = false)
	private Long tableid;
	@Column(name="studentid",nullable = false)
	private Long studentid;
	@Column(name="attendance",nullable = false)
	private Long attendance;
	@Column(name="date_attendence",nullable=false)
	private String date_attendence;
	
	
	public MoodleAttendanceStudentBulk() {
		super();
	}
	public MoodleAttendanceStudentBulk(Long tableid, Long studentid, Long attendance, String date_attendence) {
		super();
		this.tableid = tableid;
		this.studentid = studentid;
		this.attendance = attendance;
		this.date_attendence = date_attendence;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTableid() {
		return tableid;
	}
	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public Long getAttendance() {
		return attendance;
	}
	public void setAttendance(Long attendance) {
		this.attendance = attendance;
	}
	public String getDate_attendence() {
		return date_attendence;
	}
	public void setDate_attendence(String date_attendence) {
		this.date_attendence = date_attendence;
	}
}
