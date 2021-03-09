package sgsits.cse.dis.moodle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgsits.cse.dis.moodle.jwt.JwtResolver;
import sgsits.cse.dis.moodle.service.moodleAssignmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/assns")
public class MoodleAssignmentController {
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private moodleAssignmentService moodleAssignmentServiceImpl;
}
