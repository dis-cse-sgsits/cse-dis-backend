package sgsits.cse.dis.academics.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import sgsits.cse.dis.academics.model.FileInfo;
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
import sgsits.cse.dis.academics.service.FileStorageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/expertLecture")
@Api(value = "Expert Lecture")
public class ExpertLectureController {
	
	@Autowired
	private ExpertLectureService expertLectureService;

	@Autowired
	private ExpertLectureRepository expertLectureRepository;

	@Autowired
	FileStorageService fileStorageService;
	
	@ApiOperation(value = "Add expert", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_EXPERT, produces = "application/json")
	public ResponseEntity<ResponseMessage> addExpert(@RequestBody ExpertForm addExpertForm)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.addExpert(addExpertForm)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find expert", response = ExpertDetails.class, httpMethod = "GET", produces = "Application/json")
	@GetMapping(path = RestAPI.FIND_EXPERT, produces = "Application/json")
	public ResponseEntity<ExpertDetails> findExpert(@RequestParam(value = "expertName", required = true) String name, @RequestParam(value = "expertDesignation", required = true) String designation)
	{
		return new ResponseEntity<ExpertDetails>(expertLectureService.findExpert(name, designation), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Edit expert", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_EXPERT, produces = "application/json")
	public ResponseEntity<ResponseMessage> editExpert(@RequestBody ExpertForm editExpertForm)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.editExpert(editExpertForm)), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Experts' Names and Designations", response = ExpertNamesAndDesignationsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_EXPERT_NAMES_AND_DESIGNATIONS, produces = "application/json")
	public ResponseEntity<List<ExpertNamesAndDesignationsResponse>> getExpertNamesAndDesignations()
	{
		return new ResponseEntity<List<ExpertNamesAndDesignationsResponse>> (expertLectureService.getExpertNamesAndDesignations(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Add Expert Lecture", response=ResponseMessage.class, httpMethod="POST", produces="application/json")
	@PostMapping(path=RestAPI.ADD_EXPERT_LECTURE, produces="application/json")
	public ResponseEntity<ResponseMessage> addExpertLecture(@RequestBody AddExpertLectureForm addExpertLectureForm)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.addExpertLecture(addExpertLectureForm)), HttpStatus.OK);
	}

	@ApiOperation(value = "Edit Expert Lecture", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_EXPERT_LECTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> editExpertLecture(@PathVariable("expertLectureId") String expertLectureId, @RequestBody EditExpertLectureForm editExpertLectureForm)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.editExpertLecture(expertLectureId, editExpertLectureForm)), HttpStatus.OK);
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
	
	@ApiOperation(value = "Update expert lecture status", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.UPDATE_EXPERT_LECTURE_STATUS, produces = "application/json")
	public ResponseEntity<ResponseMessage> updateExpertLectureStatus(@PathVariable("expertLectureId") String expertLectureId, @RequestParam("file") MultipartFile file)
	{
		try
		{
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.updateExpertLectureStatus(expertLectureId, file)), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Could not upload file; file invalid or size too large. Please try again."), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ApiOperation(value = "Delete Expert", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_EXPERT, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteExpert(@PathVariable("expertId") String expertId)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.deleteExpert(expertId)), HttpStatus.OK);
	}

//	@ApiOperation(value = "Edit expert lecture", response = String.class, httpMethod = "PUT", produces = "application/json")
//	@PutMapping(path = RestAPI.EDIT_EXPERT_LECTURE, produces = "application/json")
//	public ResponseEntity<String> editExpertLecture(@RequestBody ExpertLectureDetails expertLectureDetails)
//	{
//		return new ResponseEntity<String>(expertLectureService.editExpertLecture(expertLectureDetails), HttpStatus.OK);
//	}

	@ApiOperation(value = "Delete expert lecture", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_EXPERT_LECTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteExpertLecture(@PathVariable("expertLectureId") String expertLectureId)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.deleteExpertLecture(expertLectureId)), HttpStatus.OK);
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

	@ApiOperation(value = "Update payment status and remarks", response = ResponseMessage.class, httpMethod = "PUT")
	@PutMapping(path = RestAPI.UPDATE_PAYMENT_STATUS_AND_REMARKS, produces = "application/json")
	public ResponseEntity<ResponseMessage> updatePaymentStatusAndRemarks(@PathVariable("expertLectureId") String expertLectureId,
																@RequestParam(value = "payment_status") String paymentStatus,
																@RequestParam(value = "remarks") String remarks)
	{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(expertLectureService.updatePaymentStatusAndRemarks(expertLectureId, paymentStatus, remarks)), HttpStatus.OK);
	}

	@PostMapping(path = RestAPI.UPLOAD_IMAGES)
	public ResponseEntity<ResponseMessage> uploadImages(@PathVariable("id") String expertLectureId, @RequestParam("photos") MultipartFile[] photos)
	{
		String message = "";
		int size = photos.length;
		try {

			Arrays.asList(photos).stream().forEach(photo -> {
				fileStorageService.saveExpertLecture(expertLectureId, photo, size);
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

	@GetMapping(path = RestAPI.IMAGES)
	public ResponseEntity<List<FileInfo>> getListFiles(@RequestParam(value = "expert_lecture_id") String expertLectureId)
	{
		List<FileInfo> fileInfos = fileStorageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(ExpertLectureController.class, "getFile", path.getFileName().toString()).build().toString();

			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		fileInfos = fileStorageService.filterImagesExpertLecture(expertLectureId, fileInfos);

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/images/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = fileStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
