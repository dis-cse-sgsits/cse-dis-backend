package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreatePanelOfTheoryForm;
import sgsits.cse.dis.user.model.PanelOfTheory;
import sgsits.cse.dis.user.serviceImpl.PanelofTheoryServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/panel")
public class PanelOfTheoryController {

    @Autowired
    private PanelofTheoryServicesImpl panelofTheoryServicesImpl;

    @ApiOperation(value = "get all panel of theory",response = PanelOfTheory.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(path = "/getPanelOfTheory", produces = "application/json")
    public ResponseEntity<List<PanelOfTheory>> getPanelOfTheory()
    {
        return new ResponseEntity<List<PanelOfTheory>>(panelofTheoryServicesImpl.getAllPanelOfTheory(), HttpStatus.OK);
    }

    @ApiOperation(value = "create panel of theory",response = String.class, httpMethod = "POST", produces = "text/plain")
    @PostMapping(path ="/createPanelOfTheory", produces = "text/plain")
    public ResponseEntity<String> createPanelOfTheory(@Valid @RequestBody CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException
    {
        return new ResponseEntity<String>(panelofTheoryServicesImpl.createPanelOfTheory(createPanelOfTheoryForm), HttpStatus.OK);
    }

    @ApiOperation(value = "create panel of theory",response = String.class, httpMethod = "POST", produces = "text/plain")
    @PutMapping(path = "/updatePanelOfTheory", produces = "text/plain")
    public ResponseEntity<String> updatePanelOfTheory(@Valid @RequestBody CreatePanelOfTheoryForm createPanelOfTheoryForm) throws ConflictException
    {
        return new ResponseEntity<String>(panelofTheoryServicesImpl.updatePanelOfTheory(createPanelOfTheoryForm), HttpStatus.OK);
    }
}
