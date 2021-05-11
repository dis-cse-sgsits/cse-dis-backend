package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mdl_context")
public class MoodleContext {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "contextlevel", nullable = false)
	private Long contextlevel;
	
	@Column(name = "instanceid", nullable = false)
	private Long instanceid;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "depth", nullable = false)
	private Integer depth;

	public MoodleContext() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContextlevel() {
		return contextlevel;
	}

	public void setContextlevel(Long contextlevel) {
		this.contextlevel = contextlevel;
	}

	public Long getInstanceid() {
		return instanceid;
	}

	public void setInstanceid(Long instanceid) {
		this.instanceid = instanceid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
}
