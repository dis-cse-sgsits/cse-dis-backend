package sgsits.cse.dis.moodle.repo;

import java.util.List;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAssign;

@Repository
public interface MoodleAssignRepo extends JpaRepository<MoodleAssign, Long> {


	Optional<List<MoodleAssign>> findByCourse(Long course);
	Optional<MoodleAssign> findAllById(Long id);

}
