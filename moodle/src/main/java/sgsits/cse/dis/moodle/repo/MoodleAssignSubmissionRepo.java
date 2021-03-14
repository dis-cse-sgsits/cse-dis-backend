package sgsits.cse.dis.moodle.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAssignSubmission;

@Repository
public interface MoodleAssignSubmissionRepo extends JpaRepository<MoodleAssignSubmission, Long> {
	Optional<List<MoodleAssignSubmission>> findByUseridAndAssignmentOrderByAttemptnumberDesc(Long userid, Long assignment);
}
