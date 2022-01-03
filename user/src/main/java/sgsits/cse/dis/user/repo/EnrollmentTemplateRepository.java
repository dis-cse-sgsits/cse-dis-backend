package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.EnrollmentTemplate;

import java.util.List;
import java.util.Optional;

@Repository("enrollmentTemplateRepository")
public interface EnrollmentTemplateRepository extends JpaRepository<EnrollmentTemplate, String> {
    Optional<Object> findByfileName( String fileName);
    @Modifying
    void deleteById(String  id);
    boolean existsById(String id);
}

