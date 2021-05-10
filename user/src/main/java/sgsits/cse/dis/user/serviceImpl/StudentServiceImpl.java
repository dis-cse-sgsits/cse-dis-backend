package sgsits.cse.dis.user.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.StudentProfileRepo;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.mappers.StudentServiceMapper;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.repo.StudentRepository;
import sgsits.cse.dis.user.service.StudentService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentProfileRepo studentProfileRepo;

    @Autowired
    private StudentRepository studentRepository;

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
    public void addOrUpdateStudentBasicProfile(final StudentBasicProfileDto studentBasicProfileDto)
            throws InternalServerError {

        studentProfileRepo.addOrUpdateStudentProfile(
                studentServiceMapper.convertStudentBasicProfileDtoIntoModel(studentBasicProfileDto));
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
    public List<StudentProfile> fetchMEStudentsByYear(int year) {
        List<StudentProfile> meStudents = studentRepository.findByCourseId("C2");
        System.out.println(meStudents);
        List<StudentProfile> output = new ArrayList<StudentProfile>();
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH);
        System.out.println("Year: "+year);
        System.out.println("Current Year: "+currentYear);
        System.out.println("Current Month: "+currentMonth);
        if(year==1)
        {
            System.out.println("Inside year I");
            for(StudentProfile record : meStudents)
            {
                int admissionYear = record.getAdmissionYear();
                System.out.println("Admission year: "+admissionYear);
                if(currentYear-admissionYear==0)
                {
                    record.setCategory("I");
                    output.add(record);
                }
                else
                if(currentYear-admissionYear==1)
                {
                    if(currentMonth<=4)
                    {
                        record.setCategory("I");
                        output.add(record);
                    }

                }
            }
        }
        else if(year==2)
        {
            for(StudentProfile record : meStudents)
            {
                int admissionYear = record.getAdmissionYear();
                System.out.println("Admission year: "+admissionYear);
                if(currentYear-admissionYear==1)
                {
                    if(currentMonth>4)
                    {
                        record.setCategory("II");
                        output.add(record);
                    }
                }
                else
                if(currentYear-admissionYear==2)
                {
                    if(currentMonth<=4)
                    {
                        record.setCategory("II");
                        output.add(record);
                    }
                }
            }
        }
        return output;
    }

}
