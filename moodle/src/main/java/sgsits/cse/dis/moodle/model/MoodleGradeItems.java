package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_grade_items")
public class MoodleGradeItems {
	@Id
	@Column(name = "id",nullable = false, unique = true)
	private Long id;
	
	@Column(name = "courseid", nullable = false)
	private Long courseid;
	
	@Column(name = "categoryid")
	private Long categoryid;
	
	@Column(name = "itemname", nullable = false)
	private String itemname;
	
	@Column(name = "itemtype", nullable = false)
	private String itemtype;
	
	@Column(name = "itemmodule")
	private String itemmodule;
	
	@Column(name = "iteminstance", nullable = false)
	private Long iteminstance;
	
	@Column(name = "itemnumber")
	private Long itemnumber;
	
	@Column(name = "iteminfo")
	private String iteminfo;
	
	@Column(name = "idnumber")
	private String idnumber;
	
	@Column(name = "calculation")
	private String calculation;
	
	@Column(name = "gradetype", nullable = false)
	private short gradetype;
	
	@Column(name = "grademax", nullable = false)
	private Double grademax;
	
	@Column(name = "grademin", nullable = false)
	private Double grademin;
	
	@Column(name = "scaleid")
	private Long scaleid;
	
	@Column(name = "outcomeid")
	private Long outcomeid;
	
	@Column(name = "gradepass", nullable = false)
	private Double gradepass;
	
	@Column(name = "multfactor", nullable = false)
	private Double multfactor;
	
	@Column(name = "plusfactor", nullable = false)
	private Double plusfactor;
	
	@Column(name = "aggregationcoef", nullable = false)
	private Double aggregationcoef;
	
	@Column(name = "aggregationcoef2", nullable = false)
	private Double aggregationcoef2;
	
	@Column(name = "sortorder", nullable = false)
	private Long sortorder;
	
	@Column(name = "display", nullable = false)
	private Long display;
	
	@Column(name = "decimals")
	private short decimals;
	
	@Column(name = "hidden", nullable = false)
	private Long hidden;
	
	@Column(name = "locked", nullable = false)
	private Long locked;
	
	@Column(name = "locktime", nullable = false)
	private Long locktime;
	
	@Column(name = "needsupdate", nullable = false)
	private Long needsupdate;
	
	@Column(name = "weightoverride", nullable = false)
	private short weightoverride;
	
	@Column(name = "timecreated")
	private Long timecreated;
	
	@Column(name = "timemodified")
	private Long timemodified;

	public MoodleGradeItems() 
	{
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getItemmodule() {
		return itemmodule;
	}

	public void setItemmodule(String itemmodule) {
		this.itemmodule = itemmodule;
	}

	public Long getIteminstance() {
		return iteminstance;
	}

	public void setIteminstance(Long iteminstance) {
		this.iteminstance = iteminstance;
	}

	public Long getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(Long itemnumber) {
		this.itemnumber = itemnumber;
	}

	public String getIteminfo() {
		return iteminfo;
	}

	public void setIteminfo(String iteminfo) {
		this.iteminfo = iteminfo;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getCalculation() {
		return calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public short getGradetype() {
		return gradetype;
	}

	public void setGradetype(short gradetype) {
		this.gradetype = gradetype;
	}

	public Double getGrademax() {
		return grademax;
	}

	public void setGrademax(Double grademax) {
		this.grademax = grademax;
	}

	public Double getGrademin() {
		return grademin;
	}

	public void setGrademin(Double grademin) {
		this.grademin = grademin;
	}

	public Long getScaleid() {
		return scaleid;
	}

	public void setScaleid(Long scaleid) {
		this.scaleid = scaleid;
	}

	public Long getOutcomeid() {
		return outcomeid;
	}

	public void setOutcomeid(Long outcomeid) {
		this.outcomeid = outcomeid;
	}

	public Double getGradepass() {
		return gradepass;
	}

	public void setGradepass(Double gradepass) {
		this.gradepass = gradepass;
	}

	public Double getMultfactor() {
		return multfactor;
	}

	public void setMultfactor(Double multfactor) {
		this.multfactor = multfactor;
	}

	public Double getPlusfactor() {
		return plusfactor;
	}

	public void setPlusfactor(Double plusfactor) {
		this.plusfactor = plusfactor;
	}

	public Double getAggregationcoef() {
		return aggregationcoef;
	}

	public void setAggregationcoef(Double aggregationcoef) {
		this.aggregationcoef = aggregationcoef;
	}

	public Double getAggregationcoef2() {
		return aggregationcoef2;
	}

	public void setAggregationcoef2(Double aggregationcoef2) {
		this.aggregationcoef2 = aggregationcoef2;
	}

	public Long getSortorder() {
		return sortorder;
	}

	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}

	public Long getDisplay() {
		return display;
	}

	public void setDisplay(Long display) {
		this.display = display;
	}

	public short getDecimals() {
		return decimals;
	}

	public void setDecimals(short decimals) {
		this.decimals = decimals;
	}

	public Long getHidden() {
		return hidden;
	}

	public void setHidden(Long hidden) {
		this.hidden = hidden;
	}

	public Long getLocked() {
		return locked;
	}

	public void setLocked(Long locked) {
		this.locked = locked;
	}

	public Long getLocktime() {
		return locktime;
	}

	public void setLocktime(Long locktime) {
		this.locktime = locktime;
	}

	public Long getNeedsupdate() {
		return needsupdate;
	}

	public void setNeedsupdate(Long needsupdate) {
		this.needsupdate = needsupdate;
	}

	public short getWeightoverride() {
		return weightoverride;
	}

	public void setWeightoverride(short weightoverride) {
		this.weightoverride = weightoverride;
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
