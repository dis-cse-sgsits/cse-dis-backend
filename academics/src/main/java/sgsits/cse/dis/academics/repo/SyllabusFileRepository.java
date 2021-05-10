package sgsits.cse.dis.academics.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.academics.model.SyllabusFile;

import java.util.Optional;

/**
 * <h1>SchemeRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
@Repository("syllabusFileRepository")
public interface SyllabusFileRepository extends JpaRepository<SyllabusFile, String> {
    Optional<Object> findByfileName(String fileName);
    @Modifying
    void deleteById(String  id);
    boolean existsById(String id);
}
