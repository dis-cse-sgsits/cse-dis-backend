package sgsits.cse.dis.user.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.components.StudentProfileRepo;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.utility.ExcelHelper;
import sgsits.cse.dis.user.mappers.StudentServiceMapper;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.service.StudentService;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentProfileRepo studentProfileRepo;

    private final StudentServiceMapper studentServiceMapper =
            Mappers.getMapper(StudentServiceMapper.class);


    public StudentServiceImpl(final StudentProfileRepo studentProfileRepo) {
        this.studentProfileRepo = studentProfileRepo;
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
        studentProfileRepo.addOrUpdateStudentProfile(studentProfile);
    }

    public void saveExcelData(MultipartFile file, String addedBy, int sheetNo) {
        try {
            List<StudentProfile> students = ExcelHelper.excelToStudents(file.getInputStream(), addedBy, sheetNo);
            studentProfileRepo.saveAll(students);
        } catch (IOException | InternalServerError e) {
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

}
