package sgsits.cse.dis.user.model;

import java.io.Serializable;

import javax.persistence.Column;

public class PanelOfTheoryId implements Serializable {
    
    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "year")
    private String year;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public PanelOfTheoryId(String subjectCode, String year) {
        this.subjectCode = subjectCode;
        this.year = year;
    }

    public PanelOfTheoryId() {
    }
}