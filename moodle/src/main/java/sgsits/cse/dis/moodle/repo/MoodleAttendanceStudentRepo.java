package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAttendanceStudent;
import sgsits.cse.dis.moodle.model.MoodleUser;

@Repository
public interface MoodleAttendanceStudentRepo extends JpaRepository<MoodleAttendanceStudent, Long> {
	List<MoodleAttendanceStudent> findAll();
	List<MoodleAttendanceStudent> findAllByStudentid(Long studentid);
	
	@Query(value="select tableid from mdl_attendance_student where studentid=?1 ",nativeQuery=true)
	public List<Long> getByStudentid(Long studentid);
	List<MoodleAttendanceStudent> findAllByTableid(Long tableid);
     List<MoodleAttendanceStudent> findByTableid(Long tableid);
     @Query(value="select * from mdl_attendance_student where tableid in :tableid ",nativeQuery=true)
     List<MoodleAttendanceStudent> getByTableid(@Param("tableid")List<Long> tableid);
     
	@Query(value="SELECT sum(attendanceid) from mdl_attendance_student  where studentid= :studentid and tableid in :tid",nativeQuery=true )
	public Long findTotalAttendance(@Param("studentid")Long studentid,@Param("tid") List<Long> tid);
	
	@Query(value="select tableid from mdl_attendance_student where tableid=?1 group by studentid",nativeQuery = true)
	public List<Long> getByTableid(Long tableid);
	
	@Query(value="select sum(attendanceid) from mdl_attendance_student where studentid=?1 and tableid=?2  group by studentid",nativeQuery=true)
	public Long getByAttendance(Long userid,Long id);
}
