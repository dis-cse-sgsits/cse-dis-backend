package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.moodle.model.MoodleAttendanceStudent;
import sgsits.cse.dis.moodle.model.MoodleAttendanceStudentBulk;

@Repository
public interface MoodleAttendanceStudentBulkRepo extends JpaRepository<MoodleAttendanceStudentBulk, Long> {
	@Query(value="SELECT sum(attendance) from mdl_attendance_student_bulk  where studentid= :studentid and tableid in :tid group by studentid ",nativeQuery=true )
	public Long findTotalAttendance(@Param("studentid")Long studentid,@Param("tid") List<Long> tid);
	List<MoodleAttendanceStudentBulk> findAllByStudentid(Long studentid);
	public List<MoodleAttendanceStudentBulk> findAllByTableid(Long tableid);
    public MoodleAttendanceStudentBulk findByStudentid(Long id);
	@Query(value="select tableid from mdl_attendance_student_bulk where studentid=?1 ",nativeQuery=true)
	public List<Long> getByStudentid(Long studentid);
	@Query(value="select * from mdl_attendance_student_bulk where tableid in :tableid group by studentid",nativeQuery=true)
	public List<MoodleAttendanceStudentBulk> getAllByTableId(@Param("tableid")List<Long> tableid);
}
