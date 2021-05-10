package sgsits.cse.dis.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.ExternalExaminer;
import sgsits.cse.dis.user.model.StaffBasicProfile;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExternalExaminerRepository extends JpaRepository<ExternalExaminer,String> {
    Optional<ExternalExaminer> findByEmailId(String email);
    boolean existsByEmailId(String email);

    boolean existsById(Long id);

    Optional<ExternalExaminer> findByid(Long id);

}