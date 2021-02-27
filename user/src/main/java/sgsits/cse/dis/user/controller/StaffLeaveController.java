package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.ApplyStaffLeaveForm;
import sgsits.cse.dis.user.message.request.CreateStaffLeaveForm;
import sgsits.cse.dis.user.message.request.StaffRejoinForm;
import sgsits.cse.dis.user.message.request.UpdateStatusForm;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.message.response.StaffLeaveResponse;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveTypes;
import sgsits.cse.dis.user.serviceImpl.StaffLeaveServiceImpl;

@CrossOrigin(origins = "*")
@RestController
// @RequestMapping(path = "/leave")
public class StaffLeaveController {

    @Autowired
    private StaffLeaveServiceImpl staffLeaveServiceImpl;

    JwtResolver jwtResolver = new JwtResolver();

    @ApiOperation(value = "apply for leave", response = StaffLeaveResponse.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.APPLY_LEAVE, produces = "application/json")
    public ResponseEntity<StaffLeaveResponse> applyLeave(@RequestBody ApplyStaffLeaveForm applyStaffLeaveForm,
            HttpServletRequest request) {

        Long leaveId;
        String token = request.getHeader("Authorization");
        applyStaffLeaveForm.setAppliedBy(jwtResolver.getUserNameFromJwtToken(token));
        applyStaffLeaveForm.setUserId(jwtResolver.getIdFromJwtToken(token));
        leaveId = staffLeaveServiceImpl.applyLeave(applyStaffLeaveForm);
        if (leaveId != -1l)
            return new ResponseEntity<StaffLeaveResponse>(
                    new StaffLeaveResponse(" Leave applied successfully.", leaveId), HttpStatus.OK);
        else
            return new ResponseEntity<StaffLeaveResponse>(
                    new StaffLeaveResponse(" Leave cannot be applied due to date issue.", leaveId), HttpStatus.OK);

    }

    @ApiOperation(value = "creates new staff leave", httpMethod = "POST", produces = "text/plain")
    @PostMapping(path = RestAPI.CREATE_NEW_LEAVE, produces = "text/plain")
    public ResponseEntity<String> createNewLeave(@Valid @RequestBody CreateStaffLeaveForm createStaffLeaveForm,
            HttpServletRequest request) {
        if(staffLeaveServiceImpl.createNewLeave(createStaffLeaveForm)==1)
            return new ResponseEntity<String>("new leave created", HttpStatus.OK);
        else
            return new ResponseEntity<String>("new leave cannot be created", HttpStatus.OK);
        

    }

    // @ApiOperation(value = "get staff leave settings", response = StaffLeaveSettings.class, httpMethod = "GET", produces = "application/json")
    // @GetMapping(path = RestAPI.GET_LEAVE_SETTINGS)
    // public ResponseEntity<StaffLeaveSettings> getSettings() {
    //     return new ResponseEntity<StaffLeaveSettings>(staffLeaveServiceImpl.getSettings(), HttpStatus.OK);
    // }

    // @ApiOperation(value = "update staff leave settings", httpMethod = "PUT", produces = "text/plain")
    // @PutMapping(path = RestAPI.UPDATE_LEAVE_SETTINGS, produces = "text/plain")
    // public ResponseEntity<String> updateSettings(@RequestBody StaffLeaveSettingsForm staffLeaveSettingsForm) {
    //     long leaves;
    //     leaves = staffLeaveServiceImpl.updateSettings(staffLeaveSettingsForm);
    //     return new ResponseEntity<String>("Settings Updated.", HttpStatus.OK);
    // }

    @ApiOperation(value = "apply for leave", response = StaffLeave.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.GET_LEAVE_BY_STATUS, produces = "application/json")
    public List<StaffLeave> getLeaveByStatus(HttpServletRequest request, @PathVariable String status) {
        return staffLeaveServiceImpl.getLeavesByStatus(status);
    }

    @ApiOperation(value = "update staff leave status", httpMethod = "PUT", produces = "text/plain")
    @PutMapping(path = RestAPI.UPDATE_STATUS_BY_LEAVE_ID, produces = "text/plain")
    public ResponseEntity<String> updateStatus(@RequestBody UpdateStatusForm updateStatus, HttpServletRequest request) {
        if(staffLeaveServiceImpl.updateStatusByLeaveId(updateStatus)==1)
            return new ResponseEntity<String>("Status Updated.", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Status cannot be updated.", HttpStatus.OK);
    }

    @ApiOperation(value = "get leaves left by user name", httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.GET_LEAVES_LEFT_BY_NAME, produces = "application/json")
    public ResponseEntity<List<StaffLeaveAccountResponse>> getLeavesLeft(@RequestParam("name") String userName) {
        return new ResponseEntity<List<StaffLeaveAccountResponse>>(staffLeaveServiceImpl.getLeaveLeft(userName),
                HttpStatus.OK);
    }

    @ApiOperation(value = "get all leaves applied by name", httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.GET_ALL_LEAVES_FOR_FACULTY, produces = "application/json")
    public ResponseEntity<List<StaffLeave>> getAllLeaves(@RequestParam("name") String name) {
        return new ResponseEntity<List<StaffLeave>>(staffLeaveServiceImpl.getAllLeavesByName(name), HttpStatus.OK);
    }

    @ApiOperation(value = "get all leave types", httpMethod = "GET", produces =  "application/json")
    @GetMapping(path = "/getAllLeaveTypes")
    public ResponseEntity<List<StaffLeaveTypes>> getAllLeaveTypes()
    {
        return new ResponseEntity<List<StaffLeaveTypes>>(staffLeaveServiceImpl.getAllLeaveTypes(), HttpStatus.OK); 
    }

    @ApiOperation(value = "rejoining after leave", httpMethod = "PUT", produces = "text/plain")
    @PutMapping(path = RestAPI.REJOIN_AFTER_LEAVE, produces = "text/plain")
    public ResponseEntity<String> rejoin(@RequestBody StaffRejoinForm staffRejoinForm, HttpServletRequest request) {
        staffLeaveServiceImpl.rejoin(staffRejoinForm);
        return new ResponseEntity<>("LEave Updated", HttpStatus.OK);
    }

    @GetMapping(path = "/play")
    public int updateStatus() {

        // StaffLeaveSettings top =
        // staffLeaveSettingsRepository.findTopByOrderByIdDesc();
        // return staffLeaveServiceImpl.getAllLeavesByName();
        // String token=request.getHeader("Authorization");
        // return jwtResolver.getUserTypeFromJwtToken(token);
        // return
        // staffLeaveLeftRepository.findByUserIdAndYear(jwtResolver.getIdFromJwtToken(token),
        // 2020);
        // return staffLeaveRepository.findByAppliedBy("uthakar");
        // return s.findLeaveTypeByLeaveName("cl");
        staffLeaveServiceImpl.addToTable("el", "a3cf94e4-20b1-11ea-bbd9-acd1b8c931f7");
        return 0;
    }
}

// { 
// 	"details": "Optional leave",
// 	"fromDate": "14-06-1999", 
// 	"halfdayFullday": "full", 
// 	"remarks": "remark", 
//     "status": "pending", 
//     "subject": "sub", 
//     "toDate": "30-06-1999", 
//     "typeOfLeave": "EL"
	
// }