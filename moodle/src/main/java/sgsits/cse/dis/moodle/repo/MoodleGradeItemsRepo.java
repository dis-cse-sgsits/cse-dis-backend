package sgsits.cse.dis.moodle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleGradeItems;

@Repository
public interface MoodleGradeItemsRepo extends JpaRepository<MoodleGradeItems, Long> {

}
