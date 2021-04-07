package sgsits.cse.dis.academics.service;

import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.response.*;

import java.io.IOException;
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

	List<ExpertLecturesResponse> searchExpertLectures(String keyword, String status);

	String updateExpertLectureStatus(String expertLectureId, MultipartFile file) throws IOException;


    String deleteExpert(String expertId);

    String editExpertLecture(ExpertLectureDetails expertLectureDetails);

	String deleteExpertLecture(String expertLectureId);

	ExpertLectureDetails downloadNotesheet(String expertLectureId);

	ExpertLectureDetails downloadAttendance(String expertLectureId);
}
