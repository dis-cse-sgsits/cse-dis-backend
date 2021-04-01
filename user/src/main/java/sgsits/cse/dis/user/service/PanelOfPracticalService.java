package sgsits.cse.dis.user.service;

import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.exception.InternalServerError;

public interface PanelOfPracticalService{

    void addPanelOfPractical(PanelOfPracticalDto panelOfPracticalDto) throws InternalServerError;
}
