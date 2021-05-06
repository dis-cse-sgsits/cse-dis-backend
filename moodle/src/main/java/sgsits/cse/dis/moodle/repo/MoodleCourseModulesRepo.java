package sgsits.cse.dis.moodle.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleCourseModules;

@Repository
public interface MoodleCourseModulesRepo extends JpaRepository<MoodleCourseModules, Long> {
	Optional<MoodleCourseModules> findAllByInstanceAndCourse(Long instanceId, Long courseId);
}
