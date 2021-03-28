package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.StaffLeaveTypes;

@Repository
public interface StaffLeaveTypeRepository extends JpaRepository<StaffLeaveTypes, String> {

    // @Query(value = "SELECT leave_type FROM staff_leave_types WHERE leave_name = ?1",nativeQuery=true)
    String findLeaveTypeByLeaveName(String leaveName);
    StaffLeaveTypes findByLeaveName(String leaveName);
}
