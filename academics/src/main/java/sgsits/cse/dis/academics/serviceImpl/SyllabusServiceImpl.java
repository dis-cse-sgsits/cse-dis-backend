package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.exception.FileStorageException;
import sgsits.cse.dis.academics.exception.MyFileNotFoundException;
import sgsits.cse.dis.academics.model.SchemeFile;
import sgsits.cse.dis.academics.model.SyllabusFile;
import sgsits.cse.dis.academics.repo.SyllabusFileRepository;
import sgsits.cse.dis.academics.request.SyllabusFileForm;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SyllabusService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    private SyllabusFileRepository syllabusFileRepository;

    @Override
    public ResponseEntity<ResponseMessage> uploadFile(SyllabusFileForm syllabusFileForm, MultipartFile file) throws IOException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            SyllabusFile syllabusFile = new SyllabusFile(fileName, file.getContentType(),syllabusFileForm.getCourse(), syllabusFileForm.getSemester(), file.getBytes());
            syllabusFileRepository.save(syllabusFile);
            String message = "Uploaded the file successfully: " + fileName;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
// Upload file to folder:
//		file.transferTo(new File("F:\\hackJOURNEY\\TestUploads\\"+file.getOriginalFilename()));
    }

    @Override
    public SyllabusFile getFile(String fileName) {
        return (SyllabusFile) syllabusFileRepository.findByfileName(fileName)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileName));
    }

    @Override
    public ResponseEntity<ResponseMessage> delete(String fileName) throws FileNotFoundException {
        Optional<Object> syllabusFile = syllabusFileRepository.findByfileName(fileName);

        if(syllabusFile.isPresent()){
            syllabusFileRepository.delete((SyllabusFile) syllabusFile.get());
            String message = "The file is deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        else{
            throw new FileNotFoundException("File not found with id " + fileName);
        }
    }

    @Override
    public List<SyllabusFile> getAllSchemes() {
        return syllabusFileRepository.findAll();
    }
}
