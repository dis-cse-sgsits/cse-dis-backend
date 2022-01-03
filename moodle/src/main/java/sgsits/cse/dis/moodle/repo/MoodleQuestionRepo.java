package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuestion;

@Repository
public interface MoodleQuestionRepo extends JpaRepository<MoodleQuestion, Long> {
	public MoodleQuestion findAllById(Long questionId);
}
