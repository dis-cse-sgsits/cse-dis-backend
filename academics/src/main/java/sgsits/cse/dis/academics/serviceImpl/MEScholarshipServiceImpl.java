package sgsits.cse.dis.academics.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.academics.feignClient.UserClient;
import sgsits.cse.dis.academics.model.MEScholarship;
import sgsits.cse.dis.academics.repo.MEScholarshipRepository;
import sgsits.cse.dis.academics.response.MEScholarshipStudents;
import sgsits.cse.dis.academics.response.StudentProfile;
import sgsits.cse.dis.academics.service.MEScholarshipService;

@Component
public class MEScholarshipServiceImpl implements MEScholarshipService{

    @Autowired
    private UserClient userClient;

    @Autowired
    private MEScholarshipRepository meScholarshipRepository;

    @Override
    public List<MEScholarshipStudents> fetchMEStudentsWithoutScholarship(int year) {
        List<MEScholarshipStudents> output = new ArrayList<MEScholarshipStudents>();
        List<StudentProfile> records = userClient.fetchMEStudentsByYear(year);
        for(StudentProfile record : records)
        {
            if(meScholarshipRepository.existsByEnrollment(record.getEnrollmentId()))
                continue;
                System.out.println("Inside exists");
                MEScholarshipStudents meStudent = new MEScholarshipStudents();
                meStudent.setName(record.getFullName());
                meStudent.setEmail(record.getEmail());
                meStudent.setEnrollment(record.getEnrollmentId());
                meStudent.setAttendance("100%");
                if (record.getCategory().equals("I")) {
                    meStudent.setYear("I");
                } else {
                    meStudent.setYear("II");
                }
                meStudent.setAdmissionYear(record.getAdmissionYear());
                meStudent.setStatus("Not approved");
                output.add(meStudent);
        }
        return output;
    }

    @Override
    public String approveStudents(List<MEScholarshipStudents> students) {
        for(MEScholarshipStudents student : students)
        {
            MEScholarship meScholarship = new MEScholarship();
            meScholarship.setName(student.getName());
            meScholarship.setEmail(student.getEmail());
            meScholarship.setEnrollment(student.getEnrollment());
            meScholarship.setAdmissionYear(student.getAdmissionYear());
            meScholarship.setYear((student.getYear().equals("I"))?1:2);
            MEScholarship test = meScholarshipRepository.save(meScholarship);
            if(test==null)
                return "Could not approve selected students, please try again.";
        }
        return "Selected students were approved for scholarship successfully.";

    }

    @Override
    public List<MEScholarship> fetchMEStudentsWithScholarship(int year) {
        List<MEScholarship> output = meScholarshipRepository.findByYear(year);
        return output;
    }

    @Override
    public String cancelScholarship(List<MEScholarship> scholarshipStudents) {
        for(MEScholarship student : scholarshipStudents)
        {
            meScholarshipRepository.delete(student);
        }
        return "Selected students' scholarship was revoked successfully.";
    }


}
