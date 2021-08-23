package sgsits.cse.dis.moodle.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacherBulk;

@Repository
public interface MoodleAttendanceTeacherBulkRepo extends JpaRepository<MoodleAttendanceTeacherBulk, Long> {
 
	public List<MoodleAttendanceTeacherBulk> findAll();
	public List<MoodleAttendanceTeacherBulk> findAllById(Long id);
	public List<MoodleAttendanceTeacherBulk> findBySubjectid(String subjectid);
	public List<MoodleAttendanceTeacherBulk> findAllByTeacherid(Long teacherid);
	
	@Query(value="select id  from  mdl_attendance_teacher_bulk  where subjectid = :subjectid ",nativeQuery=true)
	public List<Long> getBySubject(@Param("subjectid")String subjectid);
	
	@Query(value="select subjectid  from  mdl_attendance_teacher_bulk group by subjectid,teacherid",nativeQuery=true)
	List<String> getBySubjectid();
	@Query(value="select sum(slot) as slot from  mdl_attendance_teacher_bulk where subjectid in :subjectid and id in :tableid group by subjectid",nativeQuery=true)
	public List<Long> getAllSubjectWiseSlot(@Param("subjectid") List<String> subjectid,@Param("tableid") List<Long> tableid);
	
	@Query(value="select id from  mdl_attendance_teacher_bulk where teacherid = :userid and subjectid = :coursename",nativeQuery=true)
	public List<Long> getById(@Param("userid") Long userid,@Param("coursename") String coursename);
 
 @Query(value="SELECT sum(slot) from mdl_attendance_teacher_bulk where subjectid=?1 group by subjectid",nativeQuery = true)
	public Long getTotalBulkSlot(String subjectid);
 
 @Query(value="SELECT sum(slot) from mdl_attendance_teacher_bulk group by subjectid",nativeQuery = true)
	public List<Long> getAllSlot();
 
 MoodleAttendanceTeacherBulk findAllBySubjectid(String subjectid);
 
 
}
