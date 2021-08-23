package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Console;
import java.io.Serializable;
import sgsits.cse.dis.moodle.repo.MoodleUserEnrollmentRepo;
import java.text.DecimalFormat;

import sgsits.cse.dis.moodle.repo.MoodleAttendanceTeacherBulkRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

import com.google.common.base.Optional;

import javassist.NotFoundException;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.Course;
import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.response.MoodleCourseCategoriesResponse;
import sgsits.cse.dis.moodle.response.MoodleTeacherAttendanceData;
import sgsits.cse.dis.moodle.response.StudentAttendanceData;
import sgsits.cse.dis.moodle.response.TotalStudentAttendanceData;
import sgsits.cse.dis.moodle.service.moodleAttendanceService;
import sgsits.cse.dis.moodle.feignClient.UserClient;
import sgsits.cse.dis.moodle.model.MoodleAttendanceStudent;
import sgsits.cse.dis.moodle.model.MoodleAttendanceStudentBulk;
import sgsits.cse.dis.moodle.model.MoodleAttendanceTeacher;
import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleCourseCategories;
import sgsits.cse.dis.moodle.model.MoodleEnrollement;
import sgsits.cse.dis.moodle.repo.MoodleEnrollmentRepo;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceStudentBulkRepo ;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.model.MoodleUserEnrollment;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceStudentRepo;
import sgsits.cse.dis.moodle.repo.MoodleAttendanceTeacherRepo;
import sgsits.cse.dis.moodle.repo.MoodleCourseCategoriesRepo;
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
	public MoodleCourseCategoriesRepo  MoodleCourseCategoriesRepo   ;
	
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
		 List<String> subjectid1=MoodleAttendanceTeacherBulkRepo.getBySubjectid();	
		 List<Long> slot1=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot(subjectid1,tableid1);	 
		 List<Long> tableid=MoodleAttendanceStudentRepo.getByStudentid(mu.getId());
		 List<String> subjectid=MoodleAttendanceTeacherRepo.getBySubjectid();			
		 List<Long> slot=MoodleAttendanceTeacherRepo.getAllSubjectWiseSlot(subjectid,tableid);
		 for(String s:subjectid1)
		 if(!subjectid.contains(s)) {
			 subjectid.add(s);
		 }
		 
		 
			 for(int i=0;i<subjectid.size();i++) {	
				 TotalStudentAttendanceData sat =new TotalStudentAttendanceData();
				 TotalStudentAttendanceData sat1 =new TotalStudentAttendanceData();
				 for(MoodleCourse mc:moodleCourse) {
					 List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findBySubjectid(mc.getIdnumber());
					 for(MoodleAttendanceTeacher mat: moodleAttendanceTeacher) {
						 List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByTableid(mat.getId());
						 for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
							 if(subjectid.get(i).equalsIgnoreCase(mat.getSubjectid()) && mu.getId() ==mas.getStudentid() ) {
							    attendance=MoodleAttendanceTeacherRepo.getBySubject(subjectid.get(i));					    
							    count=MoodleAttendanceStudentRepo.findTotalAttendance(mu.getId(),attendance);
							    slot2=MoodleAttendanceTeacherRepo.getTotalSlot(subjectid.get(i));
							    sat.setCoursename(mc.getFullname());
							    sat.setCoursecode(mc.getIdnumber());
							    sat.setId(mu.getId());
						    	sat.setFirstname(mu.getFirstname());
						        sat.setUsername(mu.getUsername());
						   	    sat.setLastname(mu.getLastname());
			                 }
						
				         }
			         }
				 
				 List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findBySubjectid(mc.getIdnumber());
				 for(MoodleAttendanceTeacherBulk matb: moodleAttendanceTeacherBulk) {
					 List<MoodleAttendanceStudentBulk> moodleAttendanceStudentBulk=MoodleAttendanceStudentBulkRepo.findAllByTableid(matb.getId());
					 for(MoodleAttendanceStudentBulk masb:moodleAttendanceStudentBulk) {
						 if(subjectid.get(i).equalsIgnoreCase(matb.getSubjectid()) && mu.getId() ==masb.getStudentid() ) {
							   attendance1=MoodleAttendanceTeacherBulkRepo.getBySubject(subjectid.get(i));
							   count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),attendance1);
							   slot3=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(subjectid.get(i));
					    	   sat1.setCoursename(mc.getFullname());
					    	   sat1.setCoursecode(mc.getIdnumber());
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
		 			Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
						  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {							
								return o1.getCoursecode().compareTo(o2.getCoursecode());							
								 }						  
					  });
		 			}
		 		else if(sat1.getId() !=null && sat1.getCoursecode() !=null)
		 		 {totalStudentAttendanceData.add(sat1);
		 		Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
					  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {							
							return o1.getCoursecode().compareTo(o2.getCoursecode());							
							 }						  
				  });
		 		 }
		 		else if(sat.getId() !=null && sat.getCoursecode() !=null && sat1.getId() !=null && sat1.getCoursecode() !=null) {
		 			totalStudentAttendanceData.add(sat);	
		 			totalStudentAttendanceData.add(sat1);
		 			Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
						  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {							
								return o1.getCoursecode().compareTo(o2.getCoursecode());							
								 }						  
					  });
		 		}
			 }
		 	
		 }
		 else {
			 throw new  NotFoundException("UserID not found");
		 }	 
		return totalStudentAttendanceData;
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------
	
	public Long  getTableid(String username,String Coursename){
		List<MoodleUser> moodleUser = MoodleUserRepo.findByUsername(username);
		List<Long> tableid=new ArrayList<>();
		List<Long> slot=new ArrayList<Long>();
		List<String> subjectid=new ArrayList<String>();
		List<Long>  tableid1=new ArrayList<>();
		 List<String> subjectid1 =new ArrayList<String>();
		 //List<Long> slot1=new ArrayList<Long>();
		 Long count1=0L;
		 Long slot1 =0L;
		List<Long> attendance=new ArrayList<Long>();
		MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
		for(MoodleUser mu: moodleUser) {
		MoodleCourse mc= MoodleCourseRepo.findByIdnumber(Coursename);
			 // List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
			  //for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
			 //if(mu.getId()==mas.getStudentid()) {
//		 List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(mu1.getId());
//		  	
//					
//		 tableid=MoodleAttendanceTeacherRepo.getById(mu1.getId(),mc.getIdnumber());
//		   tableid1=MoodleAttendanceTeacherBulkRepo.getById(mu1.getId(),mc.getIdnumber());
//		List<MoodleAttendanceTeacherBulk> mtb=MoodleAttendanceTeacherBulkRepo.findBySubjectid(Coursename);
//		 for(MoodleAttendanceTeacherBulk mtb1 :mtb) {
//			 tableid1=MoodleAttendanceTeacherBulkRepo.getBySubject(mtb1.getSubjectid());
//		 }
//		  tableid=MoodleAttendanceTeacherRepo.getById(mu1.getId(),mc.getIdnumber());
		  tableid1=MoodleAttendanceTeacherBulkRepo.getBySubject(mc.getIdnumber());
		  count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),tableid1);						        
	       slot1=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(Coursename);
