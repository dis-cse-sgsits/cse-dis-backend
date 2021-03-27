package sgsits.cse.dis.academics.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class AddExpertLectureForm {

	@NotBlank(message="Topic cannot be empty")
	public String topic;
	
	@NotBlank(message="Expert name cannot be null")
	public String expertName;
	
	public String expertDesignation;
	
	public String date;
	
	public String time;
	
	public String venue;
	
	public String audience;
	
	public long conveyance;
	
	public long honorarium;

	public String coordinator;
	
	
}
