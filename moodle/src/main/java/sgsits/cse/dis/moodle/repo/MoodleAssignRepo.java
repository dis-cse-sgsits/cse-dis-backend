package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAssign;

@Repository
public interface MoodleAssignRepo extends JpaRepository<MoodleAssign, Long> {
	public List<MoodleAssign> findByCourse(Long courseid);

}
