package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.dtos.StaffBasicProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.service.PanelOfPracticalService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin(origins = "*")
@Api(value = "Staff controller")
@RestController
public class PanelOfPractical {

    @Autowired
    PanelOfPracticalService panelOfPracticalService;

    @ApiOperation(value = "Add Panel of practical", response = Object.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(value = "/addPanelOfPractical")
    public ResponseEntity<ResponseMessage> addPanelOfPractical(
            HttpServletRequest request, @RequestBody PanelOfPracticalDto panelOfPracticalDto)
            throws InternalServerError {
        panelOfPracticalService.addPanelOfPractical(panelOfPracticalDto);
        return ResponseEntity.status(HttpStatus.OK).body( new ResponseMessage("Panel of Practical Successfully Added"));
    }
}
