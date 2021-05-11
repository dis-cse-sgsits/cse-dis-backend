package sgsits.cse.dis.moodle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mdl_tag")
public class MoodleTag {
	@Id
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="userid",nullable = false)
	private Long userid;
	
	@Column(name="tagcollid",nullable = false)
	private Long tagcollid;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="rawname",nullable = false)
	private String rawname;
	
	@Column(name="isstandard",nullable = false)
	private Integer isstandard;
	
	@Column(name="description")
	private String description;
	
	@Column(name="descriptionformat",nullable = false)
	private Integer descriptionformat;
	
	@Column(name="flag",nullable = false)
	private Integer flag;
	
	@Column(name="timemodified",nullable = false)
	private Long timemodified;
	
	

	public MoodleTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoodleTag(Long id, Long userid, Long tagcollid, String name, String rawname, Integer isstandard,
			String description, Integer descriptionformat, Integer flag, Long timemodified) {
		super();
		this.id = id;
		this.userid = userid;
		this.tagcollid = tagcollid;
		this.name = name;
		this.rawname = rawname;
		this.isstandard = isstandard;
		this.description = description;
		this.descriptionformat = descriptionformat;
		this.flag = flag;
		this.timemodified = timemodified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getTagcollid() {
		return tagcollid;
	}

	public void setTagcollid(Long tagcollid) {
		this.tagcollid = tagcollid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRawname() {
		return rawname;
	}

	public void setRawname(String rawname) {
		this.rawname = rawname;
	}

	public Integer getIsstandard() {
		return isstandard;
	}

	public void setIsstandard(Integer isstandard) {
		this.isstandard = isstandard;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getTimemodified() {
		return timemodified;
	}

	public void setTimemodified(Long timemodified) {
		this.timemodified = timemodified;
	}
	
	
}
