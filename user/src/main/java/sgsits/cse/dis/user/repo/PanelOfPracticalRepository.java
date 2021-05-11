package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.ExternalExaminer;
import sgsits.cse.dis.user.model.PanelOfPractical;

import java.util.Optional;

@Repository
public interface PanelOfPracticalRepository extends JpaRepository<PanelOfPractical,String> {

    Optional<PanelOfPractical> findByid(String id);
}
