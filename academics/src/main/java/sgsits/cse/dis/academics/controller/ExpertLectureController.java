package sgsits.cse.dis.academics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	public ResponseEntity<List<ExpertLecturesResponse>> searchExpertLectures(@PathVariable("keyword") String keyword)
	{
		return new ResponseEntity<List<ExpertLecturesResponse>>(expertLectureService.searchExpertLectures(keyword), HttpStatus.OK); 
	}
	
	@ApiOperation(value = "Update expert lecture status", response = String.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.UPDATE_EXPERT_LECTURE_STATUS, produces = "application/json")
	public ResponseEntity<String> updateExpertLectureStatus(@PathVariable("expertLectureId") String expertLectureId)
	{
		return new ResponseEntity<String>(expertLectureService.updateExpertLectureStatus(expertLectureId), HttpStatus.OK);
	}
}
