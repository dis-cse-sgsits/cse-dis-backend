package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuestionAttempts;

@Repository
public interface MoodleQuestionAttemptsRepo extends JpaRepository<MoodleQuestionAttempts, Long> {
	public MoodleQuestionAttempts findAllByQuestionidAndQuestionusageid(Long questionId, Long questionUsageId);
}
