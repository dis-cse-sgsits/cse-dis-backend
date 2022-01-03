package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.response.BatchData;
import sgsits.cse.dis.user.message.response.SideNavigationData;
import sgsits.cse.dis.user.service.GuideAllotmentService;
import sgsits.cse.dis.user.service.SideNavigationService;

@CrossOrigin(origins = "*")
@Api(value = "Side Navigation Controller")
@RestController
@RequestMapping(path = "/sideNavigation")
public class SideNavigationController {
	
	private JwtResolver jwtResolver = new JwtResolver();
	@Autowired
	private SideNavigationService sideNavigationService;
	
	@ApiOperation(value = "Get Side Navigation Details", response = SideNavigationData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_SIDE_NAVIGATION_DETAILS, produces = "application/json")
	public ResponseEntity<SideNavigationData> getSideNavigationDetails(HttpServletRequest request) {
		String username = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		return new ResponseEntity<SideNavigationData>(sideNavigationService.getSideNavigationDetails(username),HttpStatus.OK);
	}
}
