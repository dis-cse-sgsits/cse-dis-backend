package sgsits.cse.dis.academics.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.model.MEScholarship;
import sgsits.cse.dis.academics.response.MEScholarshipStudents;
import sgsits.cse.dis.academics.service.MEScholarshipService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/MEScholarship")
@Api(value = "ME Scholarship")
public class MEScholarshipController {

    @Autowired
    private MEScholarshipService meScholarshipService;

    @ApiOperation(value = "Fetch all ME students by year", response = MEScholarshipStudents.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.FETCH_ME_STUDENTS_BY_YEAR, produces = "application/json")
    public ResponseEntity<List<MEScholarshipStudents>> fetchMEStudentsByYear(@PathVariable("year") int year)
    {
        return new ResponseEntity<List<MEScholarshipStudents>>(meScholarshipService.fetchMEStudentsByYear(year), HttpStatus.OK);
    }

    @ApiOperation(value = "Approve students for scholarship", response = String.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.APPROVE_STUDENTS_FOR_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<String> approveStudents(@RequestBody List<MEScholarshipStudents> students)
    {
        return new ResponseEntity<String>(meScholarshipService.approveStudents(students), HttpStatus.OK);
    }

    @ApiOperation(value = "View scholarship students", response = MEScholarshipStudents.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.VIEW_SCHOLARSHIP_STUDENTS, produces = "application/json")
    public ResponseEntity<List<MEScholarship>> viewScholarshipStudents(@PathVariable("year") int year)
    {
        return new ResponseEntity<List<MEScholarship>>(meScholarshipService.viewScholarshipStudents(year), HttpStatus.OK);
    }

    @ApiOperation(value = "Cancel scholarship", response = String.class, httpMethod = "DELETE", produces = "application/json")
    @DeleteMapping(path = RestAPI.CANCEL_SCHOLARSHIP, produces = "application/json")
    public ResponseEntity<String> cancelScholarship(@RequestBody List<MEScholarship> scholarshipStudents)
    {
        return new ResponseEntity<String>(meScholarshipService.cancelScholarship(scholarshipStudents), HttpStatus.OK);
    }
}
