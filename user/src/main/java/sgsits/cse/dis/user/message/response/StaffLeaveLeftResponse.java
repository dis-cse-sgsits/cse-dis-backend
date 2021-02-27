package sgsits.cse.dis.user.message.response;

public class StaffLeaveLeftResponse {
    
    // String userName;
    String leaveName;
    String toDate;
    long leavesApplied;
    long leavesLeft;

    // public String getUserName() {
    //     return userName;
    // }

    // public void setUserName(String userName) {
    //     this.userName = userName;
    // }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public long getLeavesApplied() {
        return leavesApplied;
    }

    public void setLeavesApplied(long leavesApplied) {
        this.leavesApplied = leavesApplied;
    }

    public long getLeavesLeft() {
        return leavesLeft;
    }

    public void setLeavesLeft(long leavesLeft) {
        this.leavesLeft = leavesLeft;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    // public StaffLeaveLeftResponse(String userName, String leaveName, long leavesApplied, long leavesLeft) {
    //     this.userName = userName;
    //     this.leaveName = leaveName;
    //     this.leavesApplied = leavesApplied;
    //     this.leavesLeft = leavesLeft;
    // }
    


    
}