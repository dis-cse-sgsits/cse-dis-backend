package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_tag_instance")
public class MoodleTagInstance {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="tagid",nullable = false)
	private Long tagid;
	
	@Column(name="component",nullable = false)
	private String component;
	
	@Column(name="itemtype",nullable = false)
	private String itemtype;
	
	@Column(name="itemid",nullable = false)
	private Long itemid;
	
	@Column(name="contextid",nullable = false)
	private Long contextid;
	
	@Column(name="tiuserid",nullable = false)
	private Long tiuserid;
	
	@Column(name="ordering",nullable = false)
	private Long ordering;
	
	@Column(name="timecreated",nullable = false)
	private Long timecreated;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	

	public MoodleTagInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoodleTagInstance(Long id, Long tagid, String component, String itemtype, Long itemid, Long contextid,
			Long tiuserid, Long ordering, Long timecreated, Long timemodified) {
		super();
		this.id = id;
		this.tagid = tagid;
		this.component = component;
		this.itemtype = itemtype;
		this.itemid = itemid;
		this.contextid = contextid;
		this.tiuserid = tiuserid;
		this.ordering = ordering;
		this.timecreated = timecreated;
		this.timemodified = timemodified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTagid() {
		return tagid;
	}

	public void setTagid(Long tagid) {
		this.tagid = tagid;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getContextid() {
		return contextid;
	}

	public void setContextid(Long contextid) {
		this.contextid = contextid;
	}

	public Long getTiuserid() {
		return tiuserid;
	}

	public void setTiuserid(Long tiuserid) {
		this.tiuserid = tiuserid;
	}

	public Long getOrdering() {
		return ordering;
	}

	public void setOrdering(Long ordering) {
		this.ordering = ordering;
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