//				 tableid1=MoodleAttendanceStudentBulkRepo.getByStudentid(mu.getId());
//				 subjectid1=MoodleAttendanceTeacherBulkRepo.getBySubjectid();	
//				slot1=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot(subjectid1,tableid1);	 
//				tableid=MoodleAttendanceStudentRepo.getByStudentid(mu.getId());
//				 subjectid=MoodleAttendanceTeacherRepo.getBySubjectid();			
//				 slot=MoodleAttendanceTeacherRepo.getAllSubjectWiseSlot(subjectid,tableid);
//				  tableid1=MoodleAttendanceStudentBulkRepo.getByStudentid(mu.getId());
//				 subjectid1=MoodleAttendanceTeacherBulkRepo.getBySubjectid();	
//				  slot1=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot(subjectid1,tableid1);
//				 
//				 tableid=MoodleAttendanceStudentRepo.getByStudentid(mu.getId());
//				 subjectid=MoodleAttendanceTeacherRepo.getBySubjectid();			
//				 slot=MoodleAttendanceTeacherRepo.getAllSubjectWiseSlot(subjectid,tableid);
			     //attendance=MoodleAttendanceTeacherRepo.getBySubject(subjectid.get(2));
				 for(String s:subjectid)
					 if(!subjectid.contains(s)) {
						 subjectid.add(s);
					 }
			// }	  
			  //}
			 
			// tableid=MoodleAttendanceTeacherBulkRepo.getAllSubjectWiseSlot();
		}
		return slot1;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------	
	//All Student with Individual Subject Detail date wise from teacher perspective 
