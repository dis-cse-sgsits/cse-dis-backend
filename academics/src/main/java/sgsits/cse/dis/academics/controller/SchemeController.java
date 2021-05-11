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
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SchemeServices;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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



    @ApiOperation(value = "Download Scheme", response = ResponseMessage.class, httpMethod = "GET")
    @GetMapping(path = RestAPI.DOWNLOAD+"/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
        SchemeFile dbFile = schemeServices.getFile(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @ApiOperation(value = "Delete Scheme", response = ResponseMessage.class, httpMethod = "DELETE")
    @DeleteMapping(path ="/{fileName}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String fileName) throws FileNotFoundException {
        return schemeServices.delete(fileName);
    }



    @ApiOperation(value = "Get all Scheme info", response = ResponseMessage.class, httpMethod = "GET")
    @GetMapping
    public  ResponseEntity<List<SchemeFile>> getAllSchemes(){
        return new ResponseEntity<List<SchemeFile>>(schemeServices.getAllSchemes(), HttpStatus.OK);
    }

}
