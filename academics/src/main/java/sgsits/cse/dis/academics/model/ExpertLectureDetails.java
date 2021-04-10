package sgsits.cse.dis.academics.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@Table(name = "expert_lecture_details")
public class ExpertLectureDetails {
	
//	@Column(name = "created_by")
//	private String createdBy;
//	
//	@Column(name = "created_date")
//	private String createdDate;
//	
//	@Column(name = "modified_by")
//	private String modifiedBy;
//	
//	@Column(name = "modified_date")
//	private String modifiedDate;
	
	@Id
	@Column(name = "expert_lecture_id", nullable = false)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String expertLectureId;
	
	@Column(name = "topic", nullable = false)
	private String topic;
	
	@Column(name = "expert_name", nullable = false)
	private String expertName;
	
	@Column(name = "expert_designation", nullable = false)
	private String expertDesignation;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@Column(name = "time", nullable = false)
	private String time;
	
	@Column(name = "venue", nullable = false)
	private String venue;

	@Column(name = "audience", nullable = false)
	private String audience;

	@Column(name = "honorarium")
	private long honorarium;
	
	@Column(name = "conveyance")
	private long conveyance;
	
	@Column(name = "total_amount")
	private long totalAmount;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "payment_status")
	private String paymentStatus;

	@Lob
	@Column(name = "attendance")
	private byte[] attendance;

	@Column(name = "attendance_file_type")
	private String attendanceFileType;

	@Lob
	@Column(name = "notesheet")
	private byte[] notesheet;

	@Column(name = "notesheet_file_type")
	private String notesheetFileType;

	@Column(name = "coordinator", nullable = false)
	private String coordinator;

	@Column(name = "notesheet_extension")
	private String notesheetExtension;

	@Column(name = "attendance_extension")
	private String attendanceExtension;

}
	