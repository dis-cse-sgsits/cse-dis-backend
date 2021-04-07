package sgsits.cse.dis.academics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "industry_visit")
public class IndustryVisit {

    @Id
    @Column(name = "industry_visit_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String industryVisitId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin")
    private long pin;

    @Column(name = "participants", nullable = false)
    private String participants;

    @Column(name = "coordinator_1", nullable = false)
    private String coordinator1;

    @Column(name = "coordinator_2")
    private String coordinator2;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_expenditure")
    private String totalExpenditure;

    @Column(name = "attendance")
    private byte[] attendance;

    @Column(name = "notesheet")
    private byte[] notesheet;

    @Column(name = "attendance_file_type")
    private String attendanceFileType;

    @Column(name = "notesheet_file_type")
    private String notesheetFileType;

}
