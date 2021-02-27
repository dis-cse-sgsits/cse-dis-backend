package sgsits.cse.dis.user.message.request;

public class StaffRejoinForm {
    Long leaveId;
    String rejoinDate;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public String getRejoinDate() {
        return rejoinDate;
    }

    public void setRejoinDate(String rejoinDate) {
        this.rejoinDate = rejoinDate;
    }

    public StaffRejoinForm() {
    }

    public StaffRejoinForm(Long leaveId, String rejoinDate) {
        this.leaveId = leaveId;
        this.rejoinDate = rejoinDate;
    }

}
