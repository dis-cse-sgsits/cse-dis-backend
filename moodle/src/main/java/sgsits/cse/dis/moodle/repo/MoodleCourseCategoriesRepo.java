package sgsits.cse.dis.moodle.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleCourseCategories;

@Repository
public interface MoodleCourseCategoriesRepo extends JpaRepository<MoodleCourseCategories, Long> {
      // public Optional<MoodleCourseCategories> findById(Long courseId);
       public Optional<MoodleCourseCategories> findById(Long categoryId);
}
