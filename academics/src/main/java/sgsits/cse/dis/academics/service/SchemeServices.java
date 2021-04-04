package sgsits.cse.dis.academics.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.model.SchemeFile;
import sgsits.cse.dis.academics.request.SchemeFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;


public interface SchemeServices {
	List<String> getAllSubjectAcronym();
	List<String> getSubjectCodesByYearAndSemesterAndCourse(String year,String sem,String courseId);
	ResponseEntity<ResponseMessage> uploadFile(SchemeFileForm schemeFileForm,MultipartFile file) throws IOException;

	SchemeFile getFile(String fileId);

	ResponseEntity<ResponseMessage> delete(String fileId) throws FileNotFoundException;
}
