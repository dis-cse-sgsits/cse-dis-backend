package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleUser;

@Repository
public interface  MoodleCourseRepo extends JpaRepository<MoodleCourse, Long> {
	
	
	
	 public List<MoodleCourse> findAll();
	
	 public List<MoodleCourse> findAllById(Long Id);
	 public MoodleCourse  findAllByShortname(String shortname);
}
