package sgsits.cse.dis.academics.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.academics.model.SchemeFile;

/**
 * <h1>SchemeRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
@Repository("schemeFileRepository")
public interface SchemeFileRepository extends JpaRepository<SchemeFile, String> {
    @Modifying
    void deleteById(String  id);
    boolean existsById(String id);
}
