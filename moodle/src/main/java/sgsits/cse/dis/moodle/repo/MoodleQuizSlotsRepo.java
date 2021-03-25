package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleQuizSlots;

@Repository
public interface MoodleQuizSlotsRepo extends JpaRepository<MoodleQuizSlots, Long> {
	public List<MoodleQuizSlots> findAllByQuizid(Long quizId);

}
