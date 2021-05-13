package sgsits.cse.dis.academics.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.MEScholarship;
import sgsits.cse.dis.academics.request.CancelScholarship;
import sgsits.cse.dis.academics.response.MEScholarshipStudents;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.MEScholarshipService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/MEScholarship")
@Api(value = "ME Scholarship")
public class MEScholarshipController {

    @Autowired
    private MEScholarshipService meScholarshipService;

    private JwtResolver jwtResolver = new JwtResolver();

    @ApiOperation(value = "Fetch all ME students without scholarship", response = MEScholarshipStudents.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.FETCH_ME_STUDENTS_WITHOUT_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> fetchMEStudentsWithoutScholarship(HttpServletRequest request, @PathVariable("year") int year)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<MEScholarshipStudents>>(meScholarshipService.fetchMEStudentsWithoutScholarship(year), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Approve students for scholarship", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.APPROVE_STUDENTS_FOR_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> approveStudents(HttpServletRequest request, @RequestBody List<MEScholarshipStudents> students)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(meScholarshipService.approveStudents(students)), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Fetch all ME students with scholarship", response = MEScholarshipStudents.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.FETCH_ME_STUDENTS_WITH_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> fetchMEStudentsWithScholarship(HttpServletRequest request, @PathVariable("year") int year)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<MEScholarship>>(meScholarshipService.fetchMEStudentsWithScholarship(year), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Cancel scholarship", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.CANCEL_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> cancelScholarship(HttpServletRequest request, @RequestBody CancelScholarship cancelScholarship)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(meScholarshipService.cancelScholarship(cancelScholarship)), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Search students without scholarship", response = MEScholarshipStudents.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.SEARCH_STUDENTS_WITHOUT_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> searchStudentsWithoutScholarship(HttpServletRequest request, @RequestParam("year") int year, @RequestParam("name") String name)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<MEScholarshipStudents>> (meScholarshipService.searchStudentsWithoutScholarship(year, name), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Search students with scholarship", response = MEScholarship.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.SEARCH_STUDENTS_WITH_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<?> searchStudentsWithScholarship(HttpServletRequest request, @RequestParam("year") int year, @RequestParam("name") String name)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<MEScholarship>> (meScholarshipService.searchStudentsWithScholarship(year, name), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }
}
