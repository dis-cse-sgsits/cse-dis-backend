package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SyllabusService;

import java.io.File;
import java.io.IOException;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Override
    public ResponseEntity<ResponseMessage> uploadFile(MultipartFile file, String authorization) throws IOException {

        file.transferTo(new File("F:\\hackJOURNEY\\TestUploads\\"+file.getOriginalFilename()));

        String message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }
}
