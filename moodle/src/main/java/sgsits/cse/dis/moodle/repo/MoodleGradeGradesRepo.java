package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleGradeGrades;

@Repository
public interface MoodleGradeGradesRepo extends JpaRepository<MoodleGradeGrades, Long> {

}
