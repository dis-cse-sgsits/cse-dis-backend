package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mdl_role_assignments")
public class MoodleRoleAssignments {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "roleid", nullable = false)
	private Long roleid;
	
	@Column(name = "contextid", nullable = false)
	private Long contextid;
	
	@Column(name = "userid", nullable = false)
	private Long userid;
	
	@Column(name = "timemodified", nullable = false)
	private Long timemodified;
	
	@Column(name = "modifierid", nullable = false)
	private Long modifierid;
	
	@Column(name = "component", nullable = false)
	private String component;
	
	@Column(name = "itemid", nullable = false)
	private Long itemid;
	
	@Column(name = "sortorder", nullable = false)
	private Long sortorder;

	public MoodleRoleAssignments() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Long getContextid() {
		return contextid;
	}

	public void setContextid(Long contextid) {
		this.contextid = contextid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}

	public Long getModifierid() {
		return modifierid;
	}

	public void setModifierid(Long modifierid) {
		this.modifierid = modifierid;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getSortorder() {
		return sortorder;
	}

	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}
}
