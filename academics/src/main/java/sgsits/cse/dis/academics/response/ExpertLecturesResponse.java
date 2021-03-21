package sgsits.cse.dis.academics.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpertLecturesResponse {
	
	public String expertLectureId;
	
	public String topic;
	
	public String date;
	
	public String time;
	
	public String expertName;
	
	public String expertDesignation;
	
	public String audience;
	
	public String status;

}
