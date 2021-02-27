package sgsits.cse.dis.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(StaffAnnualLeaveId.class)
public class StaffAnnualLeave {

    @Id
    private String userId;

    @Id
    private String toDate;

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

    public StaffAnnualLeave() {
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getLeavesLeft() {
        return leavesLeft;
    }

    public void setLeavesLeft(int leavesLeft) {
        this.leavesLeft = leavesLeft;
    }

    public StaffAnnualLeave(String userId, String toDate, String leaveName, int leavesApplied, int leavesLeft) {
        this.userId = userId;
        this.toDate = toDate;
        this.leaveName = leaveName;
        this.leavesApplied = leavesApplied;
        this.leavesLeft = leavesLeft;
    }

}
