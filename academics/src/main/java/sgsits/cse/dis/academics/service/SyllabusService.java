package sgsits.cse.dis.academics.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.response.ResponseMessage;

import java.io.IOException;


public interface SyllabusService {
        ResponseEntity<ResponseMessage> uploadFile(MultipartFile file, String authorization) throws IOException;
}
