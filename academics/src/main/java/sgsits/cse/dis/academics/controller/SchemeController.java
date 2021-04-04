package sgsits.cse.dis.academics.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.SchemeFile;
import sgsits.cse.dis.academics.request.SchemeFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SchemeServices;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Api(value = "Scheme Controller")
@RestController
@RequestMapping(path = "/scheme")
public class SchemeController {

    private JwtResolver jwtResolver = new JwtResolver();

    @Autowired
    SchemeServices schemeServices;

    @ApiOperation(value = "Upload Scheme", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(path = RestAPI.UPLOAD, produces = "application/json")
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestPart("course") String course,
            @RequestPart("semester") String semester,
            @RequestPart("file") MultipartFile file,
            HttpServletRequest request)
            throws IOException {
        SchemeFileForm schemeFileForm = new SchemeFileForm(course, semester);
        return schemeServices.uploadFile(schemeFileForm,file);
    }

    @ApiOperation(value = "Download Scheme", response = ResponseMessage.class, httpMethod = "POST")
    @GetMapping(path = RestAPI.DOWNLOAD+"/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId){
        SchemeFile dbFile = schemeServices.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @ApiOperation(value = "Delete Scheme", response = ResponseMessage.class, httpMethod = "DELETE")
    @DeleteMapping(path ="/{fileId}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String fileId) throws FileNotFoundException {
        return schemeServices.delete(fileId);
    }

}
