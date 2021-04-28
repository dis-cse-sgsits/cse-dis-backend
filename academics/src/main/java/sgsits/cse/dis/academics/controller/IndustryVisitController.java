package sgsits.cse.dis.academics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.FileInfo;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.request.EditIndustryVisitForm;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.FileStorageService;
import sgsits.cse.dis.academics.service.IndustryVisitService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/industryVisit")
@Api(value = "Industry Visit")
public class IndustryVisitController {

    @Autowired
    private IndustryVisitService industryVisitService;

    @Autowired
    FileStorageService fileStorageService;

    private JwtResolver jwtResolver = new JwtResolver();

    @ApiOperation(value = "Add industry visit", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.ADD_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<?> addIndustryVisit(HttpServletRequest request, @RequestBody IndustryVisitForm industryVisitForm)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.addIndustryVisit(industryVisitForm)),HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Get industry visits by status", response = IndustryVisitResponse.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.GET_INDUSTRY_VISITS, produces = "application/json")
    public ResponseEntity<?> getIndustryVisits(HttpServletRequest request, @PathVariable("status") String status)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<IndustryVisitResponse>>(industryVisitService.getIndustryVisits(status), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "View industry visit details", response = IndustryVisit.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path =  RestAPI.VIEW_INDUSTRY_VISIT_DETAILS, produces = "application/json")
    public ResponseEntity<?> viewIndustryVisitDetails(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<IndustryVisit>(industryVisitService.viewIndustryVisitDetails(industryVisitId), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Search industry visits", response = IndustryVisitResponse.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = RestAPI.SEARCH_INDUSTRY_VISITS, produces = "application/json")
    public ResponseEntity<?> searchIndustryVisits(HttpServletRequest request, @RequestParam(value = "status") String status, @RequestParam(value = "keyword") String keyword)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<List<IndustryVisitResponse>>(industryVisitService.searchIndustryVisits(status, keyword), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Update industry visit status", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.UPDATE_INDUSTRY_VISIT_STATUS, produces = "application/json")
    public ResponseEntity<?> updateIndustryVisitStatus(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId, @RequestParam("file")MultipartFile file)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
        {
            try {
                return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.updateIndustryVisitStatus(industryVisitId, file)), HttpStatus.OK);
            }
            catch (Exception e)
            {
                return new ResponseEntity<ResponseMessage>(new ResponseMessage("Could not upload file; file invalid or size too large. Please try again."), HttpStatus.EXPECTATION_FAILED);
            }
        }
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Edit industry visit", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(path = RestAPI.EDIT_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<?> editIndustryVisit(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId, @RequestBody EditIndustryVisitForm editIndustryVisitForm)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.editIndustryVisit(industryVisitId, editIndustryVisitForm)), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Delete industry visit", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
    @DeleteMapping(path = RestAPI.DELETE_INDUSTRY_VISIT, produces = "application/json")
    public ResponseEntity<?> deleteIndustryVisit(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.deleteIndustryVisit(industryVisitId)), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Download notesheet", response = Resource.class, httpMethod = "GET")
    @GetMapping(path = "/downloadNotesheet/{industryVisitId}")
    public ResponseEntity<?> downloadNotesheet(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
        {
            IndustryVisit industryVisit = industryVisitService.downloadNotesheet(industryVisitId);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(industryVisit.getNotesheetFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Note-sheet_"+"Industry-Visit_"+industryVisit.getCompanyName()+"_"+industryVisit.getDate()+"."+industryVisit.getNotesheetExtension()+"\"")
                    .body(new ByteArrayResource(industryVisit.getNotesheet()));
        }
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Download attendance", response = Resource.class, httpMethod = "GET")
    @GetMapping(path = "/downloadAttendance/{industryVisitId}")
    public ResponseEntity<?> downloadAttendance(HttpServletRequest request, @PathVariable("industryVisitId") String industryVisitId)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
        {
            IndustryVisit industryVisit = industryVisitService.downloadAttendance(industryVisitId);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(industryVisit.getAttendanceFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Attendance_"+"Industry-Visit_"+industryVisit.getCompanyName()+"_"+industryVisit.getDate()+"."+industryVisit.getAttendanceExtension()+"\"")
                    .body(new ByteArrayResource(industryVisit.getAttendance()));
        }
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Update remarks", response = ResponseMessage.class, httpMethod = "PUT")
    @PutMapping(path = RestAPI.UPDATE_REMARKS, produces = "application/json")
    public ResponseEntity<?> updateRemarks(HttpServletRequest request,
                                                         @PathVariable("industryVisitId") String industryVisitId,
                                                         @RequestParam(value = "remarks") String remarks)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(industryVisitService.updateRemarks(industryVisitId, remarks)), HttpStatus.OK);
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = RestAPI.UPLOAD_IMAGES)
    public ResponseEntity<?> uploadImages(HttpServletRequest request, @PathVariable("id") String industryVisitId, @RequestParam("photos") MultipartFile[] photos)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
        {
            String message = "";
            int size = photos.length;
            try {
                Arrays.asList(photos).stream().forEach(photo -> {
                    fileStorageService.saveIndustryVisit(industryVisitId, photo, size);
                });

                message = "Uploaded the photos successfully.";
                return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.OK);
            }
            catch (Exception e)
            {
                message = "Failed to upload photos.";
                return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.EXPECTATION_FAILED);
            }
        }
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = RestAPI.IMAGES)
    public ResponseEntity<?> getListFiles(HttpServletRequest request, @RequestParam(value = "industry_visit_id") String industryVisitId)
    {
        if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
        {
            List<FileInfo> fileInfos = fileStorageService.loadAll().map(path -> {
                String filename = path.getFileName().toString();
                String url = MvcUriComponentsBuilder
                        .fromMethodName(IndustryVisitController.class, "getFile", path.getFileName().toString()).build().toString();

                return new FileInfo(filename, url);
            }).collect(Collectors.toList());

            fileInfos = fileStorageService.filterImagesIndustryVisit(industryVisitId, fileInfos);

            return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
        }
        else
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
