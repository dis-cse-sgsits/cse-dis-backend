package sgsits.cse.dis.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.StaffLifelongLeave;
import sgsits.cse.dis.user.model.StaffLifelongLeaveId;

public interface StaffLifelongLeaveRepository extends JpaRepository<StaffLifelongLeave, StaffLifelongLeaveId> {
    Boolean existsByUserIdAndLeaveName(String userId, String leaveName);

	StaffLifelongLeave findByUserIdAndLeaveName(String userId,String leaveName);
}
