package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StaffLeaveTypes {
    
    @Id
    private String leaveName;

    @Column(nullable = false)
    private String leaveType;

    private String fromDate;
    
    private String toDate;
    
    private int noOfLeaves;

    private String description;

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getNoOfLeaves() {
        return noOfLeaves;
    }

    public void setNoOfLeaves(int noOfLeaves) {
        this.noOfLeaves = noOfLeaves;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StaffLeaveTypes(String leaveName, String leaveType, String fromDate, String toDate, int noOfLeaves,
            String description) {
        this.leaveName = leaveName;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.noOfLeaves = noOfLeaves;
        this.description = description;
    }

    public StaffLeaveTypes() {
    }

    @Override
    public String toString() {
        return "StaffLeaveTypes [description=" + description + ", fromDate=" + fromDate + ", leaveName=" + leaveName
                + ", leaveType=" + leaveType + ", noOfLeaves=" + noOfLeaves + ", toDate=" + toDate + "]";
    }

    
}
