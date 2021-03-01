package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleUser;


@Repository
public interface MoodleUserRepo extends JpaRepository<MoodleUser, Long> {
	public MoodleUser findAllByUsername(String username);
	public List<MoodleUser> findByUsername(String username);
	@Query(value="select id from mdl_user where username=?1",nativeQuery=true)
	public Long findById(String username);
	
	public MoodleUser findAllById(Long Id);
}
