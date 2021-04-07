package sgsits.cse.dis.academics.service;

import java.util.List;

import sgsits.cse.dis.academics.model.MEScholarship;
import sgsits.cse.dis.academics.response.MEScholarshipStudents;

public interface MEScholarshipService {

    List<MEScholarshipStudents> fetchMEStudentsWithoutScholarship(int year);

    String approveStudents(List<MEScholarshipStudents> students);

    List<MEScholarship> fetchMEStudentsWithScholarship(int year);

    String cancelScholarship(List<String> scholarshipStudentsEnrollments);

    List<MEScholarshipStudents> searchStudentsWithoutScholarship(int year, String name);

    List<MEScholarship> searchStudentsWithScholarship(int year, String name);
}
