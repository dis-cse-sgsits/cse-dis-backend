package sgsits.cse.dis.academics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sgsits.cse.dis.academics.response.FileResponseMessage;

@ControllerAdvice
public class FileUploadException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<FileResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return new ResponseEntity<FileResponseMessage>(new FileResponseMessage("One or more files are too large."), HttpStatus.EXPECTATION_FAILED);
    }
}
