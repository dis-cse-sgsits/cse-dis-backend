package sgsits.cse.dis.academics.service;

import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;

import java.util.List;

public interface IndustryVisitService {

    String addIndustryVisit(IndustryVisitForm industryVisitForm);

    List<IndustryVisitResponse> getIndustryVisits(String status);

    IndustryVisit viewIndustryVisitDetails(IndustryVisitResponse industryVisitResponse);

    List<IndustryVisitResponse> searchIndustryVisits(String status, String keyword);

    String updateIndustryVisitStatus(IndustryVisitResponse industryVisitResponse);

    String editIndustryVisit(IndustryVisit industryVisit);

    String deleteIndustryVisit(IndustryVisit industryVisit);
}
