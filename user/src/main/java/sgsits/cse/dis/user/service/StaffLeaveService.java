package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.message.request.ApplyStaffLeaveForm;
import sgsits.cse.dis.user.message.request.CreateStaffLeaveForm;
import sgsits.cse.dis.user.message.request.StaffLeaveSettingsForm;
import sgsits.cse.dis.user.message.request.StaffRejoinForm;
import sgsits.cse.dis.user.message.request.UpdateStatusForm;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveSettings;
import sgsits.cse.dis.user.model.StaffLeaveTypes;


@Component
public interface StaffLeaveService {
    
    Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm);
    // long updateSettings(StaffLeaveSettingsForm staffLeaveSettingsForm);
    // StaffLeaveSettings getSettings();
    List<StaffLeave> getLeavesByStatus(String status);
    int updateStatusByLeaveId(UpdateStatusForm updateStatus);
    List<StaffLeaveAccountResponse> getLeaveLeft(String userName);
    List<StaffLeave> getAllLeavesByName(String name);
    int createNewLeave(CreateStaffLeaveForm createStaffLeaveForm);
    List<StaffLeaveTypes> getAllLeaveTypes();
    void rejoin(StaffRejoinForm staffRejoinForm);
}