package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.moodle.model.MoodleContext;

public interface MoodleContextRepo extends JpaRepository<MoodleContext, Long> {

	List<MoodleContext> findByInstanceid(Long instanceid);
	
}
