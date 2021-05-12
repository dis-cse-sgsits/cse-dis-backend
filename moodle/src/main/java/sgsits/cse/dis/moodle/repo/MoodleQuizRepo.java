package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuiz;

@Repository
public interface MoodleQuizRepo extends JpaRepository<MoodleQuiz, Long> {
	public List<MoodleQuiz> findByCourse(Long courseid);
	
	public MoodleQuiz findAllById(Long quizId);
}
