package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuestionAnswers;

@Repository
public interface MoodleQuestionAnswersRepo extends JpaRepository<MoodleQuestionAnswers, Long> {
	public List<MoodleQuestionAnswers> findAllByQuestion(Long questionId);
}
