package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(StaffLifelongLeaveId.class)
@Table(name = "staff_lifelong_leave")
public class StaffLifelongLeave {
    
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "leave_name")
    private String leaveName;

    @Column(name = "leaves_applied")
    private double leavesApplied;

    @Column(name = "leaves_left")
    private double leavesLeft;

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

    public double getLeavesApplied() {
        return leavesApplied;
    }

    public void setLeavesApplied(double leavesApplied) {
        this.leavesApplied = leavesApplied;
    }

    public StaffLifelongLeave() {
    }

    public double getLeavesLeft() {
        return leavesLeft;
    }

    public void setLeavesLeft(double leavesLeft) {
        this.leavesLeft = leavesLeft;
    }

    public StaffLifelongLeave(String userId, String leaveName, double leavesApplied, double leavesLeft) {
        this.userId = userId;
        this.leaveName = leaveName;
        this.leavesApplied = leavesApplied;
        this.leavesLeft = leavesLeft;
    }

    
}