package sgsits.cse.dis.moodle.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="mdl_user")
public class MoodleUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public MoodleUser() {
		super();
	}
	
	public MoodleUser(String idnumber, String firstname, String lastname, String email) {
		super();
		this.idnumber = idnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "auth" )
	private String auth;
	
	@Column(length=1, name="confirmed")
	private Integer confirmed;
	
	@Column(length=1, name="policyagreed")
	private Integer policyagreed;
	
	@Column(length=1, name="deleted")
	private Integer deleted;
	
	@Column(length=1, name="suspended")
	private Integer suspended;
	
	@Column(length=10, name="mnethostid")
	private Integer mnethostid;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "idnumber")
	private String idnumber;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	
	@Column(length=1, name="emailstop")
	private Integer emailstop;
	
	@Column(name = "icq")
	private String icq;
	
	@Column(name = "skype")
	private String skype;
	
	@Column(name = "yahoo")
	private String yahoo;
	
	@Column(name = "aim")
	private String aim;
	
	@Column(name = "msn")
	private String msn;
	
	@Column(name = "phone1")
	private String phone1;
	
	@Column(name = "phone2")
	private String phone2;
	
	@Column(name = "institution")
	private String institution;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(length=2,name = "country")
	private String country;
	
	@Column(name = "lang")
	private String lang;
	
	@Column(name = "calendertype")
	private String calendertype;
	
	@Column(name = "theme")
	private String theme;
	
	@Column(name = "timezone")
	private String timezone;
	
	@Column(name = "firstaccess")
	private Long firstaccess;
	
	@Column(name = "lastaccess")
	private Long lastaccess;
	
	@Column(name = "lastlogin")
	private Long lastlogin;
	
	@Column(name = "currentlogin")
	private Long currentlogin;
	
	@Column(name = "lastip")
	private String lastip;
	
	@Column(name = "secret")
	private String secret;
	
	@Column(name = "picture")
	private Long picture;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "description")
	private String description;
	
	@Column(length=1,name = "descriptionformat")
	private Integer descriptionformat;
	
	@Column(length=1,name = "mailformat")
	private Integer mailformat;
	
	@Column(length=1,name = "maildigest")
	private Integer maildigest;
	
	@Column(length=1,name = "maildisplay")
	private Integer maildisplay;
	
	@Column(length=1,name = "autosubscribe")
	private Integer autosubscribe;
	
	@Column(length=1,name = "trackforums")
	private Integer trackforums;
	
	@Column(length=10,name = "timecreated")
	private Long timecreated;
	
	@Column(length=10,name = "timemodified")
	private Long timemodified;
	
	@Column(length=10,name = "trustbitmask")
	private Long trustbitmask;
	
	@Column(name = "imagealt")
	private String imagealt;
	
	@Column(name = "lastnamephonetic")
	private String lastnamephonetic;
	
	@Column(name = "firstnamephonetic")
	private String firstnamephonetic;
	
	@Column(name = "middlename")
	private String middlename;
	
	@Column(name = "alternatename")
	private String alternatename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Integer getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}

	public Integer getPolicyagreed() {
		return policyagreed;
	}

	public void setPolicyagreed(Integer policyagreed) {
		this.policyagreed = policyagreed;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getSuspended() {
		return suspended;
	}

	public void setSuspended(Integer suspended) {
		this.suspended = suspended;
	}

	public Integer getMnethostid() {
		return mnethostid;
	}

	public void setMnethostid(Integer mnethostid) {
		this.mnethostid = mnethostid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailstop() {
		return emailstop;
	}

	public void setEmailstop(Integer emailstop) {
		this.emailstop = emailstop;
	}

	public String getIcq() {
		return icq;
	}

	public void setIcq(String icq) {
		this.icq = icq;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getYahoo() {
		return yahoo;
	}

	public void setYahoo(String yahoo) {
		this.yahoo = yahoo;
	}

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCalendertype() {
		return calendertype;
	}

	public void setCalendertype(String calendertype) {
		this.calendertype = calendertype;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Long getFirstaccess() {
		return firstaccess;
	}

	public void setFirstaccess(Long firstaccess) {
		this.firstaccess = firstaccess;
	}

	public Long getLastaccess() {
		return lastaccess;
	}

	public void setLastaccess(Long lastaccess) {
		this.lastaccess = lastaccess;
	}

	public Long getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Long lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Long getCurrentlogin() {
		return currentlogin;
	}

	public void setCurrentlogin(Long currentlogin) {
		this.currentlogin = currentlogin;
	}

	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Long getPicture() {
		return picture;
	}

	public void setPicture(Long picture) {
		this.picture = picture;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDescriptionformat() {
		return descriptionformat;
	}

	public void setDescriptionformat(Integer descriptionformat) {
		this.descriptionformat = descriptionformat;
	}

	public Integer getMailformat() {
		return mailformat;
	}

	public void setMailformat(Integer mailformat) {
		this.mailformat = mailformat;
	}

	public Integer getMaildigest() {
		return maildigest;
	}

	public void setMaildigest(Integer maildigest) {
		this.maildigest = maildigest;
	}

	public Integer getMaildisplay() {
		return maildisplay;
	}

	public void setMaildisplay(Integer maildisplay) {
		this.maildisplay = maildisplay;
	}

	public Integer getAutosubscribe() {
		return autosubscribe;
	}

	public void setAutosubscribe(Integer autosubscribe) {
		this.autosubscribe = autosubscribe;
	}

	public Integer getTrackforums() {
		return trackforums;
	}

	public void setTrackforums(Integer trackforums) {
		this.trackforums = trackforums;
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

	public Long getTrustbitmask() {
		return trustbitmask;
	}

	public void setTrustbitmask(Long trustbitmask) {
		this.trustbitmask = trustbitmask;
	}

	public String getImagealt() {
		return imagealt;
	}

	public void setImagealt(String imagealt) {
		this.imagealt = imagealt;
	}

	public String getLastnamephonetic() {
		return lastnamephonetic;
	}

	public void setLastnamephonetic(String lastnamephonetic) {
		this.lastnamephonetic = lastnamephonetic;
	}

	public String getFirstnamephonetic() {
		return firstnamephonetic;
	}

	public void setFirstnamephonetic(String firstnamephonetic) {
		this.firstnamephonetic = firstnamephonetic;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getAlternatename() {
		return alternatename;
	}

	public void setAlternatename(String alternatename) {
		this.alternatename = alternatename;
	}

		
	
}
	
	
	
	

	


	
