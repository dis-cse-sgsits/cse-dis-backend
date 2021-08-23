package sgsits.cse.dis.moodle.repo;

import java.util.List;
import java.util.Optional;

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
	
	MoodleUser findByFirstname(String firstname);
	

	public MoodleUser findAllById(Long Id);

	Optional<MoodleUser> findById(Long id);

}
