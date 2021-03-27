package sgsits.cse.dis.academics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "attendance")
	private String attendance;
	
	@Column(name = "notesheet")
	private String notesheet;

	@Column(name = "coordinator", nullable = false)
	private String coordinator;

}
	