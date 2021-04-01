package sgsits.cse.dis.academics.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.response.ResponseMessage;


public interface SchemeServices {
	List<String> getAllSubjectAcronym();
	List<String> getSubjectCodesByYearAndSemesterAndCourse(String year,String sem,String courseId);
	ResponseEntity<ResponseMessage> uploadFile(MultipartFile file, String authorization) throws IOException;

}
