package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.repo.IndustryVisitRepository;
import sgsits.cse.dis.academics.request.IndustryVisitForm;
import sgsits.cse.dis.academics.response.IndustryVisitResponse;
import sgsits.cse.dis.academics.service.IndustryVisitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class IndustryVisitServiceImpl implements IndustryVisitService {

    @Autowired
    private IndustryVisitRepository industryVisitRepository;

    @Override
    public String addIndustryVisit(IndustryVisitForm industryVisitForm) {
        IndustryVisit industryVisit = new IndustryVisit();
        industryVisit.setAddress(industryVisitForm.getAddress());
        industryVisit.setParticipants(industryVisitForm.getParticipants());
        industryVisit.setCity(industryVisitForm.getCity());
        industryVisit.setCompanyName(industryVisitForm.getCompanyName());
        industryVisit.setCoordinator1(industryVisitForm.getCoordinator1());
        industryVisit.setCoordinator2(industryVisitForm.getCoordinator2());
        industryVisit.setDate(industryVisitForm.getDate());
        industryVisit.setPin(industryVisitForm.getPin());
        industryVisit.setState(industryVisitForm.getState());
        industryVisit.setTime(industryVisitForm.getTime());
        industryVisit.setStatus("Pending");

        IndustryVisit test = industryVisitRepository.save(industryVisit);

        if(test!=null)
            return "Visit to "+test.getCompanyName()+" on "+test.getDate()+" at "+test.getTime()+" for "+test.getParticipants()+" created.";
        else
            return "Could not create industry visit, please try again.";

    }

    @Override
    public List<IndustryVisitResponse> getIndustryVisits(String status) {
        List<IndustryVisit> visits = industryVisitRepository.findByStatus(status);
        List<IndustryVisitResponse> output = new ArrayList<IndustryVisitResponse>();
        for(IndustryVisit visit : visits)
        {
            IndustryVisitResponse visitObj = new IndustryVisitResponse();
            visitObj.setIndustryVisitId(visit.getIndustryVisitId());
            visitObj.setDate(visit.getDate());
            visitObj.setTime(visit.getTime());
            visitObj.setCompanyName(visit.getCompanyName());
            visitObj.setParticipants(visit.getParticipants());
            visitObj.setCoordinator1(visit.getCoordinator1());
            visitObj.setCoordinator2(visit.getCoordinator2());
            output.add(visitObj);
        }
        return output;
    }

    @Override
    public IndustryVisit viewIndustryVisitDetails(String industryVisitId) {
        return industryVisitRepository.findByIndustryVisitId(industryVisitId);
    }

    @Override
    public List<IndustryVisitResponse> searchIndustryVisits(String status, String keyword) {
        List<IndustryVisit> industryVisits = industryVisitRepository.findByCompanyNameContainingIgnoreCaseAndStatus(keyword,status);
        List<IndustryVisitResponse> output = new ArrayList<IndustryVisitResponse>();
        for(IndustryVisit industryVisit : industryVisits)
        {
            IndustryVisitResponse industryVisitResponse = new IndustryVisitResponse();
            industryVisitResponse.setIndustryVisitId(industryVisit.getIndustryVisitId());
            industryVisitResponse.setParticipants(industryVisit.getParticipants());
            industryVisitResponse.setDate(industryVisit.getDate());
            industryVisitResponse.setTime(industryVisit.getTime());
            industryVisitResponse.setCompanyName(industryVisit.getCompanyName());
            industryVisitResponse.setCoordinator1(industryVisit.getCoordinator1());
            industryVisitResponse.setCoordinator2(industryVisit.getCoordinator2());
            output.add(industryVisitResponse);
        }
        return output;
    }

    @Override
    public String updateIndustryVisitStatus(String industryVisitId, MultipartFile file) throws IOException {
        IndustryVisit industryVisit = industryVisitRepository.findByIndustryVisitId(industryVisitId);
        String currentStatus = industryVisit.getStatus();
        if (currentStatus.equals("Pending")) {
            industryVisit.setStatus("Upcoming");
            industryVisit.setNotesheetFileType(file.getContentType());
            industryVisit.setNotesheet(file.getBytes());
        } else if (currentStatus.equals("Upcoming")) {
            industryVisit.setStatus("Completed");
            industryVisit.setAttendanceFileType(file.getContentType());
            industryVisit.setAttendance(file.getBytes());
        } else
            return "Already completed, cannot update status.";

        IndustryVisit test = industryVisitRepository.save(industryVisit);
        if (test != null) {
            if (currentStatus.equals("Pending"))
                return "Note-sheet uploaded successfully. Status Updated.";
            else
                return "Attendance uploaded successfully. Status Updated.";
        } else
            return "Error updating status, please try again.";
    }

    @Override
    public String editIndustryVisit(IndustryVisit industryVisit) {
        if(industryVisit.getStatus().equals("Completed"))
            return "Cannot edit details of a completed visit.";
        IndustryVisit test = industryVisitRepository.save(industryVisit);
        if(test!=null)
            return "Details updated successfully!";
        else
            return "Could not update visit details, please try again.";
    }

    @Override
    public String deleteIndustryVisit(String industryVisitId) {
        IndustryVisit industryVisit = industryVisitRepository.findByIndustryVisitId(industryVisitId);
        if(industryVisit.getStatus().equals("Completed"))
            return "Cannot delete a completed industry visit.";
        industryVisitRepository.delete(industryVisit);
        return "Industry visit deleted from the records successfully.";
    }

    @Override
    public IndustryVisit downloadNotesheet(String industryVisitId) {
        return industryVisitRepository.findByIndustryVisitId(industryVisitId);
    }

    @Override
    public IndustryVisit downloadAttendance(String industryVisitId) {
        return industryVisitRepository.findByIndustryVisitId(industryVisitId);
    }
}
