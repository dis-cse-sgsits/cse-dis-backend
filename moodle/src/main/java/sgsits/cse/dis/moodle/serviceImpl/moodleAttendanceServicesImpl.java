package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import sgsits.cse.dis.moodle.repo.MoodleUserEnrollmentRepo;
import java.text.DecimalFormat;

import sgsits.cse.dis.moodle.repo.MoodleAttendanceTeacherBulkRepo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javassist.NotFoundException;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.service.moodleAttendanceService;
import sgsits.cse.dis.moodle.feignClient.UserClient;
import sgsits.cse.dis.moodle.model.MoodleAttendanceStudent;
import sgsits.cse.dis.moodle.model.MoodleAttendanceStudentBulk;
import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacher;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleEnrollement;
import sgsits.cse.dis.moodle.repo.MoodleEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceStudentBulkRepo ;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceStudentRepo;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceTeacherRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacherBulk;
@Component
public class moodleAttendanceServicesImpl implements moodleAttendanceService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
     public  MoodleUserRepo MoodleUserRepo;
	@Autowired
    public  MoodleUserEnrollmentRepo MoodleUserEnrollmentRepo;
	
	@Autowired
    public  MoodleEnrollmentRepo MoodleEnrollmentRepo;
	
	@Autowired
	public MoodleAttendanceStudentRepo   MoodleAttendanceStudentRepo ;
	
	@Autowired
	public MoodleAttendanceStudentBulkRepo  MoodleAttendanceStudentBulkRepo;
	
	@Autowired
	public MoodleAttendanceTeacherBulkRepo  MoodleAttendanceTeacherBulkRepo;
	
	@Autowired
	public MoodleAttendanceTeacherRepo   MoodleAttendanceTeacherRepo ;
	
	@Autowired
	public MoodleCourseRepo   MoodleCourseRepo ;
	
	@Autowired
	public UserClient userClient;
	
	//Individual Student Attendance with all subject from student perspective
	public List<TotalStudentAttendanceData> getIndividualStudentAttendance(String userid,String userType) throws NotFoundException{
		 List<TotalStudentAttendanceData> totalStudentAttendanceData =new ArrayList<>();
		 
		 String username;
		 if(userType.equals("student") && userid != null) {
			 username=userClient.getByUserName(userid);
		 MoodleUser mu=MoodleUserRepo.findAllByUsername(username);
		 List<MoodleCourse> moodleCourse = MoodleCourseRepo.findAll();
		 List<Long> attendance1=new ArrayList<Long>();
		 List<Long> attendance=new ArrayList<Long>();
		 Long count=0L;
		 Long count1=0L;
		  Long totalslot=0L;
		  Long slot2=0L;
		  Long slot3=0L;
		  Long totalcount=0L;
		 List<Long> tableid1=MoodleAttendanceStudentBulkRepo.getByStudentid(mu.getId());
		 List<Long> subjectid1=MoodleAttendanceTeacherBulkRepo.getBySubjectid();	
		 List<Long> slot1=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot(subjectid1,tableid1);
		 
		 List<Long> tableid=MoodleAttendanceStudentRepo.getByStudentid(mu.getId());
		 List<Long> subjectid=MoodleAttendanceTeacherRepo.getBySubjectid();			
		 List<Long> slot=MoodleAttendanceTeacherRepo.getAllSubjectWiseSlot(subjectid,tableid);
		 for(Long s:subjectid1)
		 if(!subjectid.contains(s)) {
			 subjectid.add(s);
		 }
		 
		 
			 for(int i=0;i<subjectid.size();i++) {	
				 TotalStudentAttendanceData sat =new TotalStudentAttendanceData();
				 TotalStudentAttendanceData sat1 =new TotalStudentAttendanceData();
				 for(MoodleCourse mc:moodleCourse) {
					 List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findBySubjectid(mc.getId());
					 for(MoodleAttendanceTeacher mat: moodleAttendanceTeacher) {
						 List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByTableid(mat.getId());
						 for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
							 if(subjectid.get(i) == mat.getSubjectid() && mu.getId() ==mas.getStudentid() ) {
							    attendance=MoodleAttendanceTeacherRepo.getBySubject(subjectid.get(i));					    
							    count=MoodleAttendanceStudentRepo.findTotalAttendance(mu.getId(),attendance);
							    slot2=MoodleAttendanceTeacherRepo.getTotalSlot(subjectid.get(i));
							    sat.setCoursename(mc.getFullname());
							    sat.setCoursecode(mc.getShortname());
							    sat.setId(mu.getId());
						    	sat.setFirstname(mu.getFirstname());
						        sat.setUsername(mu.getUsername());
						   	    sat.setLastname(mu.getLastname());
			                 }
						
				         }
			         }
				 
				 List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findBySubjectid(mc.getId());
				 for(MoodleAttendanceTeacherBulk matb: moodleAttendanceTeacherBulk) {
					 List<MoodleAttendanceStudentBulk> moodleAttendanceStudentBulk=MoodleAttendanceStudentBulkRepo.findAllByTableid(matb.getId());
					 for(MoodleAttendanceStudentBulk masb:moodleAttendanceStudentBulk) {
						 if(subjectid.get(i) == matb.getSubjectid() && mu.getId() ==masb.getStudentid() ) {
							   attendance1=MoodleAttendanceTeacherBulkRepo.getBySubject(subjectid.get(i));
							   count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),attendance1);
							   slot3=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(subjectid.get(i));
					    	   sat1.setCoursename(mc.getFullname());
					    	   sat1.setCoursecode(mc.getShortname());
					    	   sat1.setId(mu.getId());
					    	   sat1.setFirstname(mu.getFirstname());
					    	   sat1.setUsername(mu.getUsername());
					    	   sat1.setLastname(mu.getLastname());
						 }
						 
				       }
					}
			  }
				 if(sat.getCoursename() != null && sat1.getCoursename()!= null  ) {
					  
					  totalcount= count + count1;			  
					  totalslot=slot2 + slot3;			  
					  sat.setAttendance(totalcount);
					  sat.setSlot(totalslot);
				  
					  try {
						Double  percentage=(((double)totalcount/(double)totalslot))*100;
						  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
							  sat.setPercentage(roundedDouble);	  
					  }
					  catch(ArithmeticException e) {
						  System.out.println("Value return to be null" );
					  }
				  }
				 
				 else  if(sat.getCoursename() != null && sat1.getCoursename() ==null  ) {
					  
					  totalcount=count;			  
					  totalslot=slot2 ;			  
					  sat.setAttendance(totalcount);
					  sat.setSlot(totalslot);
					  
					  
				  
					  try {
						 Double percentage=(((double)totalcount/(double)totalslot))*100;
						  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
							  sat.setPercentage(roundedDouble);
						  
					  }
					  catch(ArithmeticException e) {
						  System.out.println("Value return to be null" );
					  }
				  }
				  
				  else   if(sat1.getCoursename() != null && sat.getCoursename() ==null ) {
					  
					 totalcount=count1;			  
					 totalslot=slot3;			  
					 
					  sat1.setAttendance(totalcount);
					  sat1.setSlot(totalslot); 
				  
					  try {
						Double  percentage=(((double)totalcount/(double)totalslot))*100;
						  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
							 // sat.setPercentage(roundedDouble);
							  sat1.setPercentage(roundedDouble);
						  
					  }
					  catch(ArithmeticException e) {
						  System.out.println("Value return to be null" );
					  }
				  }
				 
				  
				  if(sat.getId() !=null && sat.getCoursecode() !=null)
		 			{
		 			totalStudentAttendanceData.add(sat);
		 			}
		 		else if(sat1.getId() !=null && sat1.getCoursecode() !=null)
		 		 {totalStudentAttendanceData.add(sat1);
		 		 }
		 		else if(sat.getId() !=null && sat.getCoursecode() !=null && sat1.getId() !=null && sat1.getCoursecode() !=null) {
		 			totalStudentAttendanceData.add(sat);	
		 			totalStudentAttendanceData.add(sat1);
		 		}
			 }
		 	
		 }
		 else {
			 throw new  NotFoundException("UserID not found");
		 }	 
		return totalStudentAttendanceData;
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------
	
	public List<Long> getTableid(String username,String Coursename){
		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
		List<Long> tableid=new ArrayList<Long>();
		List<Long> slot=new ArrayList<Long>();
		List<Long> subjectid=new ArrayList<Long>();
		 List<Long> tableid1=new ArrayList<Long>();
		 List<Long> subjectid1 =new ArrayList<Long>();
		 List<Long> slot1=new ArrayList<Long>();
		List<Long> attendance=new ArrayList<Long>();
		for(MoodleUser mu: moodleUser) {
			  
			  List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
			  for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
			 if(mu.getId()==mas.getStudentid()) {
				 
				  tableid1=MoodleAttendanceStudentBulkRepo.getByStudentid(mu.getId());
				 subjectid1=MoodleAttendanceTeacherBulkRepo.getBySubjectid();	
				  slot1=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot(subjectid1,tableid1);
				 
				 tableid=MoodleAttendanceStudentRepo.getByStudentid(mu.getId());
				 subjectid=MoodleAttendanceTeacherRepo.getBySubjectid();			
				 slot=MoodleAttendanceTeacherRepo.getAllSubjectWiseSlot(subjectid,tableid);
			     //attendance=MoodleAttendanceTeacherRepo.getBySubject(subjectid.get(2));
				 for(Long s:subjectid1)
					 if(!subjectid.contains(s)) {
						 subjectid.add(s);
					 }
			 }	  
			  }
			 
			// tableid=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot();
		}
		return subjectid;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------	
	//All Student with Individual Subject Detail date wise from teacher perspective 
