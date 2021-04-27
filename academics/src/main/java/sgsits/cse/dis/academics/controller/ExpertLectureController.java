package sgsits.cse.dis.academics.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.repo.ExpertLectureRepository;
import sgsits.cse.dis.academics.request.EditExpertLectureForm;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.ExpertLectureService;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.request.ExpertForm;
import sgsits.cse.dis.academics.request.AddExpertLectureForm;
import sgsits.cse.dis.academics.response.ExpertLecturesResponse;
import sgsits.cse.dis.academics.response.ExpertNamesAndDesignationsResponse;
import sgsits.cse.dis.academics.model.ExpertDetails;
import sgsits.cse.dis.academics.model.ExpertLectureDetails;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/expertLecture")
@Api(value = "Expert Lecture")
public class ExpertLectureController {
	
	@Autowired
	private ExpertLectureService expertLectureService;

	@Autowired
	private ExpertLectureRepository expertLectureRepository;
	
	@ApiOperation(value = "Add expert", response = String.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_EXPERT, produces = "application/json")
	public ResponseEntity<String> addExpert(@RequestBody ExpertForm addExpertForm)
	{
		return new ResponseEntity<String>(expertLectureService.addExpert(addExpertForm), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find expert", response = ExpertDetails.class, httpMethod = "GET", produces = "Application/json")
	@GetMapping(path = RestAPI.FIND_EXPERT, produces = "Application/json")
	public ResponseEntity<ExpertDetails> findExpert(@RequestParam(value = "expertName", required = true) String name, @RequestParam(value = "expertDesignation", required = true) String designation)
	{
		return new ResponseEntity<ExpertDetails>(expertLectureService.findExpert(name, designation), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Edit expert", response = String.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_EXPERT, produces = "application/json")
	public ResponseEntity<String> editExpert(@RequestBody ExpertForm editExpertForm)
	{
		return new ResponseEntity<String>(expertLectureService.editExpert(editExpertForm), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Experts' Names and Designations", response = ExpertNamesAndDesignationsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_EXPERT_NAMES_AND_DESIGNATIONS, produces = "application/json")
	public ResponseEntity<List<ExpertNamesAndDesignationsResponse>> getExpertNamesAndDesignations()
	{
		return new ResponseEntity<List<ExpertNamesAndDesignationsResponse>> (expertLectureService.getExpertNamesAndDesignations(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Add Expert Lecture", response=String.class, httpMethod="POST", produces="application/json")
	@PostMapping(path=RestAPI.ADD_EXPERT_LECTURE, produces="application/json")
	public ResponseEntity<String> addExpertLecture(@RequestBody AddExpertLectureForm addExpertLectureForm)
	{
		return new ResponseEntity<String>(expertLectureService.addExpertLecture(addExpertLectureForm), HttpStatus.OK);
	}

	@ApiOperation(value = "Edit Expert Lecture", response = String.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_EXPERT_LECTURE, produces = "application/json")
	public ResponseEntity<String> editExpertLecture(@PathVariable("expertLectureId") String expertLectureId, @RequestBody EditExpertLectureForm editExpertLectureForm)
	{
		return new ResponseEntity<String>(expertLectureService.editExpertLecture(expertLectureId, editExpertLectureForm), HttpStatus.OK);
	}

	@ApiOperation(value="Get Expert Lectures by status", response=ExpertLecturesResponse.class, httpMethod="GET", produces="application/json")
	@GetMapping(path=RestAPI.GET_EXPERT_LECTURES_BY_STATUS, produces="application/json")
	public ResponseEntity<List<ExpertLecturesResponse>> getExpertLecturesByStatus(@PathVariable("status") String status)
	{
		return new ResponseEntity<List<ExpertLecturesResponse>> (expertLectureService.getExpertLecturesByStatus(status), HttpStatus.OK);
	}
	
	@ApiOperation(value="View Expert Lecture Details", response=ExpertLectureDetails.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path=RestAPI.VIEW_EXPERT_LECTURE_DETAILS, produces="application/json")
	public ResponseEntity<ExpertLectureDetails> viewExpertLectureDetails(@PathVariable("expertLectureId") String expertLectureId)
	{
		return new ResponseEntity<ExpertLectureDetails>(expertLectureService.viewExpertLectureDetails(expertLectureId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search expert lectures", response = ExpertLecturesResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.SEARCH_EXPERT_LECTURES, produces = "application/json")
	public ResponseEntity<List<ExpertLecturesResponse>> searchExpertLectures(@RequestParam(value = "keyword", required = true) String keyword, @RequestParam(value = "status", required = true) String status)
	{
		return new ResponseEntity<List<ExpertLecturesResponse>>(expertLectureService.searchExpertLectures(keyword, status), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update expert lecture status", response = String.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.UPDATE_EXPERT_LECTURE_STATUS, produces = "application/json")
	public ResponseEntity<String> updateExpertLectureStatus(@PathVariable("expertLectureId") String expertLectureId, @RequestParam("file") MultipartFile file)
	{
		try
		{
			return new ResponseEntity<String>(expertLectureService.updateExpertLectureStatus(expertLectureId, file), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Could not upload file; file invalid or size too large. Please try again.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ApiOperation(value = "Delete Expert", response = String.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_EXPERT, produces = "application/json")
	public ResponseEntity<String> deleteExpert(@PathVariable("expertId") String expertId)
	{
		return new ResponseEntity<String>(expertLectureService.deleteExpert(expertId), HttpStatus.OK);
	}

//	@ApiOperation(value = "Edit expert lecture", response = String.class, httpMethod = "PUT", produces = "application/json")
//	@PutMapping(path = RestAPI.EDIT_EXPERT_LECTURE, produces = "application/json")
//	public ResponseEntity<String> editExpertLecture(@RequestBody ExpertLectureDetails expertLectureDetails)
//	{
//		return new ResponseEntity<String>(expertLectureService.editExpertLecture(expertLectureDetails), HttpStatus.OK);
//	}

	@ApiOperation(value = "Delete expert lecture", response = String.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_EXPERT_LECTURE, produces = "application/json")
	public ResponseEntity<String> deleteExpertLecture(@PathVariable("expertLectureId") String expertLectureId)
	{
		return new ResponseEntity<String>(expertLectureService.deleteExpertLecture(expertLectureId), HttpStatus.OK);
	}

	@ApiOperation(value = "Download notesheet", response = Resource.class, httpMethod = "GET", produces = "application/pdf")
	@GetMapping(path = "/downloadNotesheet/{expertLectureId}", produces = "application/pdf")
	public ResponseEntity<Resource> downloadNotesheet(@PathVariable("expertLectureId") String expertLectureId)
	{
		ExpertLectureDetails expertLectureDetails = expertLectureService.downloadNotesheet(expertLectureId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(expertLectureDetails.getNotesheetFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Note-sheet_"+"Expert-Lecture_"+expertLectureDetails.getTopic()+"_"+expertLectureDetails.getDate()+"."+expertLectureDetails.getNotesheetExtension()+"\"")
				.body(new ByteArrayResource(expertLectureDetails.getNotesheet()));
	}

	@ApiOperation(value = "Download attendance", response = Resource.class, httpMethod = "GET")
	@GetMapping(path = "/downloadAttendance/{expertLectureId}")
	public ResponseEntity<Resource> downloadAttendance(@PathVariable("expertLectureId") String expertLectureId)
	{
		ExpertLectureDetails expertLectureDetails = expertLectureService.downloadAttendance(expertLectureId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(expertLectureDetails.getAttendanceFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+"Attendance_"+"Expert-Lecture_"+expertLectureDetails.getTopic()+"_"+expertLectureDetails.getDate()+"."+expertLectureDetails.getAttendanceExtension()+"\"")
				.body(new ByteArrayResource(expertLectureDetails.getAttendance()));
	}

	@ApiOperation(value = "Update payment status and remarks", response = String.class, httpMethod = "PUT")
	@PutMapping(path = RestAPI.UPDATE_PAYMENT_STATUS_AND_REMARKS, produces = "application/json")
	public ResponseEntity<String> updatePaymentStatusAndRemarks(@PathVariable("expertLectureId") String expertLectureId,
																@RequestParam(value = "payment_status") String paymentStatus,
																@RequestParam(value = "remarks") String remarks)
	{
		return new ResponseEntity<String>(expertLectureService.updatePaymentStatusAndRemarks(expertLectureId, paymentStatus, remarks), HttpStatus.OK);
	}
}
