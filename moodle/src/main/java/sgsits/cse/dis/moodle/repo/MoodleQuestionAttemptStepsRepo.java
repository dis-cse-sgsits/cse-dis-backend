package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuestionAttemptSteps;

@Repository
public interface MoodleQuestionAttemptStepsRepo extends JpaRepository<MoodleQuestionAttemptSteps, Long> {
	public List<MoodleQuestionAttemptSteps> findAllByUseridAndQuestionattemptidOrderBySequencenumberDesc(Long userId, Long questionAttemptId);

}
