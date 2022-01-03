package sgsits.cse.dis.moodle.response;

import java.util.List;

public class StudentOverallAttendanceData {
   private List<MoodleCourseCategoriesResponse> moodleCategoriesResponse;	
   private Long userid;
   private String username;
   private String firstname;
   private String lastname;
   private Long count;
   private Double overallpercent;
   private Long  totalAttendance;
   private Long  totalSlot;
   private Double  overallPercentageDifference;
   private String CategoryName;
   private Long categoryid;

public StudentOverallAttendanceData(Long userid, String username, String firstname, String lastname, Long count,
		Double overallpercentage, Long totalAttendance, Long totalSlot, Double overallPercentageDifference,String CategoryName,Long categoryid) {
	super();
	this.userid = userid;
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.count = count;
	this.overallpercent = overallpercentage;
	this.totalAttendance = totalAttendance;
	this.totalSlot = totalSlot;
	this.overallPercentageDifference = overallPercentageDifference;
	this.CategoryName=CategoryName;
	this.categoryid=categoryid;
}


public Long getCategoryid() {
	return categoryid;
}


public void setCategoryid(Long categoryid) {
	this.categoryid = categoryid;
}


public List<MoodleCourseCategoriesResponse> getMoodleCategoriesResponse() {
	return moodleCategoriesResponse;
}

public String getCategoryName() {
	return CategoryName;
}

public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}

public void setMoodleCategoriesResponse(List<MoodleCourseCategoriesResponse> moodleCategoriesResponse) {
	this.moodleCategoriesResponse = moodleCategoriesResponse;
}

public Long getTotalAttendance() {
	return totalAttendance;
}
public void setTotalAttendance(Long totalAttendance) {
	this.totalAttendance = totalAttendance;
}
public Long getTotalSlot() {
	return totalSlot;
}
public void setTotalSlot(Long totalSlot) {
	this.totalSlot = totalSlot;
}
public Double getOverallPercentageDifference() {
	return overallPercentageDifference;
}
public void setOverallPercentageDifference(Double overallPercentageDifference) {
	this.overallPercentageDifference = overallPercentageDifference;
}
public StudentOverallAttendanceData() {
	super();
	// TODO Auto-generated constructor stub
}
public StudentOverallAttendanceData(Long userid, String username, String firstname, String lastname, Long count,
		Double overallpercentage) {
	super();
	this.userid = userid;
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.count = count;
	this.overallpercent = overallpercentage;
}
public Long getUserid() {
	return userid;
}
public void setUserid(Long userid) {
	this.userid = userid;
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
public Long getCount() {
	return count;
}
public void setCount(Long count) {
	this.count = count;
}
public Double getOverallpercent() {
	return overallpercent;
}
public void setOverallpercent(Double overallpercentage) {
	this.overallpercent = overallpercentage;
}
   
}
