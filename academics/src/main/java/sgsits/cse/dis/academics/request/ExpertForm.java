package sgsits.cse.dis.academics.request;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpertForm {
	
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Designation cannot be empty")
	private String designation;
	
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	@NotBlank(message = "Mobile no. cannot be empty")
	private long mobileNo;
	
	private String dob;
	
	private String fathersName;
	
	private String officeAddress;
	
	private long pinCode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private long aadhaarNo;
	
	private String panNo;
	
	private String gstNo;
	
	private String bankName;
	
	private long accountNo;
	
	private String ifsc;
	
	private long uniqueTeqipId;
	
	private String type;

}
