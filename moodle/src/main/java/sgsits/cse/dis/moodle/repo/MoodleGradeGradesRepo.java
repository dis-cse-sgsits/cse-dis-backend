package sgsits.cse.dis.moodle.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleGradeGrades;

@Repository
public interface MoodleGradeGradesRepo extends JpaRepository<MoodleGradeGrades, Long> {
	
	List<MoodleGradeGrades> findByItemid(Long itemId);
	Optional<MoodleGradeGrades> findByItemidAndUserid(Long itemId, Long userId);

}
