package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAssignGrades;

@Repository
public interface MoodleAssignGradesRepo extends JpaRepository<MoodleAssignGrades, Long> {

}
