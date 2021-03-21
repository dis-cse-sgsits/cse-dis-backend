package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleEnrollement;

@Repository
public interface  MoodleEnrollmentRepo  extends JpaRepository<MoodleEnrollement, Long>{
  public List<MoodleEnrollement> findAllById(Long id);


}
