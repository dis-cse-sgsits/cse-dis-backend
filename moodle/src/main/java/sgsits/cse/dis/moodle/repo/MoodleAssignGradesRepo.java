package sgsits.cse.dis.moodle.repo;


import java.util.List;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAssignGrades;

@Repository
public interface MoodleAssignGradesRepo extends JpaRepository<MoodleAssignGrades, Long> {

	public List<MoodleAssignGrades> findByAssignmentAndUserid(Long assignid, Long userid);
	
	public List<MoodleAssignGrades> findByAssignmentAndUseridOrderByAttemptnumberDesc(Long assignid, Long userid);

	Optional<MoodleAssignGrades> findByUseridAndAssignmentAndAttemptnumber(Long userid,Long assignment,Long attemptnumber);

}
