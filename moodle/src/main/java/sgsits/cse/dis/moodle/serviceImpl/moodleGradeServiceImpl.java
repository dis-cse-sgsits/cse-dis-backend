package sgsits.cse.dis.moodle.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.moodle.model.MoodleCourse;
import sgsits.cse.dis.moodle.model.MoodleGradeGrades;
import sgsits.cse.dis.moodle.model.MoodleGradeItems;
import sgsits.cse.dis.moodle.model.MoodleUser;
import sgsits.cse.dis.moodle.repo.MoodleCourseRepo;
import sgsits.cse.dis.moodle.repo.MoodleGradeGradesRepo;
import sgsits.cse.dis.moodle.repo.MoodleGradeItemsRepo;
import sgsits.cse.dis.moodle.repo.MoodleUserRepo;
import sgsits.cse.dis.moodle.response.GradeItemsData;
import sgsits.cse.dis.moodle.response.GraderReportData;
import sgsits.cse.dis.moodle.service.moodleGradeService;

@Component
public class moodleGradeServiceImpl implements moodleGradeService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MoodleGradeItemsRepo moodleGradeItemsRepo;
	@Autowired
	private MoodleCourseRepo moodleCourseRepo;
	@Autowired
	private MoodleGradeGradesRepo moodleGradeGradesRepo;
	@Autowired
	private MoodleUserRepo moodleUserRepo;
	
	@Override
	public List<GradeItemsData> getGradeItemsOfCourse(String courseId) {
		List<GradeItemsData> gradeItems = new ArrayList<GradeItemsData>();
		
		List<MoodleGradeItems> gradeItemsDetailed = new ArrayList<MoodleGradeItems>();
		Long courseIdL = Long.parseLong(courseId);
		gradeItemsDetailed = moodleGradeItemsRepo.findByCourseid(courseIdL);
		for (MoodleGradeItems gradeItem : gradeItemsDetailed) {
			gradeItems.add(new GradeItemsData(gradeItem.getId(), gradeItem.getCourseid(), gradeItem.getItemname()));
		}
		
		return gradeItems;
	}
	
	@Override
	public List<List<GraderReportData>> getGraderReport(String courseId, String itemId) {
		List<List<GraderReportData>> graderReport = new ArrayList<List<GraderReportData>>();
		
		Long courseIdL = Long.parseLong(courseId);
		Long itemIdL = Long.parseLong(itemId);
		
		// List for taking courseCode and courseName
		List<MoodleCourse> courseDetails = moodleCourseRepo.findAllById(courseIdL);
		
		List<MoodleGradeItems> gradeItemsDetailed = new ArrayList<MoodleGradeItems>();
		
		if (itemIdL == 0L) {
			gradeItemsDetailed = moodleGradeItemsRepo.findByCourseid(courseIdL);
		}
		else {
			gradeItemsDetailed = moodleGradeItemsRepo.findByIdAndCourseid(itemIdL, courseIdL);
		}
		
		for (MoodleGradeItems gradeItem : gradeItemsDetailed) {
			List<MoodleGradeGrades> gradeGradesDetails = moodleGradeGradesRepo.findByItemid(gradeItem.getId());
			
			// initializing 2d empty list of lists for entering final data if empty
			if (graderReport.isEmpty()) {
				for (int i=0; i<gradeGradesDetails.size(); i++) {
					graderReport.add(new ArrayList<GraderReportData>());
				}
			}
			
			for (int i=0; i<gradeGradesDetails.size(); i++) {
				MoodleUser currUser = moodleUserRepo.findAllById(gradeGradesDetails.get(i).getUserid());
				
				Double finalGrade = gradeGradesDetails.get(i).getFinalgrade();
				Double totalGrade = gradeGradesDetails.get(i).getRawgrademax();
				Double percentage = null;
				if (finalGrade != null) {
					percentage = (finalGrade/totalGrade) * 100;
				}
				graderReport.get(i).add(new GraderReportData(currUser.getId(),
																currUser.getFirstname(),
																currUser.getLastname(),
																courseDetails.get(0).getShortname(),
																courseDetails.get(0).getFullname(),
																gradeItem.getItemname(),
																finalGrade,
																totalGrade,
																percentage));
		    }
			
			
		}
		
		return graderReport;
	}
	
	@Override
	public List<List<GraderReportData>> getUserReport(String courseId, String userId) {
		List<List<GraderReportData>> userReport = new ArrayList<List<GraderReportData>>();
		List<List<GraderReportData>> tempUserReport = new ArrayList<List<GraderReportData>>();
		
		Long courseIdL = Long.parseLong(courseId);
		Long userIdL = Long.parseLong(userId);
		
		tempUserReport = getGraderReport(courseId, "0");
		
		if (userIdL == 0) {
			userReport = tempUserReport;
		}
		else {
			for (List<GraderReportData> item : tempUserReport) {
				if (item.get(0).getUserId() == userIdL) {
					userReport.add(item);
					break;
				}
			}
		}
		
		
		return userReport;
	}

}
