package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_enrol")
public class MoodleEnrollement {
	
	
	public MoodleEnrollement(Long id, String enrol) {
		super();
		this.id = id;
		this.enrol = enrol;
	}
	public MoodleEnrollement() {
		super();
	}
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;	
	
	@Column(name="enrol",nullable = false)
	private String enrol;	
	
	@Column(name="status",nullable = false)
	private Long status	; 
	
	@Column(name="courseid",nullable = false)
	private Long courseid;	
	
	@Column(name="sortorder",nullable = false)
	private Long sortorder;	
	
	@Column(name="name")
	private String name;
	
	@Column(name="enrolperiod")
	private Long enrolperiod;	
	
	@Column(name="enrolstartdate")
	private Long enrolstartdate;
	
	@Column(name="enrolenddate")
	private Long enrolenddate;	
	
	@Column(name="expirynotify")
	private Integer expirynotify;	
	
	@Column(name="expirythreshold")
	private Long expirythreshold;	
	
	@Column(name="notifyall")
	private Integer notifyall;	
	
	@Column(name="password")
	private String password;
	
	@Column(name="cost")
	private String cost;	
	
	@Column(name="currency")
	private String currency;	
	
	@Column(name="roleid")
	private Long roleid;	
	
	@Column(name="customint1")
	private Long customint1;	
	
	@Column(name="customint2")
	private Long customint2;	
	
	@Column(name="customint3")
	private Long customint3;		
	
	@Column(name="customint4")
	private Long customint4;	
	
	@Column(name="customint5")
	private Long customint5;	
	
	@Column(name="customint6")
	private Long customint6;	
	
	@Column(name="customint7")
	private Long customint7; 	
	
	@Column(name="customint8")
	private Long customint8;		
	
	@Column(name="customchar1")
	private String customchar1;	
	
	@Column(name="customchar2")
	private String  customchar2;	
	
	@Column(name="customchar3")
	private String  customchar3;		
	
	@Column(name="customdec1")
	private String customdec1;			
	
	@Column(name="customdec2")
	private String customdec2;	
	
	@Column(name="customtext1")
	private String  customtext1;
	
	@Column(name="customtext2")
	private String  customtext2;
	
	@Column(name="customtext3")
	private String  customtext3;	
	
	@Column(name="customtext4")
	private String  customtext4;	
	
	@Column(name="timecreated")
	private Long timecreated;	
	
	@Column(name="timemodified")
	private Long timemodified;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnrol() {
		return enrol;
	}
	public void setEnrol(String enrol) {
		this.enrol = enrol;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getCourseid() {
		return courseid;
	}
	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	public Long getSortorder() {
		return sortorder;
	}
	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getEnrolperiod() {
		return enrolperiod;
	}
	public void setEnrolperiod(Long enrolperiod) {
		this.enrolperiod = enrolperiod;
	}
	public Long getEnrolstartdate() {
		return enrolstartdate;
	}
	public void setEnrolstartdate(Long enrolstartdate) {
		this.enrolstartdate = enrolstartdate;
	}
	public Long getEnrolenddate() {
		return enrolenddate;
	}
	public void setEnrolenddate(Long enrolenddate) {
		this.enrolenddate = enrolenddate;
	}
	public Integer getExpirynotify() {
		return expirynotify;
	}
	public void setExpirynotify(Integer expirynotify) {
		this.expirynotify = expirynotify;
	}
	public Long getExpirythreshold() {
		return expirythreshold;
	}
	public void setExpirythreshold(Long expirythreshold) {
		this.expirythreshold = expirythreshold;
	}
	public Integer getNotifyall() {
		return notifyall;
	}
	public void setNotifyall(Integer notifyall) {
		this.notifyall = notifyall;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Long getCustomint1() {
		return customint1;
	}
	public void setCustomint1(Long customint1) {
		this.customint1 = customint1;
	}
	public Long getCustomint2() {
		return customint2;
	}
	public void setCustomint2(Long customint2) {
		this.customint2 = customint2;
	}
	public Long getCustomint3() {
		return customint3;
	}
	public void setCustomint3(Long customint3) {
		this.customint3 = customint3;
	}
	public Long getCustomint4() {
		return customint4;
	}
	public void setCustomint4(Long customint4) {
		this.customint4 = customint4;
	}
	public Long getCustomint5() {
		return customint5;
	}
	public void setCustomint5(Long customint5) {
		this.customint5 = customint5;
	}
	public Long getCustomint6() {
		return customint6;
	}
	public void setCustomint6(Long customint6) {
		this.customint6 = customint6;
	}
	public Long getCustomint7() {
		return customint7;
	}
	public void setCustomint7(Long customint7) {
		this.customint7 = customint7;
	}
	public Long getCustomint8() {
		return customint8;
	}
	public void setCustomint8(Long customint8) {
		this.customint8 = customint8;
	}
	public String getCustomchar1() {
		return customchar1;
	}
	public void setCustomchar1(String customchar1) {
		this.customchar1 = customchar1;
	}
	public String getCustomchar2() {
		return customchar2;
	}
	public void setCustomchar2(String customchar2) {
		this.customchar2 = customchar2;
	}
	public String getCustomchar3() {
		return customchar3;
	}
	public void setCustomchar3(String customchar3) {
		this.customchar3 = customchar3;
	}
	public String getCustomdec1() {
		return customdec1;
	}
	public void setCustomdec1(String customdec1) {
		this.customdec1 = customdec1;
	}
	public String getCustomdec2() {
		return customdec2;
	}
	public void setCustomdec2(String customdec2) {
		this.customdec2 = customdec2;
	}
	public String getCustomtext1() {
		return customtext1;
	}
	public void setCustomtext1(String customtext1) {
		this.customtext1 = customtext1;
	}
	public String getCustomtext2() {
		return customtext2;
	}
	public void setCustomtext2(String customtext2) {
		this.customtext2 = customtext2;
	}
	public String getCustomtext3() {
		return customtext3;
	}
	public void setCustomtext3(String customtext3) {
		this.customtext3 = customtext3;
	}
	public String getCustomtext4() {
		return customtext4;
	}
	public void setCustomtext4(String customtext4) {
		this.customtext4 = customtext4;
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