public List<StudentAttendanceData> getAllStudentDetails(String coursecode,String userid,String userType) throws NotFoundException{
	 String username;
	 if(userType.equals("faculty") || userType.equals("head") && userid != null) {
		 username= userClient.getByUserName(userid);
		 
		MoodleCourse mc= MoodleCourseRepo.findByIdnumber(coursecode);
		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
		MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
		 List<MoodleAttendanceTeacher> mt=MoodleAttendanceTeacherRepo.findBySubjectid(coursecode);
		 List<MoodleAttendanceTeacherBulk> mtb=MoodleAttendanceTeacherBulkRepo.findBySubjectid(coursecode);
		   
//		    List<Long> tableid=MoodleAttendanceTeacherRepo.getById(mu1.getId(),mc.getIdnumber());
//		   List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getById(mu1.getId(),mc.getIdnumber());
		 List<Long> tableid=MoodleAttendanceTeacherRepo.getBySubject(coursecode);
		 List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getBySubject(coursecode);
		   List<StudentAttendanceData> studentAttendanceData =new ArrayList<StudentAttendanceData>();	
		   List<StudentAttendanceData> sat2= new ArrayList<>();
		   Long count=0L;
		   Long slot=0L;
  
	for(int i=0;i<tableid.size();i++) {	
		  for(MoodleUser mu: moodleUser) {
			  StudentAttendanceData sat =new StudentAttendanceData();
			  List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
			  for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
			 if(mu.getId()==mas.getStudentid()) {			 
				   for(MoodleAttendanceTeacher mat: mt) {		
					   List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findAllByTakenby(mat.getTakenby());
							   if(mc.getIdnumber().equalsIgnoreCase(mat.getSubjectid()) && mat.getId() == mas.getTableid() &&  tableid.get(i) == mas.getTableid()) {
							  count=MoodleAttendanceStudentRepo.getByAttendance(mu.getId(),tableid.get(i));
							 // studentAttendanceData.get(i).add(new StudentAttendanceData(mu.getId(),mu.getUsername(),mu.getFirstname(),mu.getLastname(),mc.getFullname(),count,mat.getSlot(),mas.getDate_attendence(),mc.getShortname()));						  
							  sat.setId(mu.getId());							  
							  sat.setUsername(mu.getUsername());
					           sat.setFirstname(mu.getFirstname());
							   sat.setLastname(mu.getLastname()); 
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
					   for(MoodleAttendanceTeacherBulk matb: mtb) {  	
						   List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(matb.getTeacherid());
							 
							   if(mc.getIdnumber().equalsIgnoreCase(matb.getSubjectid())  && tableid1.get(i) == masb.getTableid() && masb.getTableid()==matb.getId() ) {
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
				  Collections.sort(studentAttendanceData, new Comparator<StudentAttendanceData>(){
					  public int compare(StudentAttendanceData o1,StudentAttendanceData o2) {
						int c;
						c=o1.getId().compareTo(o2.getId());	 
						if(c==0)
							return o1.getDate_attendance().compareTo(o2.getDate_attendance());	
						return c;
							 }
					  
				  });
				  
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
//	
//	
//	public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException{
//		
//		String username;
//		 if(userType.equals("faculty") || userType.equals("head") && userid != null) {
//			 username= userClient.getByUserName(userid);
//		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
//		MoodleCourse mc = MoodleCourseRepo.findByIdnumber(coursecode);
//		Long count=0L;
//		Long count1=0L;
//		Long totalcount;
//		Long slot=0L;
//		Long slot1=0L;
//		Long totalslot;
//		Double percentage;
//		List<TotalStudentAttendanceData> totalStudentAttendanceData =new ArrayList<>();
//		  for(MoodleUser mu: moodleUser) {
//			  TotalStudentAttendanceData sat =new TotalStudentAttendanceData();
//			  TotalStudentAttendanceData sat1 =new TotalStudentAttendanceData();
//			  List<MoodleAttendanceStudent> moodleAttendanceStudent=MoodleAttendanceStudentRepo.findAllByStudentid(mu.getId());
//			  List<MoodleAttendanceStudentBulk> moodleAttendanceStudentBulk=MoodleAttendanceStudentBulkRepo.findAllByStudentid(mu.getId());
//			  for(MoodleAttendanceStudent mas:moodleAttendanceStudent) {
//			  if(mu.getId()==mas.getStudentid()) {
//				  sat.setId(mu.getId());
//				   sat.setUsername(mu.getUsername());
//				   sat.setFirstname(mu.getFirstname());
//				   sat.setLastname(mu.getLastname());	
//				   MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
//				   List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findAllByTakenby(mu1.getId());
//				   List<Long> tableid=MoodleAttendanceTeacherRepo.getBySubject(coursecode);
//				  
//				   for(MoodleAttendanceTeacher mat:moodleAttendanceTeacher) {
//					  
//						 
//						   if(mc.getIdnumber().equalsIgnoreCase(mat.getSubjectid()) || mat.getId() ==mas.getTableid())
//						   {  
//						        
//							   count=MoodleAttendanceStudentRepo.findTotalAttendance(mu.getId(),tableid);
//						       slot=MoodleAttendanceTeacherRepo.getTotalSlot(mc.getIdnumber());					      
//						   	   sat.setAttendance(count);
//							   sat.setCoursename(mc.getFullname());	 
//							   sat.setCoursecode(coursecode);
//							   sat.setSlot(slot);
//						   
//					   }
//				   }
//			  }
//				  
//			  }
//			  
//			  for(MoodleAttendanceStudentBulk masb:moodleAttendanceStudentBulk) {
//				 // if(mu.getId()==masb.getStudentid()) {
//					  sat1.setId(mu.getId());
//					   sat1.setUsername(mu.getUsername());
//					   sat1.setFirstname(mu.getFirstname());
//					   sat1.setLastname(mu.getLastname());
//					   MoodleUser mu1=MoodleUserRepo.findAllByUsername(username);
//					   List<MoodleAttendanceTeacherBulk> mtb=MoodleAttendanceTeacherBulkRepo.findBySubjectid(coursecode);
//					   List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getBySubject(coursecode);
//					   for(MoodleAttendanceTeacherBulk matb:mtb) {
//						   List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(matb.getTeacherid());
//							     
//							   if(coursecode.equalsIgnoreCase(matb.getSubjectid()) || masb.getTableid()==matb.getId() )
//							   {   count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),tableid1);						        
//	     					       slot1=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(coursecode);
//								   sat1.setAttendance(count1);
//								   sat1.setCoursename(mc.getFullname());
//								   sat1.setSlot(slot1);
//								   sat1.setCoursecode(coursecode);
//							   }
//						   
//					   
//				//  }
//				  }
//					   }
//			  
//			  if(sat.getCoursename() != null && sat1.getCoursename()!= null ) {
//				  
//				  totalcount=count + count1;			  
//				  totalslot=slot + slot1;			  
//				  sat.setAttendance(totalcount);
//				  sat.setSlot(totalslot);
//				  sat1.setAttendance(totalcount);
//				  sat1.setSlot(totalslot); 
//			  
//				  try {
//					  percentage=(((double)totalcount/(double)totalslot))*100;
//					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
//						  sat.setPercentage(roundedDouble);
//						  sat1.setPercentage(roundedDouble);
//					  
//				  }
//				  catch(ArithmeticException e) {
//					  System.out.println("Value return to be null" );
//				  }
//			  }
//			 
//			  if(sat.getCoursename() != null && sat1.getCoursename() ==null  ) {
//				  
//				  totalcount=count + count1;			  
//				  totalslot=slot + slot1;			  
//				  sat.setAttendance(totalcount);
//				  sat.setSlot(totalslot);
//				  sat1.setAttendance(totalcount);
//				  sat1.setSlot(totalslot); 
//				  
//			  
//				  try {
//					  percentage=(((double)totalcount/(double)totalslot))*100;
//					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
//						  sat.setPercentage(roundedDouble);
//					  
//				  }
//				  catch(ArithmeticException e) {
//					  System.out.println("Value return to be null" );
//				  }
//			  }
//			  
//			  if(sat1.getCoursename() != null && sat.getCoursename() ==null ) {
//				  
//				  totalcount=count + count1;			  
//				  totalslot=slot + slot1;			  
//				  sat.setAttendance(totalcount);
//				  sat.setSlot(totalslot);
//				  sat1.setAttendance(totalcount);
//				  sat1.setSlot(totalslot); 
//			  
//				  try {
//					  percentage=(((double)totalcount/(double)totalslot))*100;
//					  double roundedDouble = Math.round(percentage * 100.0) / 100.0;
//						  sat1.setPercentage(roundedDouble);
//					  
//				  }
//				  catch(ArithmeticException e) {
//					  System.out.println("Value return to be null" );
//				  }
//			  }
//			  
//			  
//			  if(sat.getId()!=null && sat.getCoursename() != null) {
//				 
//				  totalStudentAttendanceData.add(sat);	
//				  Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
//					  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {			
//						return o1.getId().compareTo(o2.getId());	 
//							 }
//					  
//				  });
//			 }
//			  else if(sat1.getId() !=null && sat1.getCoursename() != null){
//				 totalStudentAttendanceData.add(sat1);
//				 Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
//					  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {				
//						return o1.getId().compareTo(o2.getId());	 
//							 }
//					  
//				  });
//			 }
//				 
//	}		
//		return totalStudentAttendanceData;
//		 }
//		 else {
//			 throw new NotFoundException("UserID not found"); 
//		 }
//	}
//----------------------------------------------------------------------------------------------------------------
//All Student individual subjectwise total attendance with percentage from teacher perspective
public List<TotalStudentAttendanceData> getAllStudentTotalAttendance(String coursecode,String userid,String userType) throws NotFoundException{
		
		String username;
		 if(userType.equals("faculty") || userType.equals("head") && userid != null) {
			 username= userClient.getByUserName(userid);
		List<MoodleUser> moodleUser = MoodleUserRepo.findAll();
		MoodleCourse mc = MoodleCourseRepo.findByIdnumber(coursecode);
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
				   
				   List<Long> tableid=MoodleAttendanceTeacherRepo.getBySubject(coursecode);
				   List<MoodleAttendanceTeacher> mt=MoodleAttendanceTeacherRepo.findBySubjectid(coursecode);
				   for(MoodleAttendanceTeacher mat:mt) {
					   List<MoodleAttendanceTeacher> moodleAttendanceTeacher=MoodleAttendanceTeacherRepo.findAllByTakenby(mat.getTakenby());
						 
						   if(mc.getIdnumber().equalsIgnoreCase(mat.getSubjectid()) && mat.getId() ==mas.getTableid())
						   {  		        
							   count=MoodleAttendanceStudentRepo.findTotalAttendance(mu.getId(),tableid);
						       slot=MoodleAttendanceTeacherRepo.getTotalSlot(mc.getIdnumber());					      
						   	   sat.setAttendance(count);
							   sat.setCoursename(mc.getFullname());	 
							   sat.setCoursecode(coursecode);
							   sat.setCourseid(mc.getId());
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
					   List<MoodleAttendanceTeacherBulk> mtb=MoodleAttendanceTeacherBulkRepo.findBySubjectid(coursecode);
					   List<Long> tableid1=MoodleAttendanceTeacherBulkRepo.getBySubject(coursecode);
					   for(MoodleAttendanceTeacherBulk matb:mtb) {
						   List<MoodleAttendanceTeacherBulk> moodleAttendanceTeacherBulk=MoodleAttendanceTeacherBulkRepo.findAllByTeacherid(matb.getTeacherid());
							     
							   if(coursecode.equalsIgnoreCase(matb.getSubjectid()) && masb.getTableid()==matb.getId())
							   {   count1=MoodleAttendanceStudentBulkRepo.findTotalAttendance(mu.getId(),tableid1);						        
	     					       slot1=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(coursecode);
								   sat1.setAttendance(count1);
								   sat1.setCoursename(mc.getFullname());
								   sat1.setSlot(slot1);
								   sat1.setCoursecode(coursecode);
								   sat1.setCourseid(mc.getId());
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
				  count1=0L;
				  slot1=0L;
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
				  count=0L;
				  slot=0L;
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
				  Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
					  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {			
						return o1.getId().compareTo(o2.getId());	 
							 }
					  
				  });
			 }
			  else if(sat1.getId() !=null && sat1.getCoursename() != null){
				 totalStudentAttendanceData.add(sat1);
				 Collections.sort(totalStudentAttendanceData, new Comparator<TotalStudentAttendanceData>(){
					  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {				
						return o1.getId().compareTo(o2.getId());	 
							 }
					  
				  });
			 }
				 
	}		
		return totalStudentAttendanceData;
		 }
		 else {
			 throw new NotFoundException("UserID not found"); 
		 }
	}
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	public List<Course> getIndividualUserCourseDetails(String userid) throws NotFoundException{
		// TODO Auto-generated method stub
		List<Course> courseCode =new ArrayList<>();
		if(userid !=null){ 
			String username= userClient.getByUserName(userid);
			 MoodleUser mu =MoodleUserRepo.findAllByUsername(username);
			 List<MoodleUserEnrollment> moodleUserEnrollment=MoodleUserEnrollmentRepo.findByUserid(mu.getId());
			 for(MoodleUserEnrollment mue: moodleUserEnrollment) {
				 List<MoodleEnrollement> moodleEnrollment=MoodleEnrollmentRepo.findAllById(mue.getEnrolid());
				 for(MoodleEnrollement me:moodleEnrollment) {
					 List<MoodleCourse> moodleCourse=MoodleCourseRepo.findAllById(me.getCourseid());
					 for(MoodleCourse mc:moodleCourse) {
						 courseCode.add( new Course(mc.getId(),mc.getFullname(),mc.getIdnumber()));
					 }
				 }
			 }
			 return courseCode;
		}
		else {
			throw new NotFoundException("UserID not found"); 
		}
	}
	
	public List<MoodleTeacherAttendanceData> CalculateTeacherAttendance(String coursecode,String username){
		 List<MoodleTeacherAttendanceData> teacherbulkslot =new ArrayList<MoodleTeacherAttendanceData>();
		 MoodleUser moodleuser =MoodleUserRepo.findAllByUsername(username);
		 Long slot=0L;
		 Long slot1=0L;
		 Long totalslot=0L;
		 MoodleTeacherAttendanceData matd =new MoodleTeacherAttendanceData();
		 MoodleTeacherAttendanceData matd1 =new MoodleTeacherAttendanceData();
			 MoodleCourse mc = MoodleCourseRepo.findByIdnumber(coursecode);
			
				 List<MoodleAttendanceTeacherBulk> matb= MoodleAttendanceTeacherBulkRepo.findBySubjectid(mc.getIdnumber());
				 List<MoodleAttendanceTeacher> mat= MoodleAttendanceTeacherRepo.findBySubjectid(mc.getIdnumber());
				 for(MoodleAttendanceTeacherBulk matb1 : matb) {
					 
					 matd.setSubjectid(mc.getIdnumber());
					 matd.setUserid(moodleuser.getId());
						matd.setUsername(moodleuser.getUsername());
					 if(mc.getIdnumber().equalsIgnoreCase(matb1.getSubjectid())) {
						 slot=MoodleAttendanceTeacherBulkRepo.getTotalBulkSlot(matb1.getSubjectid());
						 List<Long> tableid=MoodleAttendanceTeacherBulkRepo.getById(moodleuser.getId(),mc.getIdnumber());
						 matd.setSlot(slot);
						 matd.setTableid(tableid);
					 
					 }		
					 
				 }
				
				 teacherbulkslot.add(matd);
			 
			 
		
		return teacherbulkslot;
	} 
	public List<MoodleTeacherAttendanceData> CalculateTeacherBulkAttendance(String coursecode,String username){
		 List<MoodleTeacherAttendanceData> teacherbulkslot =new ArrayList<MoodleTeacherAttendanceData>();
		 MoodleUser moodleuser =MoodleUserRepo.findAllByUsername(username);
		 Long slot=0L;
		
		 MoodleTeacherAttendanceData matd1 =new MoodleTeacherAttendanceData();
			 MoodleCourse mc = MoodleCourseRepo.findByIdnumber(coursecode);
			
				
				 List<MoodleAttendanceTeacher> mat= MoodleAttendanceTeacherRepo.findBySubjectid(mc.getIdnumber());
				
				 for(MoodleAttendanceTeacher mat1 : mat) {
					 
					 matd1.setSubjectid(mc.getIdnumber());
					 matd1.setUserid(moodleuser.getId());
						matd1.setUsername(moodleuser.getUsername());
					 if(mc.getIdnumber().equalsIgnoreCase(matd1.getSubjectid())) {
						 slot=MoodleAttendanceTeacherRepo.getTotalSlot(mat1.getSubjectid());
						 List<Long> tableid=MoodleAttendanceTeacherRepo.getById(moodleuser.getId(),mc.getIdnumber());
						 matd1.setSlot(slot);
						 matd1.setTableid(tableid);
					 
					 }		
					 
				 }
				 teacherbulkslot.add(matd1);
			 
			 
		
		return teacherbulkslot;
	} 
	
public List<MoodleCourseCategories>  getCourseCategoryList(){	
	List<MoodleCourseCategories> list = new ArrayList<>();
	MoodleCourseCategoriesRepo.findAll().forEach(list::add);
	return list;	
}

public List<MoodleCourse>  getCourseCategoryNameList(Long categoryId){
	List<MoodleCourseCategoriesResponse> sat= new ArrayList<MoodleCourseCategoriesResponse>();	
	MoodleCourseCategoriesResponse sat1= new MoodleCourseCategoriesResponse();
	List<MoodleCourse> list = new ArrayList<>();
		  MoodleCourseRepo.findAllByCategory(categoryId).forEach(list::add);			
	return list;
	
}



public List<List<MoodleCourseCategoriesResponse>> getLessStudentAttendancePercentageList(Long categoryId,Long courseid,String userId,Double percentage,String usertype) throws NotFoundException{
	String username;
	 if( usertype.equals("head") && userId != null) {
		 username= userClient.getByUserName(userId);
	 }
    List<List<MoodleCourseCategoriesResponse>> userAttendanceReport = new ArrayList<List<MoodleCourseCategoriesResponse>>();
	 Double count=0D;
	 List<MoodleCourseCategoriesResponse> totalStudentAttendanceData =new ArrayList<MoodleCourseCategoriesResponse>();
	
	 List<MoodleCourseCategoriesResponse> totalStudentAttendanceData1 =new ArrayList<MoodleCourseCategoriesResponse>();
	 
		 List<MoodleCourse> list1=getCourseCategoryNameList(categoryId);
		// initializing 2d empty list of lists for entering final data if empty
		 
		 for(int i=0;i<list1.size();i++) {
			
		 List<TotalStudentAttendanceData> sat = getAllStudentTotalAttendance(list1.get(i).getIdnumber(),userId,usertype);
		 Collections.sort(sat, new Comparator<TotalStudentAttendanceData>(){
			  public int compare(TotalStudentAttendanceData o1,TotalStudentAttendanceData o2) {
				int c;
				c=o1.getId().compareTo(o2.getId());	 
				if(c==0)
					return o1.getCoursecode().compareTo(o2.getCoursecode());	
				return c;
		 }
		 });
		 for(TotalStudentAttendanceData tad:sat) {
			 MoodleCourseCategoriesResponse sat1 =new MoodleCourseCategoriesResponse();
		 if(courseid==0L && percentage==0D) {		 
			 sat1.setAttendance(tad.getAttendance());
			 sat1.setCoursecode(tad.getCoursecode());
			 sat1.setCoursename(tad.getCoursename());
			 sat1.setFirstname(tad.getFirstname());
			 sat1.setUsername(tad.getUsername());
			 sat1.setLastname(tad.getLastname());
			 sat1.setId(tad.getId());
			 sat1.setPercentage(tad.getPercentage());
			 sat1.setSlot(tad.getSlot());
			 sat1.setPercentageassigned(0D);
			 sat1.setPercentagedifference(tad.getPercentage());
			 totalStudentAttendanceData.add(sat1);
		 		 }else if(courseid==0D && percentage !=0D){	 			
		 				if(percentage>tad.getPercentage()) {
		 				 sat1.setAttendance(tad.getAttendance());
		 				 sat1.setCoursecode(tad.getCoursecode());
		 				 sat1.setCoursename(tad.getCoursename());
		 				 sat1.setFirstname(tad.getFirstname());
		 				 sat1.setUsername(tad.getUsername());
		 				 sat1.setLastname(tad.getLastname());
		 				 sat1.setId(tad.getId());
		 				 sat1.setPercentage(tad.getPercentage());
		 				 sat1.setSlot(tad.getSlot());
		 				 count= tad.getPercentage() - percentage;
		 				 sat1.setPercentageassigned(percentage);
		 				 sat1.setPercentagedifference(Math.round(count*100.0)/100.0);	
		 				 totalStudentAttendanceData.add(sat1);
		 				}else {
		 					sat1.setAttendance(tad.getAttendance());
			 				 sat1.setCoursecode(tad.getCoursecode());
			 				 sat1.setCoursename(tad.getCoursename());
			 				 sat1.setFirstname(tad.getFirstname());
			 				 sat1.setUsername(tad.getUsername());
			 				 sat1.setLastname(tad.getLastname());
			 				 sat1.setId(tad.getId());
			 				 sat1.setPercentage(tad.getPercentage());
			 				 sat1.setSlot(tad.getSlot());
			 				 count= tad.getPercentage() - percentage;
			 				 sat1.setPercentageassigned(percentage);
			 				 sat1.setPercentagedifference(Math.round(count*100.0)/100.0);
			 				 totalStudentAttendanceData.add(sat1);
		 				}
		 			 
					 
				 }else if(courseid !=0D && percentage==0D) {
					 
					 if( courseid==tad.getCourseid()) {
					 sat1.setAttendance(tad.getAttendance());
					 sat1.setCoursecode(tad.getCoursecode());
					 sat1.setCoursename(tad.getCoursename());
					 sat1.setFirstname(tad.getFirstname());
					 sat1.setUsername(tad.getUsername());
					 sat1.setLastname(tad.getLastname());
					 sat1.setId(tad.getId());
					 sat1.setPercentage(tad.getPercentage());
					 sat1.setSlot(tad.getSlot());
					 sat1.setPercentageassigned(0D);
					 sat1.setPercentagedifference(tad.getPercentage());
					 totalStudentAttendanceData.add(sat1);
				 }
					 
				 }
		 		 else {
		 			 
		 				if(percentage>tad.getPercentage() && courseid==tad.getCourseid()) {
		 				 sat1.setAttendance(tad.getAttendance());
		 				 sat1.setCoursecode(tad.getCoursecode());
		 				 sat1.setCoursename(tad.getCoursename());
		 				 sat1.setFirstname(tad.getFirstname());
		 				 sat1.setUsername(tad.getUsername());
		 				 sat1.setLastname(tad.getLastname());
		 				 sat1.setId(tad.getId());
		 				 sat1.setPercentage(tad.getPercentage());
		 				 sat1.setSlot(tad.getSlot());
		 				 count=tad.getPercentage()-percentage;
		 				 sat1.setPercentageassigned(percentage);
		 				 sat1.setPercentagedifference(Math.round(count*100.0)/100.0);
		 				totalStudentAttendanceData.add(sat1);
		 				}else {
		 					if( courseid==tad.getCourseid()) {
		 					sat1.setAttendance(tad.getAttendance());
			 				 sat1.setCoursecode(tad.getCoursecode());
			 				 sat1.setCoursename(tad.getCoursename());
			 				 sat1.setFirstname(tad.getFirstname());
			 				 sat1.setUsername(tad.getUsername());
			 				 sat1.setLastname(tad.getLastname());
			 				 sat1.setId(tad.getId());
			 				 sat1.setPercentage(tad.getPercentage());
			 				 sat1.setSlot(tad.getSlot());
			 				 count=tad.getPercentage()-percentage;
			 				 sat1.setPercentageassigned(percentage);
			 				 sat1.setPercentagedifference(Math.round(count*100.0)/100.0);
			 				totalStudentAttendanceData.add(sat1);
		 				}
		 			 }
		 			 }
		     
		 Collections.sort(totalStudentAttendanceData, new Comparator<MoodleCourseCategoriesResponse>(){
			  public int compare(MoodleCourseCategoriesResponse o1,MoodleCourseCategoriesResponse o2) {
				int c;
				c=o1.getId().compareTo(o2.getId());	 
				if(c==0)
					return o1.getCoursecode().compareTo(o2.getCoursecode());	
				return c;
		 }
		 });			
		 
		 }
		 
		 
		 }
		 
		 
	//	 userAttendanceReport.get(j).add(new MoodleCourseCategoriesResponse(totalStudentAttendanceData1.get(j).getId(),totalStudentAttendanceData1.get(j).getUsername(),totalStudentAttendanceData1.get(j).getFirstname(),totalStudentAttendanceData1.get(j).getLastname(),totalStudentAttendanceData1.get(j).getCoursename(),totalStudentAttendanceData1.get(j).getAttendance(),totalStudentAttendanceData1.get(j).getSlot(),totalStudentAttendanceData1.get(j).getPercentage(),totalStudentAttendanceData1.get(j).getCoursecode(),totalStudentAttendanceData1.get(j).getPercentagedifference(),totalStudentAttendanceData1.get(j).getPercentageassigned()));
		
		 for(int j=0;j<totalStudentAttendanceData.size();j++) {	
			MoodleUser currUser = MoodleUserRepo.findAllById(totalStudentAttendanceData.get(j).getId());
		 totalStudentAttendanceData1=totalStudentAttendanceData.stream().filter(tad ->tad.getId().equals(currUser.getId())).collect(Collectors.toList());
		 if(!userAttendanceReport.contains(totalStudentAttendanceData1)) {
		 userAttendanceReport.add(totalStudentAttendanceData1);
		 }
		}
		
		
		 
	return userAttendanceReport ;
}
}


