package sgsits.cse.dis.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(StaffLifelongLeaveId.class)
public class StaffLifelongLeave {
    
    @Id
    private String userId;

    @Id
    private String leaveName;

    private double leavesApplied;

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
