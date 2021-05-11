package sgsits.cse.dis.moodle.response;

public class TotalStudentAttendanceData {
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String coursename;
	private Long attendance;
	private Long slot;
	private Double percentage;
	private String coursecode;
	
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
	
	public TotalStudentAttendanceData(Long id, String username, String firstname, String lastname, String coursename,
			Long attendance, Long slot, Double percentage,String coursecode) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.coursename = coursename;
		this.attendance = attendance;
		this.slot = slot;
		this.percentage = percentage;
		this.coursecode=coursecode;
		
	}
	public TotalStudentAttendanceData() {
		super();
	}
	
}
