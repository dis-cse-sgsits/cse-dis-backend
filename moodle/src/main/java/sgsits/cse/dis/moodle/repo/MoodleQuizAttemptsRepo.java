package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuizAttempts;

@Repository
public interface MoodleQuizAttemptsRepo extends JpaRepository<MoodleQuizAttempts, Long> {
	public List<MoodleQuizAttempts> findAllByQuizAndUseridOrderByAttemptDesc(Long quizid, Long userid);

}
