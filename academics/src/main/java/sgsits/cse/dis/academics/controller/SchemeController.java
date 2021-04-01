package sgsits.cse.dis.academics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SchemeServices;
import sgsits.cse.dis.academics.service.SyllabusService;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        return schemeServices.uploadFile(file,jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")));
    }
}
