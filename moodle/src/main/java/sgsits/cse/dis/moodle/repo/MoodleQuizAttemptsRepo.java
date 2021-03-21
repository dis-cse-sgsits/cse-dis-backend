package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.moodle.model.MoodleQuizAttempts;

public interface MoodleQuizAttemptsRepo extends JpaRepository<MoodleQuizAttempts, Long> {

}
