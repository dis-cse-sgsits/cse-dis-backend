package sgsits.cse.dis.academics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.academics.model.ExpertLectureDetails;
import sgsits.cse.dis.academics.model.ExpertNamesAndDesignations;

public interface ExpertLectureRepository extends JpaRepository <ExpertLectureDetails, Long> {

	List<ExpertLectureDetails> findByStatusIgnoreCase(String status);

	ExpertLectureDetails findByExpertLectureId(String expertLectureId);
	
	@Query(value = "SELECT name, designation FROM expert_details", nativeQuery = true)
	List<ExpertNamesAndDesignations> fetchExperts();

	List<ExpertLectureDetails> findByTopicContainingIgnoreCaseAndStatus(String keyword, String status);

}
