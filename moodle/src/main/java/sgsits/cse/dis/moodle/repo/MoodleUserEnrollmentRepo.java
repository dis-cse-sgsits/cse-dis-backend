package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;

@Repository
public interface MoodleUserEnrollmentRepo extends JpaRepository<MoodleUserEnrollment, Long> {
      public List<MoodleUserEnrollment> findByUserid(Long id);
    
   
}
