package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.academics.model.ExpertDetails;

public interface ExpertRepository extends JpaRepository<ExpertDetails, Long> {

	ExpertDetails findByNameAndDesignation(String name, String designation);

}
