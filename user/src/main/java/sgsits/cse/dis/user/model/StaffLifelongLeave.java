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

    private int leavesApplied;

    private int leavesLeft;

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

    public int getLeavesApplied() {
        return leavesApplied;
    }

    public void setLeavesApplied(int leavesApplied) {
        this.leavesApplied = leavesApplied;
    }

    public StaffLifelongLeave() {
    }

    public int getLeavesLeft() {
        return leavesLeft;
    }

    public void setLeavesLeft(int leavesLeft) {
        this.leavesLeft = leavesLeft;
    }

    public StaffLifelongLeave(String userId, String leaveName, int leavesApplied, int leavesLeft) {
        this.userId = userId;
        this.leaveName = leaveName;
        this.leavesApplied = leavesApplied;
        this.leavesLeft = leavesLeft;
    }
}
