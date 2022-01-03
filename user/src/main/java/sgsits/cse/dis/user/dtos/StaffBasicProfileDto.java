package sgsits.cse.dis.user.dtos;

import java.util.Date;

public class StaffBasicProfileDto {


    private String createdBy;
    private String createdDate;
    private String id;
    private String userId;

    private String employeeId;
    private String name;
    private String nameAcronym;
    private String currentDesignation;
    private String classs;
    private String type;
    private String email;
    private Date dob;
    private String panNumber;
    private String aadharNumber;
    private String bloodGroup;
    private String gender;
    private String motherName;
    private String fatherName;
    private long mobileNo;
    private Long alternateMobileNo;
    private Date joiningDate;
    private String areaOfSpecialization;

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public void setNameAcronym(final String nameAcronym) {
        this.nameAcronym = nameAcronym;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(final String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(final Date dob) {
        this.dob = dob;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(final String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(final String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(final String fatherName) {
        this.fatherName = fatherName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(final Long alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public String getAreaOfSpecialization() {
        return areaOfSpecialization;
    }

    public void setAreaOfSpecialization(final String areaOfSpecialization) {
        this.areaOfSpecialization = areaOfSpecialization;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }


}
