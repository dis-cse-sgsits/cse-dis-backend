package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.user.model.StaffLifelongLeave;
import sgsits.cse.dis.user.model.StaffLifelongLeaveId;

public interface StaffLifelongLeaveRepository extends JpaRepository<StaffLifelongLeave, StaffLifelongLeaveId> {
    Boolean existsByUserIdAndLeaveName(String userId, String leaveName);

	StaffLifelongLeave findByUserIdAndLeaveName(String userId,String leaveName);

    @Modifying
    @Query(value = "UPDATE staff_lifelong_leave SET leaves_left = leaves_left + ?1 WHERE user_id = ?2 AND leave_name = ?3", nativeQuery=true)
    void creditLeave(int leaves_left, String userId, String leaveName);
}
