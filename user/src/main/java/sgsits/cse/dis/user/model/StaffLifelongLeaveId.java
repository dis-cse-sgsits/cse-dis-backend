package sgsits.cse.dis.user.model;

import java.io.Serializable;

import javax.persistence.Column;

public class StaffLifelongLeaveId implements Serializable {
    
    @Column(name = "user_id")
    private String userId;

    @Column(name = "leave_name")
    private String leaveName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public StaffLifelongLeaveId(String userId, String leaveName) {
        this.userId = userId;
        this.leaveName = leaveName;
    }

    public StaffLifelongLeaveId() {
    }

}