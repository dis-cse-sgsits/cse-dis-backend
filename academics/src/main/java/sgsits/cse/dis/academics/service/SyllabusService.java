package sgsits.cse.dis.academics.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.SyllabusFile;
import sgsits.cse.dis.academics.request.SchemeFileForm;
import sgsits.cse.dis.academics.request.SyllabusFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface SyllabusService {
        ResponseEntity<ResponseMessage> uploadFile(SyllabusFileForm schemeFileForm, MultipartFile file) throws IOException;

        SyllabusFile getFile(String fileId);

        ResponseEntity<ResponseMessage> delete(String fileId) throws FileNotFoundException;
}
