package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_grade_grades")
public class MoodleGradeGrades {
	@Id
	@Column(name = "id",nullable = false, unique = true)
	private Long id;
	
	@Column(name = "itemid", nullable = false)
	private Long itemid;
	
	@Column(name = "userid", nullable = false)
	private Long userid;
	
	@Column(name = "rawgrade")
	private Double rawgrade;

	@Column(name = "rawgrademax", nullable = false)
	private Double rawgrademax;
	
	@Column(name = "rawgrademin", nullable = false)
	private Double rawgrademin;
	
	@Column(name = "rawscaleid")
	private Long rawscaleid;
	
	@Column(name = "usermodified")
	private Long usermodified;
	
	@Column(name = "finalgrade")
	private Double finalgrade;
	
	@Column(name = "hidden", nullable = false)
	private Long hidden;
	
	@Column(name = "locked", nullable = false)
	private Long locked;

	@Column(name = "locktime", nullable = false)
	private Long locktime;
	
	@Column(name = "exported", nullable = false)
	private Long exported;
	
	@Column(name = "overridden", nullable = false)
	private Long overridden;
	
	@Column(name = "excluded", nullable = false)
	private Long excluded;
	
	@Column(name = "feedback")
	private String feedback;

	@Column(name = "feedbackformat", nullable = false)
	private Long feedbackformat;
	
	@Column(name = "information")
	private String information;
	
	@Column(name = "informationformat", nullable = false)
	private Long informationformat;
	
	@Column(name = "timecreated")
	private Long timecreated;
	
	@Column(name = "timemodified")
	private Long timemodified;
	
	@Column(name = "aggregationstatus", nullable = false)
	private String aggregationstatus;
	
	@Column(name = "aggregationweight")
	private Double aggregationweight;
	
	public MoodleGradeGrades()
	{
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Double getRawgrade() {
		return rawgrade;
	}

	public void setRawgrade(Double rawgrade) {
		this.rawgrade = rawgrade;
	}

	public Double getRawgrademax() {
		return rawgrademax;
	}

	public void setRawgrademax(Double rawgrademax) {
		this.rawgrademax = rawgrademax;
	}

	public Double getRawgrademin() {
		return rawgrademin;
	}

	public void setRawgrademin(Double rawgrademin) {
		this.rawgrademin = rawgrademin;
	}

	public Long getRawscaleid() {
		return rawscaleid;
	}

	public void setRawscaleid(Long rawscaleid) {
		this.rawscaleid = rawscaleid;
	}

	public Long getUsermodified() {
		return usermodified;
	}

	public void setUsermodified(Long usermodified) {
		this.usermodified = usermodified;
	}

	public Double getFinalgrade() {
		return finalgrade;
	}

	public void setFinalgrade(Double finalgrade) {
		this.finalgrade = finalgrade;
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

	public Long getExported() {
		return exported;
	}

	public void setExported(Long exported) {
		this.exported = exported;
	}

	public Long getOverridden() {
		return overridden;
	}

	public void setOverridden(Long overridden) {
		this.overridden = overridden;
	}

	public Long getExcluded() {
		return excluded;
	}

	public void setExcluded(Long excluded) {
		this.excluded = excluded;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getFeedbackformat() {
		return feedbackformat;
	}

	public void setFeedbackformat(Long feedbackformat) {
		this.feedbackformat = feedbackformat;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Long getInformationformat() {
		return informationformat;
	}

	public void setInformationformat(Long informationformat) {
		this.informationformat = informationformat;
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

	public String getAggregationstatus() {
		return aggregationstatus;
	}

	public void setAggregationstatus(String aggregationstatus) {
		this.aggregationstatus = aggregationstatus;
	}

	public Double getAggregationweight() {
		return aggregationweight;
	}

	public void setAggregationweight(Double aggregationweight) {
		this.aggregationweight = aggregationweight;
	}
}
