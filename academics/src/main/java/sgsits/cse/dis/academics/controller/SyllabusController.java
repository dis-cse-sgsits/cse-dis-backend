package sgsits.cse.dis.academics.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.SchemeFile;
import sgsits.cse.dis.academics.model.SyllabusFile;
import sgsits.cse.dis.academics.request.SchemeFileForm;
import sgsits.cse.dis.academics.request.SyllabusFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SchemeServices;
import sgsits.cse.dis.academics.service.SyllabusService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Api(value = "Syllabus Controller")
@RestController
@RequestMapping(path = "/syllabus")
public class SyllabusController {

    private JwtResolver jwtResolver = new JwtResolver();
    @Autowired
    SyllabusService syllabusService;

    @ApiOperation(value = "Upload Syllabus", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.UPLOAD, produces = "application/json")
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestPart("course") String course,
            @RequestPart("semester") String semester,
            @RequestPart("file") MultipartFile file,
            HttpServletRequest request)
            throws IOException {
        SyllabusFileForm syllabusFileForm = new SyllabusFileForm(course, semester);
        return syllabusService.uploadFile(syllabusFileForm,file);
    }

    @ApiOperation(value = "Download Syllabus", response = ResponseMessage.class, httpMethod = "POST")
    @GetMapping(path = RestAPI.DOWNLOAD+"/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId){
        SyllabusFile dbFile = syllabusService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @ApiOperation(value = "Delete Syllabus", response = ResponseMessage.class, httpMethod = "DELETE")
    @DeleteMapping(path ="/{fileId}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String fileId) throws FileNotFoundException {
        return syllabusService.delete(fileId);
    }
}
