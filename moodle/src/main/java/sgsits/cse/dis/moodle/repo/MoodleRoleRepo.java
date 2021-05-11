package sgsits.cse.dis.moodle.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.moodle.model.MoodleRole;

public interface MoodleRoleRepo extends JpaRepository<MoodleRole, Long> {
	Optional<MoodleRole> findById(Long id);
}
