package sgsits.cse.dis.academics.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.academics.model.IndustryVisit;

public interface IndustryVisitRepository extends JpaRepository <IndustryVisit, String> {

    List<IndustryVisit> findByStatus(String status);

    IndustryVisit findByIndustryVisitId(String industryVisitId);

    List<IndustryVisit> findByCompanyNameContainingIgnoreCaseAndStatus(String keyword, String status);
}
