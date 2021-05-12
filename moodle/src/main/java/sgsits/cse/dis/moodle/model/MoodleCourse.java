package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_course")
public class MoodleCourse {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	@Column(name="category",nullable = false)
	private Long category;
	@Column(name="sortorder",nullable = false)
	private Long sortorder;
	@Column(name="fullname",nullable=false)
	private String fullname;
	@Column(name="shortname",nullable=false)
	private String shortname;
	@Column(name="idnumber",nullable=false)
	private String idnumber;
	@Column(name="summary",nullable=false)
	private String summary;
	@Column(name="summaryformat",nullable=false)
	private Integer summaryformat;
	@Column(name="format",nullable=false)
	private String format;
	@Column(name="showgrades",nullable=false)
	private Integer showgrades;
	@Column(name="newsitems",nullable=false)
	private Integer newsitems;
	@Column(name="startdate",nullable = false)
	private Long startdate;
	@Column(name="enddate",nullable = false)
	private Long enddate;
	@Column(name="marker",nullable = false)
	private Long marker;
	@Column(name="maxbytes",nullable = false)
	private Long maxbytes;
	@Column(name="legacyfiles",nullable=false)
	private Integer legacyfiles;
	@Column(name="showreports",nullable=false)
	private Integer showreports;
	@Column(name="visible",nullable=false)
	private Integer visible;
	@Column(name="visibleold",nullable=false)
	private Integer visibleold;
	@Column(name="groupmode",nullable=false)
	private Integer groupmode;
	@Column(name="groupmodeforce",nullable=false)
	private Integer groupmodeforce;
	@Column(name="defaultgroupingid",nullable = false)
	private Long defaultgroupingid;
	@Column(name="lang",nullable=false)
	private String lang;
	@Column(name="calendartype",nullable=false)
	private String calendartype;
	@Column(name="theme",nullable=false)
	private String theme;
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	@Column(name="requested",nullable=false)
	private Integer requested;
	@Column(name="enablecompletion",nullable=false)
	private Integer enablecompletion;
	@Column(name="completionnotify",nullable=false)
	private Integer completionnotify;
	@Column(name="cacherev",nullable = false)
	private Long cacherev;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Long getSortorder() {
		return sortorder;
	}
	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getSummaryformat() {
		return summaryformat;
	}
	public void setSummaryformat(Integer summaryformat) {
		this.summaryformat = summaryformat;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Integer getShowgrades() {
		return showgrades;
	}
	public void setShowgrades(Integer showgrades) {
		this.showgrades = showgrades;
	}
	public Integer getNewsitems() {
		return newsitems;
	}
	public void setNewsitems(Integer newsitems) {
		this.newsitems = newsitems;
	}
	public Long getStartdate() {
		return startdate;
	}
	public void setStartdate(Long startdate) {
		this.startdate = startdate;
	}
	public Long getEnddate() {
		return enddate;
	}
	public void setEnddate(Long enddate) {
		this.enddate = enddate;
	}
	public Long getMarker() {
		return marker;
	}
	public void setMarker(Long marker) {
		this.marker = marker;
	}
	public Long getMaxbytes() {
		return maxbytes;
	}
	public void setMaxbytes(Long maxbytes) {
		this.maxbytes = maxbytes;
	}
	public Integer getLegacyfiles() {
		return legacyfiles;
	}
	public void setLegacyfiles(Integer legacyfiles) {
		this.legacyfiles = legacyfiles;
	}
	public Integer getShowreports() {
		return showreports;
	}
	public void setShowreports(Integer showreports) {
		this.showreports = showreports;
	}
	public Integer getVisible() {
		return visible;
	}
	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	public Integer getVisibleold() {
		return visibleold;
	}
	public void setVisibleold(Integer visibleold) {
		this.visibleold = visibleold;
	}
	public Integer getGroupmode() {
		return groupmode;
	}
	public void setGroupmode(Integer groupmode) {
		this.groupmode = groupmode;
	}
	public Integer getGroupmodeforce() {
		return groupmodeforce;
	}
	public void setGroupmodeforce(Integer groupmodeforce) {
		this.groupmodeforce = groupmodeforce;
	}
	public Long getDefaultgroupingid() {
		return defaultgroupingid;
	}
	public void setDefaultgroupingid(Long defaultgroupingid) {
		this.defaultgroupingid = defaultgroupingid;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getCalendartype() {
		return calendartype;
	}
	public void setCalendartype(String calendartype) {
		this.calendartype = calendartype;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
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
	public Integer getRequested() {
		return requested;
	}
	public void setRequested(Integer requested) {
		this.requested = requested;
	}
	public Integer getEnablecompletion() {
		return enablecompletion;
	}
	public void setEnablecompletion(Integer enablecompletion) {
		this.enablecompletion = enablecompletion;
	}
	public Integer getCompletionnotify() {
		return completionnotify;
	}
	public void setCompletionnotify(Integer completionnotify) {
		this.completionnotify = completionnotify;
	}
	public Long getCacherev() {
		return cacherev;
	}
	public void setCacherev(Long cacherev) {
		this.cacherev = cacherev;
	}
	public MoodleCourse(Long category, Long sortorder, String fullname, String shortname, String idnumber,
			String summary, Integer summaryformat, String format, Integer showgrades, Integer newsitems, Long startdate,
			Long enddate, Long marker, Long maxbytes, Integer legacyfiles, Integer showreports, Integer visible,
			Integer visibleold, Integer groupmode, Integer groupmodeforce, Long defaultgroupingid, String lang,
			String calendartype, String theme, Long timecreated, Long timemodified, Integer requested,
			Integer enablecompletion, Integer completionnotify, Long cacherev) {
		super();
		this.category = category;
		this.sortorder = sortorder;
		this.fullname = fullname;
		this.shortname = shortname;
		this.idnumber = idnumber;
		this.summary = summary;
		this.summaryformat = summaryformat;
		this.format = format;
		this.showgrades = showgrades;
		this.newsitems = newsitems;
		this.startdate = startdate;
		this.enddate = enddate;
		this.marker = marker;
		this.maxbytes = maxbytes;
		this.legacyfiles = legacyfiles;
		this.showreports = showreports;
		this.visible = visible;
		this.visibleold = visibleold;
		this.groupmode = groupmode;
		this.groupmodeforce = groupmodeforce;
		this.defaultgroupingid = defaultgroupingid;
		this.lang = lang;
		this.calendartype = calendartype;
		this.theme = theme;
		this.timecreated = timecreated;
		this.timemodified = timemodified;
		this.requested = requested;
		this.enablecompletion = enablecompletion;
		this.completionnotify = completionnotify;
		this.cacherev = cacherev;
	}
	public MoodleCourse() {
		super();
	}
	
}
