package sgsits.cse.dis.user.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.ApplyStaffLeaveForm;
import sgsits.cse.dis.user.message.request.CreateStaffLeaveForm;
import sgsits.cse.dis.user.message.request.StaffLeaveCreditForm;
import sgsits.cse.dis.user.message.request.StaffRejoinForm;
import sgsits.cse.dis.user.message.request.UpdateStatusForm;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveTypes;


@Component
public interface StaffLeaveService {
    
    Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm) throws ConflictException, ParseException;
    
    List<StaffLeave> getLeavesByStatus(String status);
    
    int updateStatusByLeaveId(UpdateStatusForm updateStatus) throws ConflictException;
    
    List<StaffLeaveAccountResponse> getLeaveLeft(String userName);
    
    List<StaffLeave> getAllLeaves();

    List<StaffLeave> getMyLeaves(String username);
    
    int createNewLeave(CreateStaffLeaveForm createStaffLeaveForm) throws ConflictException;
    
    List<StaffLeaveTypes> getAllLeaveTypes();
    
    void rejoin(StaffRejoinForm staffRejoinForm) throws ParseException;
    
    String creditLeave(StaffLeaveCreditForm staffLeaveCreditForm) throws ConflictException;
    
    long updateLeave(ApplyStaffLeaveForm applyStaffLeaveForm) throws ConflictException, ParseException;

    StaffLeaveAccountResponse getMyLeaveAccount(String username);
}