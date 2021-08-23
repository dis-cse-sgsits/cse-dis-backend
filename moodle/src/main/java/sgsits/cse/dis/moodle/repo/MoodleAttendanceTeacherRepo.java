package sgsits.cse.dis.moodle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacher;

@Repository
public interface MoodleAttendanceTeacherRepo extends JpaRepository<MoodleAttendanceTeacher, Long> {
	public List<MoodleAttendanceTeacher> findAll();
	public List<MoodleAttendanceTeacher> findAllByTakenby(Long takenby);
	public List<MoodleAttendanceTeacher> findBySubjectid(String subjectid);
	public List<MoodleAttendanceTeacher> findAllById(Long id);
	
	@Query(value="select id  from  mdl_attendance_teacher  where subjectid =:subjectid ",nativeQuery=true)
	public List<Long> getBySubject(@Param("subjectid")String subjectid);
	
	@Query(value="select subjectid  from  mdl_attendance_teacher group by subjectid,takenby",nativeQuery=true)
	List<String> getBySubjectid();
	
	@Query(value="select sum(slot) as slot from  mdl_attendance_teacher where subjectid in :subjectid and id in :tableid group by subjectid",nativeQuery=true)
	public List<Long> getAllSubjectWiseSlot(@Param("subjectid") List<String> subjectid,@Param("tableid") List<Long> tableid);
	
	@Query(value="select id from  mdl_attendance_teacher where takenby= :userid and subjectid=:coursename",nativeQuery=true)
	public List<Long> getById(@Param("userid") Long userid,@Param("coursename")String coursename);
	@Query(value="SELECT sum(slot) from mdl_attendance_teacher where subjectid=?1 group by subjectid",nativeQuery = true)
	public Long getTotalSlot(String subjectid);
	
	@Query(value="SELECT sum(slot) from mdl_attendance_teacher group by subjectid",nativeQuery = true)
	public List<Long> getAllSlot();
	@Query(value="select id from  mdl_attendance_teacher where  subjectid=:coursename",nativeQuery=true)
	public List<Long> getByIdnumber(@Param("coursename")String coursename);
	
}
