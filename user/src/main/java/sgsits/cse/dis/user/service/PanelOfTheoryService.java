package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreatePanelOfTheoryForm;
import sgsits.cse.dis.user.model.PanelOfTheory;

@Component
public interface PanelOfTheoryService {
    
    String createPanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException;
    List<PanelOfTheory> getAllPanelOfTheory();
    String updatePanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException;
}