public List<StudentAttendanceData> getAllStudentDetails(String coursecode,String userid,String userType) throws NotFoundException{
	 String username;
	 if(userType.equals("faculty") || userType.equals("head") && userid != null) {
		 username= userClient.getByUserName(userid);
	
		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
		MoodleCourse mc= MoodleCourseRepo.findAllByShortname(coursecode);
		MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
		   List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findAllByTakenby(mu1.getId());
		   List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(mu1.getId());
		   List<Long> tableid=MoodleAttendanceTeacherRepo.getById(mu1.getId(),mc.getId());
		   List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getById(mu1.getId(),mc.getId());
		   List<StudentAttendanceData> studentAttendanceData =new ArrayList<>();
		   Long count=0L;
	for(int i=0;i<tableid.size();i++) {
		  for(MoodleUser mu: moodleUser) {
			  StudentAttendanceData sat =new StudentAttendanceData();
			  List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
			  for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
			 if(mu.getId()==mas.getStudentid()) {
				  sat.setId(mu.getId());
				   sat.setUsername(mu.getUsername());
				   sat.setFirstname(mu.getFirstname());
				   sat.setLastname(mu.getLastname()); 
				   for(MoodleAttendanceTeacher mat: moodleAttendanceTeacher) {
						   			  
							   if(mc.getId()==mat.getSubjectid() &&  tableid.get(i) == mas.getTableid()) {
							   count=MoodleAttendanceStudentRepo.getByAttendance(mu.getId(),tableid.get(i));
							   sat.setCoursename(mc.getFullname());	 
							   sat.setCoursecode(coursecode);
							   sat.setAttendance(count);
							   sat.setDate_attendance(mas.getDate_attendence());
							   sat.setSlot(mat.getSlot());
							  
							   
						   }		    
				   }
			  	}
			  }
			  
			  if(sat.getId()!=null && sat.getCoursename() != null) {
				  studentAttendanceData.add(sat);
				 
			 }
		  }  
				 
	}
	
	for(int i=0;i<tableid1.size();i++) {
		  for(MoodleUser mu: moodleUser) {
			  StudentAttendanceData sat1 =new StudentAttendanceData();
			  List<MoodleAttendanceStudentBulk> moodleAttendanceStudentBulk=MoodleAttendanceStudentBulkRepo.findAllByStudentid(mu.getId());
			  for(MoodleAttendanceStudentBulk masb:moodleAttendanceStudentBulk) {
				  if(mu.getId()==masb.getStudentid()) {
					  sat1.setId(mu.getId());
					   sat1.setUsername(mu.getUsername());
					   sat1.setFirstname(mu.getFirstname());
					   sat1.setLastname(mu.getLastname());
					   for(MoodleAttendanceTeacherBulk matb: moodleAttendanceTeacherBulk) {  			  
							   if(mc.getId()==matb.getSubjectid()  && tableid1.get(i) == masb.getTableid() && masb.getTableid()==matb.getId() ) {
							   sat1.setCoursename(mc.getFullname());
							   sat1.setCoursecode(coursecode);
							   sat1.setAttendance(masb.getAttendance());
							   sat1.setDate_attendance(masb.getDate_attendence());
							   sat1.setSlot(matb.getSlot());
							   
							   
						   }		    
				   }
					  
			  }	 
			  }
			  if(sat1.getId()!=null && sat1.getCoursename() != null) {
				  studentAttendanceData.add(sat1);
				 
			  }
		  }
	}
		return studentAttendanceData;
	 }
	 else {
		 throw new  NotFoundException("UserID not found");
	 }
	}

	
	
	




