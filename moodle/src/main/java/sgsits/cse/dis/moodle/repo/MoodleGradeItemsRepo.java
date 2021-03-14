package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleGradeItems;
import sgsits.cse.dis.moodle.response.GradeItemsData;

@Repository
public interface MoodleGradeItemsRepo extends JpaRepository<MoodleGradeItems, Long> {
	
	//@Query(value = "SELECT * FROM moodle.mdl_grade_items WHERE courseid=?1", nativeQuery = true)
	List<MoodleGradeItems> findByCourseid(Long courseId);
	
	List<MoodleGradeItems> findByIdAndCourseid(Long Id, Long courseId);

}