package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.academics.model.MEScholarship;
import sgsits.cse.dis.academics.response.MEScholarshipStudents;

import java.util.List;

public interface MEScholarshipRepository extends JpaRepository <MEScholarship, String> {


    List<MEScholarship> findByYear(int year);
}