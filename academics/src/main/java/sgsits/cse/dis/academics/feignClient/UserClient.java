package sgsits.cse.dis.academics.feignClient;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sgsits.cse.dis.academics.response.FacultyData;
import sgsits.cse.dis.academics.response.StudentProfile;


/**
 * <h1><b>AcademicsClient</b> interface.</h1>
 * <p>This interface contains reference to controller "userFeignClientController" to 
 * ensure communication with <b>user</b> microservice.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */

@FeignClient(name = "user")
public interface UserClient {

	@GetMapping(value = "/userFeignClientController/existsByUsername/{username}")
	public boolean existsByUsername(@PathVariable String username);
	
	@ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/getFacultyNameList", produces = "application/json")
	List<FacultyData> getFacultyNameList();

	@ApiOperation(value = "Fetch ME students by year", response = StudentProfile.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/fetchMEStudentsByYear/{year}")
	public List<StudentProfile> fetchMEStudentsByYear(@PathVariable("year") int year);
}
