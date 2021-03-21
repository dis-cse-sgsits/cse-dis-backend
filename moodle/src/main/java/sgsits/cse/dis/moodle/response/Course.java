package sgsits.cse.dis.moodle.response;

public class Course {
	private Long id;
	private String fullname,shortname;
	
	public Course() {
		super();
	}

	public Course(Long id, String fullname, String shortname) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.shortname = shortname;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