//--------------------------------------------------------------------------------------------------------------------------------------------	
	
	//All Student individual subjectwise total attendance with percentage from teacher perspective
	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException{
		
		String username;
		 if(userType.equals("faculty") || userType.equals("head") && userid != null) {
			 username= userClient.getByUserName(userid);
		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
		MoodleCourse mc = MoodleCourseRepo.findAllByShortname(coursecode);
		Long count=0L;
		Long count1=0L;
		Long totalcount;
		Long slot=0L;
		Long slot1=0L;
		Long totalslot;
		Double percentage;
		List<TotalStudentAttendanceData> totalStudentAttendanceData =new ArrayList<>();
		  for(MoodleUser mu: moodleUser) {
			  TotalStudentAttendanceData sat =new TotalStudentAttendanceData();
			  TotalStudentAttendanceData sat1 =new TotalStudentAttendanceData();
			  List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
			  List<MoodleAttendanceStudentBulk> moodleAttendanceStudentBulk=MoodleAttendanceStudentBulkRepo.findAllByStudentid(mu.getId());
			  for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
			  if(mu.getId()==mas.getStudentid()) {
				  sat.setId(mu.getId());
				   sat.setUsername(mu.getUsername());
				   sat.setFirstname(mu.getFirstname());
				   sat.setLastname(mu.getLastname());	
				   MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
				   List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findAllByTakenby(mu1.getId());
				   List<Long> tableid=MoodleAttendanceTeacherRepo.getById(mu1.getId(),mc.getId());
				  
				   for(MoodleAttendanceTeacher mat:moodleAttendanceTeacher) {
					  
						 
						   if(mc.getId()==mat.getSubjectid() && mat.getId() ==mas.getTableid())
						   {  
						        
							   count=MoodleAttendanceStudentRepo.findTotalAttendance(mu.getId(),tableid);
						       slot=MoodleAttendanceTeacherRepo.getTotalSlot(mc.getId());					      
						   	   sat.setAttendance(count);
							   sat.setCoursename(mc.getFullname());	 
							   sat.setCoursecode(coursecode);
							   sat.setSlot(slot);
						   
					   }
				   }
			  }
				  
			  }
			  
			  for(MoodleAttendanceStudentBulk masb:moodleAttendanceStudentBulk) {
				  if(mu.getId()==masb.getStudentid()) {
					  sat1.setId(mu.getId());
					   sat1.setUsername(mu.getUsername());
					   sat1.setFirstname(mu.getFirstname());
					   sat1.setLastname(mu.getLastname());
					   MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
					   List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(mu1.getId());
					   List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getById(mu1.getId(),mc.getId());
					   for(MoodleAttendanceTeacherBulk matb:moodleAttendanceTeacherBulk) {
						   
							   if(mc.getId()==matb.getSubjectid() && masb.getTableid()==matb.getId() )
							   {   count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),tableid1);						        
	     					       slot1=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(mc.getId());
								   sat1.setAttendance(count1);
								   sat1.setCoursename(mc.getFullname());
								   sat1.setSlot(slot1);
								   sat1.setCoursecode(coursecode);
							   }
						   
					   
				  }
				  }
					   }
			  
			  if(sat.getCoursename() != null && sat1.getCoursename()!= null ) {
				  
				  totalcount=count + count1;			  
				  totalslot=slot + slot1;			  
				  sat.setAttendance(totalcount);
				  sat.setSlot(totalslot);
				  sat1.setAttendance(totalcount);
				  sat1.setSlot(totalslot); 
			  
				  try {
					  percentage=(((double)totalcount/(double)totalslot))*100;
					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
						  sat.setPercentage(roundedDouble);
						  sat1.setPercentage(roundedDouble);
					  
				  }
				  catch(ArithmeticException e) {
					  System.out.println("Value return to be null" );
				  }
			  }
			 
			  if(sat.getCoursename() != null && sat1.getCoursename() ==null  ) {
				  
				  totalcount=count + count1;			  
				  totalslot=slot + slot1;			  
				  sat.setAttendance(totalcount);
				  sat.setSlot(totalslot);
				  sat1.setAttendance(totalcount);
				  sat1.setSlot(totalslot); 
				  
			  
				  try {
					  percentage=(((double)totalcount/(double)totalslot))*100;
					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
						  sat.setPercentage(roundedDouble);
					  
				  }
				  catch(ArithmeticException e) {
					  System.out.println("Value return to be null" );
				  }
			  }
			  
			  if(sat1.getCoursename() != null && sat.getCoursename() ==null ) {
				  
				  totalcount=count + count1;			  
				  totalslot=slot + slot1;			  
				  sat.setAttendance(totalcount);
				  sat.setSlot(totalslot);
				  sat1.setAttendance(totalcount);
				  sat1.setSlot(totalslot); 
			  
				  try {
					  percentage=(((double)totalcount/(double)totalslot))*100;
					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
						  sat1.setPercentage(roundedDouble);
					  
				  }
				  catch(ArithmeticException e) {
					  System.out.println("Value return to be null" );
				  }
			  }
			  
			  
			  if(sat.getId()!=null && sat.getCoursename() != null) {
				 
				  totalStudentAttendanceData.add(sat);			 
			 }
			  else if(sat1.getId() !=null && sat1.getCoursename() != null){
				 totalStudentAttendanceData.add(sat1);
			 }
				 
	}		
		return totalStudentAttendanceData;
		 }
		 else {
			 throw new NotFoundException("UserID not found"); 
		 }
	}
