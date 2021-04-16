package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "panel_of_practical")
public class PanelOfPractical {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "internal_faculty_1", nullable = false)
    private String internalFaculty1;

    @Column(name = "internal_faculty_2")
    private String internalFaculty2;

    @Column(name = "external_faculty", nullable = false)
    private String externalFaculty;

    @Column(name = "lab_technician")
    private String labTechnician;

    @Column(name = "lab_assistant")
    private String labAssistant;

    public PanelOfPractical() {

    }

    public String getLabTechnician() {
        return labTechnician;
    }

    public void setLabTechnician(String labTechnician) {
        this.labTechnician = labTechnician;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setInternalFaculty1(String internalFaculty1) {
        this.internalFaculty1 = internalFaculty1;
    }

    public void setInternalFaculty2(String internalFaculty2) {
        this.internalFaculty2 = internalFaculty2;
    }

    public void setExternalFaculty(String externalFaculty) {
        this.externalFaculty = externalFaculty;
    }

    public void setLabAssistant(String labAssistant) {
        this.labAssistant = labAssistant;
    }

    public String getId() {
        return id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getInternalFaculty1() {
        return internalFaculty1;
    }

    public String getInternalFaculty2() {
        return internalFaculty2;
    }

    public String getExternalFaculty() {
        return externalFaculty;
    }

    public String getLabAssistant() {
        return labAssistant;
    }


    public PanelOfPractical(String id, String subjectCode, String subjectName, String internalFaculty1, String internalFaculty2, String externalFaculty, String labAssistant, String labTechnician) {
        this.id = id;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.internalFaculty1 = internalFaculty1;
        this.internalFaculty2 = internalFaculty2;
        this.externalFaculty = externalFaculty;
        this.labAssistant = labAssistant;
        this.labTechnician = labTechnician;
    }
}
