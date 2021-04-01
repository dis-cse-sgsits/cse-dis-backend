package sgsits.cse.dis.user.serviceImpl;

import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.components.StudentProfileRepo;
import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.PanelOfPractical;
import sgsits.cse.dis.user.repo.PanelOfPracticalRepository;
import sgsits.cse.dis.user.service.PanelOfPracticalService;

@Component
public class PanelOfPracticalServiceImpl implements PanelOfPracticalService {

    private final PanelOfPracticalRepository panelOfPracticalRepository;

    public PanelOfPracticalServiceImpl(PanelOfPracticalRepository panelOfPracticalRepository) {
        this.panelOfPracticalRepository = panelOfPracticalRepository;
    }

    @Override
    public void addPanelOfPractical(PanelOfPracticalDto panelOfPracticalDto) throws InternalServerError {

        try {
            PanelOfPractical panelOfPractical = new PanelOfPractical();
            panelOfPractical.setId(panelOfPracticalDto.getId());
            panelOfPractical.setInternalFaculty1(panelOfPracticalDto.getInternalFaculty1());
            panelOfPractical.setInternalFaculty2(panelOfPracticalDto.getInternalFaculty2());
            panelOfPractical.setExternalFaculty(panelOfPracticalDto.getExternalFaculty());
            panelOfPractical.setSubjectCode(panelOfPracticalDto.getSubjectCode());
            panelOfPractical.setSubjectName(panelOfPracticalDto.getSubjectName());
            panelOfPractical.setLabAssistant(panelOfPracticalDto.getLabAssistant());

            panelOfPracticalRepository.save(panelOfPractical);
        } catch(Exception e){
            System.out.println(e);
            throw new InternalServerError("Cannot add Panel of Practical");
        }

    }
}
