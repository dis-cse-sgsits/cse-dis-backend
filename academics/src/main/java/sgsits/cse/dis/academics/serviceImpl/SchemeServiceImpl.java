package sgsits.cse.dis.academics.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.repo.SchemeRepository;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.CoursesService;
import sgsits.cse.dis.academics.service.SchemeServices;

@Component
public class SchemeServiceImpl implements SchemeServices {
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Autowired
	private CoursesService coursesService;
	
	@Override
	public List<String> getAllSubjectAcronym() {
		List<String> subjectAcronymList;
		subjectAcronymList = schemeRepository.findDistinctSubjectAcronym();
		return subjectAcronymList;
	}

	@Override
	public List<String> getSubjectCodesByYearAndSemesterAndCourse(String year, String sem,String course) {
		return schemeRepository.findByYearAndSemesterAndCourseId(year, sem, coursesService.getCourseIdByName(course))
				.stream()
				.map(scheme -> scheme.getSubjectCode())
				.sorted()
				.collect(Collectors.toList());
		
	}

	@Override
	public ResponseEntity<ResponseMessage> uploadFile(MultipartFile file, String authorization) throws IOException {
		file.transferTo(new File("F:\\hackJOURNEY\\TestUploads\\"+file.getOriginalFilename()));
		String message = "Uploaded the file successfully: " + file.getOriginalFilename();
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	}

}
