package sgsits.cse.dis.academics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.request.EditIndustryVisitForm;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.FileStorageService;
import sgsits.cse.dis.academics.service.IndustryVisitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/industryVisit")
@Api(value = "Industry Visit")
public class IndustryVisitController {

    @Autowired
    private IndustryVisitService industryVisitService;

    @Autowired
    FileStorageService fileStorageService;

    @ApiOperation(value = "Add industry visit", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.ADD_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<ResponseMessage> addIndustryVisit(@RequestBody IndustryVisitForm industryVisitForm)
    {
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.addIndustryVisit(industryVisitForm)),HttpStatus.OK);
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

    @ApiOperation(value = "Update industry visit status", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.UPDATE_INDUSTRY_VISIT_STATUS, produces = "application/json")
    public ResponseEntity<ResponseMessage> updateIndustryVisitStatus(@PathVariable("industryVisitId") String industryVisitId, @RequestParam("file")MultipartFile file)
    {
        try {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.updateIndustryVisitStatus(industryVisitId, file)), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Could not upload file; file invalid or size too large. Please try again."), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @ApiOperation(value = "Edit industry visit", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.EDIT_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<ResponseMessage> editIndustryVisit(@PathVariable("industryVisitId") String industryVisitId, @RequestBody EditIndustryVisitForm editIndustryVisitForm)
    {
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.editIndustryVisit(industryVisitId, editIndustryVisitForm)), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete industry visit", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
    @DeleteMapping(path = RestAPI.DELETE_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<ResponseMessage> deleteIndustryVisit(@PathVariable("industryVisitId") String industryVisitId)
    {
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.deleteIndustryVisit(industryVisitId)), HttpStatus.OK);
    }

    @ApiOperation(value = "Download notesheet", response = Resource.class, httpMethod = "GET")
    @GetMapping(path = "/downloadNotesheet/{industryVisitId}")
    public ResponseEntity<Resource> downloadNotesheet(@PathVariable("industryVisitId") String industryVisitId)
    {
        IndustryVisit industryVisit = industryVisitService.downloadNotesheet(industryVisitId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(industryVisit.getNotesheetFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Note-sheet_"+"Industry-Visit_"+industryVisit.getCompanyName()+"_"+industryVisit.getDate()+"."+industryVisit.getNotesheetExtension()+"\"")
                .body(new ByteArrayResource(industryVisit.getNotesheet()));
    }

    @ApiOperation(value = "Download attendance", response = Resource.class, httpMethod = "GET")
    @GetMapping(path = "/downloadAttendance/{industryVisitId}")
    public ResponseEntity<Resource> downloadAttendance(@PathVariable("industryVisitId") String industryVisitId)
    {
        IndustryVisit industryVisit = industryVisitService.downloadAttendance(industryVisitId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(industryVisit.getAttendanceFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Attendance_"+"Industry-Visit_"+industryVisit.getCompanyName()+"_"+industryVisit.getDate()+"."+industryVisit.getAttendanceExtension()+"\"")
                .body(new ByteArrayResource(industryVisit.getAttendance()));
    }

    @ApiOperation(value = "Update remarks", response = ResponseMessage.class, httpMethod = "PUT")
    @PutMapping(path = RestAPI.UPDATE_REMARKS, produces = "application/json")
    public ResponseEntity<ResponseMessage> updateRemarks(@PathVariable("industryVisitId") String industryVisitId,
                                                                @RequestParam(value = "remarks") String remarks)
    {
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.updateRemarks(industryVisitId, remarks)), HttpStatus.OK);
    }

    @PostMapping(path = RestAPI.UPLOAD_IMAGES)
    public ResponseEntity<ResponseMessage> uploadImages(@RequestParam("photos") MultipartFile[] photos)
    {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(photos).stream().forEach(photo -> {
                fileStorageService.save(photo);
                fileNames.add(photo.getOriginalFilename());
            });

            message = "Upload the images successfully: "+ fileNames;
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.OK);
        }
        catch (Exception e)
        {
            message = "Failed to upload photos.";
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
