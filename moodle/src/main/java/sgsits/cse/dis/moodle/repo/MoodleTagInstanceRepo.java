package sgsits.cse.dis.moodle.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleTagInstance;

@Repository
public interface MoodleTagInstanceRepo extends JpaRepository<MoodleTagInstance, Long> {
	Optional<MoodleTagInstance> findAllByItemid(Long itemId);
}
