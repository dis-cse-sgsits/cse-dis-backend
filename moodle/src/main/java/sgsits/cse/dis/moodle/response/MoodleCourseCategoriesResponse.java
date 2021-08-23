package sgsits.cse.dis.moodle.response;

public class MoodleCourseCategoriesResponse {
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String coursename;
	private Long attendance;
	private Long slot;
	private Double percentage;
	public MoodleCourseCategoriesResponse(Long id, String username, String firstname, String lastname,
			String coursename, Long attendance, Long slot, Double percentage, String coursecode,
			Double percentagedifference, Double percentageassigned) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.coursename = coursename;
		this.attendance = attendance;
		this.slot = slot;
		this.percentage = percentage;
		this.coursecode = coursecode;
		this.percentagedifference = percentagedifference;
		this.percentageassigned = percentageassigned;
	}
	private String coursecode;
	private Double percentagedifference;
	public Double getPercentagedifference() {
		return percentagedifference;
	}
	public void setPercentagedifference(Double percentagedifference) {
		this.percentagedifference = percentagedifference;
	}
	private Double percentageassigned;
	
	public Double getPercentageassigned() {
		return percentageassigned;
	}
	public void setPercentageassigned(Double percentageassigned) {
		this.percentageassigned = percentageassigned;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
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
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Long getAttendance() {
		return attendance;
	}
	public void setAttendance(Long attendance) {
		this.attendance = attendance;
	}
	public Long getSlot() {
		return slot;
	}
	public void setSlot(Long slot) {
		this.slot = slot;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public MoodleCourseCategoriesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
