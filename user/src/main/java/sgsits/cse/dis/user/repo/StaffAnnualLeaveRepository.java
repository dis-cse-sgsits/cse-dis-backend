package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.StaffAnnualLeave;
import sgsits.cse.dis.user.model.StaffAnnualLeaveId;

public interface StaffAnnualLeaveRepository extends JpaRepository<StaffAnnualLeave, StaffAnnualLeaveId> {
    Boolean existsByUserIdAndLeaveNameAndToDate(String userId, String leaveName, String toDate); 
    StaffAnnualLeave findByUserIdAndLeaveNameAndToDate(String userId, String leaveName, String toDate);
}
