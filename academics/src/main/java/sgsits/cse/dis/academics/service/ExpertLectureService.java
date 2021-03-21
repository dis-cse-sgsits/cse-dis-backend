package sgsits.cse.dis.academics.service;

import sgsits.cse.dis.academics.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import sgsits.cse.dis.academics.model.ExpertDetails;
import sgsits.cse.dis.academics.model.ExpertLectureDetails;
import sgsits.cse.dis.academics.request.ExpertForm;
import sgsits.cse.dis.academics.request.AddExpertLectureForm;

public interface ExpertLectureService {
	
	String addExpert(ExpertForm addExpertForm);

	String editExpert(ExpertForm editExpertForm);
	
	String addExpertLecture(AddExpertLectureForm addExpertLectureForm);
	
	List<ExpertLecturesResponse> getExpertLecturesByStatus(String status);
	
	ExpertLectureDetails viewExpertLectureDetails(String expertLectureId);

	List<ExpertNamesAndDesignationsResponse> getExpertNamesAndDesignations();

	ExpertDetails findExpert(String name, String designation);

	List<ExpertLecturesResponse> searchExpertLectures(String keyword);

	String updateExpertLectureStatus(String expertLectureId);

	
}
