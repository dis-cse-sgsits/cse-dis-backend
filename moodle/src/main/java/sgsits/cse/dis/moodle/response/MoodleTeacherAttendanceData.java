package sgsits.cse.dis.moodle.response;

import java.util.List;

public class MoodleTeacherAttendanceData {
 private Long userid;
 private List<Long> tableid;
 private String username;
 private String subjectid;
 public List<Long> getTableid() {
	return tableid;
}
public void setTableid(List<Long> tableid) {
	this.tableid = tableid;
}
private Long slot;
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
public String getSubjectid() {
	return subjectid;
}
public void setSubjectid(String subjectid) {
	this.subjectid = subjectid;
}
public Long getSlot() {
	return slot;
}
public void setSlot(Long slot) {
	this.slot = slot;
} 
}
