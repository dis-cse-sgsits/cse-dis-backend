package sgsits.cse.dis.user.model;

import java.io.Serializable;

public class PanelOfTheoryId implements Serializable {
    
    private String subjectCode;

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
