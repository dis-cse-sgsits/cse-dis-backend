package sgsits.cse.dis.user.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.PanelOfTheory;

@Repository
public interface PanelOfTheoryRepository extends JpaRepository<PanelOfTheory, String> {

    boolean existsBySubjectCode(String subjectCode);
    
    @Modifying
    @Transactional
    Long deleteBySubjectCode(String subjectCode);
    
}
