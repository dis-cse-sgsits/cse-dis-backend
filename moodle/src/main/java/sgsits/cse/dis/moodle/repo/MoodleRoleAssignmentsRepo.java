package sgsits.cse.dis.moodle.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.moodle.model.MoodleRoleAssignments;

public interface MoodleRoleAssignmentsRepo extends JpaRepository<MoodleRoleAssignments, Long> {
	List<MoodleRoleAssignments> findByUserid(Long userid);

	Optional<MoodleRoleAssignments> findByContextidAndUserid(Long contextid, Long userid);
	
}