//--------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public List<String> getIndividualUserGradeCategory(String userid) throws NotFoundException {
		// TODO Auto-generated method stub
		String username;
		List<String> courseCode =new ArrayList<String>();
		 if( userid != null) {
			 username= userClient.getByUserName(userid);
			 MoodleUser mu =MoodleUserRepo.findAllByUsername(username);
			 List<MoodleUserEnrollment> moodleUserEnrollment=MoodleUserEnrollmentRepo.findByUserid(mu.getId());
			 for(MoodleUserEnrollment mue: moodleUserEnrollment) {
				 List<MoodleEnrollement> moodleEnrollment=MoodleEnrollmentRepo.findAllById(mue.getEnrolid());
				 for(MoodleEnrollement me:moodleEnrollment) {
					 List<MoodleCourse> moodleCourse=MoodleCourseRepo.findAllById(me.getCourseid());
					 for(MoodleCourse mc:moodleCourse) {
						 courseCode.add(mc.getShortname());
					 }
				 }
			 }
			 return courseCode;
		 }
		 else {
			 throw new NotFoundException("UserID not found"); 
		 }
	}
	
	@Override
	public List<String> getIndividualUserGradeCategoryName(String userid) throws NotFoundException {
		// TODO Auto-generated method stub
		String username;
		List<String> courseCode =new ArrayList<String>();
		 if( userid != null) {
			 username= userClient.getByUserName(userid);
			 MoodleUser mu =MoodleUserRepo.findAllByUsername(username);
			 List<MoodleUserEnrollment> moodleUserEnrollment=MoodleUserEnrollmentRepo.findByUserid(mu.getId());
			 for(MoodleUserEnrollment mue: moodleUserEnrollment) {
				 List<MoodleEnrollement> moodleEnrollment=MoodleEnrollmentRepo.findAllById(mue.getEnrolid());
				 for(MoodleEnrollement me:moodleEnrollment) {
					 List<MoodleCourse> moodleCourse=MoodleCourseRepo.findAllById(me.getCourseid());
					 for(MoodleCourse mc:moodleCourse) {
						 courseCode.add(mc.getFullname());
					 }
				 }
			 }
			 return courseCode;
		 }
		 else {
			 throw new NotFoundException("UserID not found"); 
		 }
	}
		
}
