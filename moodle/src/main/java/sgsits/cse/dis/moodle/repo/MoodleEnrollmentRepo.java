package sgsits.cse.dis.moodle.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleEnrollement;

@Repository
public interface  MoodleEnrollmentRepo  extends JpaRepository<MoodleEnrollement, Long>{
	public Optional<MoodleEnrollement> findById(Long id);
	public List<MoodleEnrollement> findByid(Long id);
	List<MoodleEnrollement> findByCourseid(Long courseid);
	
}
