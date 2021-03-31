package sgsits.cse.dis.user.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreatePanelOfTheoryForm;
import sgsits.cse.dis.user.model.PanelOfTheory;
import sgsits.cse.dis.user.repo.PanelOfTheoryRepository;
import sgsits.cse.dis.user.service.PanelOfTheoryService;

@Component
public class PanelofTheoryServicesImpl implements PanelOfTheoryService {

    @Autowired
    PanelOfTheoryRepository panelOfTheoryRepository;

    @Override
    public String createPanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException {
        PanelOfTheory panelOfTheory = new PanelOfTheory();
        panelOfTheory.setCourse(createPanelOfTheoryForm.getCourse());
        panelOfTheory.setSubjectCode(createPanelOfTheoryForm.getSubjectCode());
        panelOfTheory.setFaculties(createPanelOfTheoryForm.getFaculties());
        panelOfTheory.setSubjectName(createPanelOfTheoryForm.getSubjectName());
        PanelOfTheory test =panelOfTheoryRepository.save(panelOfTheory);
        if(test.equals(null))
					throw new ConflictException("Unable to create panel.");
        return "Created panel successfully.";
    }

    @Override
    public List<PanelOfTheory> getAllPanelOfTheory() {
        return panelOfTheoryRepository.findAll();
    }

    public String updatePanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException {
        if(! panelOfTheoryRepository.existsBySubjectCode(createPanelOfTheoryForm.getSubjectCode()) )
            throw new ConflictException("The given Panel does not exist.");

        PanelOfTheory panelOfTheory = new PanelOfTheory();
        panelOfTheory.setCourse(createPanelOfTheoryForm.getCourse());
        panelOfTheory.setSubjectCode(createPanelOfTheoryForm.getSubjectCode());
        panelOfTheory.setFaculties(createPanelOfTheoryForm.getFaculties());
        panelOfTheory.setSubjectName(createPanelOfTheoryForm.getSubjectName());
        PanelOfTheory test =panelOfTheoryRepository.save(panelOfTheory);
        if(test.equals(null))
					throw new ConflictException("Unable to update panel.");
    
        return "Updated successfully";
        
    }

    @Override
    public void deletePanelOfTheory(String subjectCode) throws ConflictException {
        if(panelOfTheoryRepository.deleteBySubjectCode(subjectCode)<=0)
            throw new ConflictException("Cannot delete panel");
        
    }
    
}
