package sgsits.cse.dis.user.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.components.StudentProfileRepo;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.mappers.StudentServiceMapper;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.EnrollmentTemplate;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.repo.EnrollmentTemplateRepository;
import sgsits.cse.dis.user.service.StudentService;
import sgsits.cse.dis.user.utility.ExcelHelper;
import sgsits.cse.dis.user.utility.UploadUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final UploadUtil uploadUtil;

    private final StudentProfileRepo studentProfileRepo;
    private final EnrollmentTemplateRepository enrollmentTemplateRepository;

    private final StudentServiceMapper studentServiceMapper =
            Mappers.getMapper(StudentServiceMapper.class);


    public StudentServiceImpl( UploadUtil uploadUtil, final StudentProfileRepo studentProfileRepo, EnrollmentTemplateRepository enrollmentTemplateRepository ) {
        this.uploadUtil = uploadUtil;
        this.studentProfileRepo = studentProfileRepo;
        this.enrollmentTemplateRepository = enrollmentTemplateRepository;
    }


    @Override
    public StudentBasicProfileDto getStudentBasicProfile(final String userId)
            throws InternalServerError {

        return studentServiceMapper.convertStudentBasicProfileModelIntoDto(
                studentProfileRepo.getStudentProfileUsingUserId(userId));
    }

    @Override
    public void addStudentBasicProfile(final StudentBasicProfileDto studentBasicProfileDto)
            throws InternalServerError {
        StudentProfile studentProfile = studentServiceMapper.convertStudentBasicProfileDtoIntoModel(studentBasicProfileDto);
        studentProfile.setSchemeYear(studentBasicProfileDto.getSchemeYear());
        studentProfile.setSchemeSemester(studentBasicProfileDto.getSchemeSemester());
        studentProfileRepo.addOrUpdateStudentProfile(studentProfile);
    }

    public void saveExcelData(MultipartFile file, String addedBy, int sheetNo) {
        try {
            System.out.println("Impl");
            List<StudentProfile> students = ExcelHelper.excelToStudents(file.getInputStream(), addedBy, sheetNo);
            studentProfileRepo.saveAll(students);
        } catch (IOException | InternalServerError e) {
            System.out.println(e);
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }


    @Override
    public List<PgProjectDetailDto> getPgProjectDetails(final String userId) {
        return null;
    }


    @Override
    public List<StudentAttendanceDto> getStudentAttendanceRecord(final String userId) {
        return null;
    }

    @Override
    public List<StudentLeaveDto> getStudentLeaveRecord(final String userId) {
        return null;
    }

    @Override
    public List<StudentPlacementDto> getStudentPlacementRecord(final String userId) {
        return null;
    }

    @Override
    public List<UgProjectDetailDto> geUgProjectDetails(final String userId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseMessage> uploadEnrollmentTemplate( EnrollmentTemplate schemeFileForm, MultipartFile file ) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            EnrollmentTemplate enrollmentTemplate = new EnrollmentTemplate(fileName, file.getContentType(), file.getBytes());
            enrollmentTemplateRepository.save(enrollmentTemplate);
            String message = "Uploaded the file successfully: " + fileName;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public EnrollmentTemplate getFile( String fileName ) {
        return (EnrollmentTemplate) enrollmentTemplateRepository.findByfileName(fileName)
                .orElseThrow(() -> new RuntimeException("File not found with name " + fileName));
    }

    @Override
    public ResponseEntity<ResponseMessage> deleteTemplate( String fileName ) {
        Optional<Object> schemeFile = enrollmentTemplateRepository.findByfileName(fileName);

        if(schemeFile.isPresent()){
            enrollmentTemplateRepository.delete((EnrollmentTemplate) schemeFile.get());
            String message = "The file is deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        else{
            throw new RuntimeException("File not found with file name " + fileName);
        }
    }

}
