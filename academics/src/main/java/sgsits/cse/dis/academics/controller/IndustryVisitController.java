package sgsits.cse.dis.academics.controller;

import java.util.List;

import com.netflix.ribbon.proxy.annotation.Http;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;
import sgsits.cse.dis.academics.service.IndustryVisitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/industryVisit")
@Api(value = "Industry Visit")
public class IndustryVisitController {

    @Autowired
    private IndustryVisitService industryVisitService;

    @ApiOperation(value = "Add industry visit", response = String.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.ADD_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<String> addIndustryVisit(@RequestBody IndustryVisitForm industryVisitForm)
    {
        return new ResponseEntity<String>(industryVisitService.addIndustryVisit(industryVisitForm),HttpStatus.OK);
    }

    @ApiOperation(value = "Get industry visits by status", response = IndustryVisitResponse.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.GET_INDUSTRY_VISITS, produces = "application/json")
    public ResponseEntity<List<IndustryVisitResponse>> getIndustryVisits(@PathVariable("status") String status)
    {
        return new ResponseEntity<List<IndustryVisitResponse>>(industryVisitService.getIndustryVisits(status), HttpStatus.OK);
    }

    @ApiOperation(value = "View industry visit details", response = IndustryVisit.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path =  RestAPI.VIEW_INDUSTRY_VISIT_DETAILS, produces = "application/json")
    public ResponseEntity<IndustryVisit> viewIndustryVisitDetails(@PathVariable("industryVisitId") String industryVisitId)
    {
        return new ResponseEntity<IndustryVisit>(industryVisitService.viewIndustryVisitDetails(industryVisitId), HttpStatus.OK);
    }

    @ApiOperation(value = "Search industry visits", response = IndustryVisitResponse.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.SEARCH_INDUSTRY_VISITS, produces = "application/json")
    public ResponseEntity<List<IndustryVisitResponse>> searchIndustryVisits(@RequestParam(value = "status") String status, @RequestParam(value = "keyword") String keyword)
    {
        return new ResponseEntity<List<IndustryVisitResponse>>(industryVisitService.searchIndustryVisits(status, keyword), HttpStatus.OK);
    }

    @ApiOperation(value = "Update industry visit status", response = String.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.UPDATE_INDUSTRY_VISIT_STATUS, produces = "application/json")
    public ResponseEntity<String> updateIndustryVisitStatus(@PathVariable("industryVisitId") String industryVisitId)
    {
        return new ResponseEntity<String>(industryVisitService.updateIndustryVisitStatus(industryVisitId), HttpStatus.OK);
    }

    @ApiOperation(value = "Edit industry visit", response = String.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.EDIT_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<String> editIndustryVisit(@RequestBody IndustryVisit industryVisit)
    {
        return new ResponseEntity<String>(industryVisitService.editIndustryVisit(industryVisit), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete industry visit", response = String.class, httpMethod = "DELETE", produces = "application/json")
    @DeleteMapping(path = RestAPI.DELETE_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<String> deleteIndustryVisit(@PathVariable("industryVisitId") String industryVisitId)
    {
        return new ResponseEntity<String>(industryVisitService.deleteIndustryVisit(industryVisitId), HttpStatus.OK);
    }
}
