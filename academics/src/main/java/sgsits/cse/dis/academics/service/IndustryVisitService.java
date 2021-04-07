package sgsits.cse.dis.academics.service;

import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;

import java.io.IOException;
import java.util.List;

public interface IndustryVisitService {

    String addIndustryVisit(IndustryVisitForm industryVisitForm);

    List<IndustryVisitResponse> getIndustryVisits(String status);

    IndustryVisit viewIndustryVisitDetails(String industryVisitId);

    List<IndustryVisitResponse> searchIndustryVisits(String status, String keyword);

    String updateIndustryVisitStatus(String industryVisitId, MultipartFile file) throws IOException;

    String editIndustryVisit(IndustryVisit industryVisit);

    String deleteIndustryVisit(String industryVisitId);

    IndustryVisit downloadNotesheet(String industryVisitId);

    IndustryVisit downloadAttendance(String industryVisitId);
}
