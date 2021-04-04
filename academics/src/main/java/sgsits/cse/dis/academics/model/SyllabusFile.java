package sgsits.cse.dis.academics.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "syllabus_file")
public class SyllabusFile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "course")
    private String course;

    @Column(name = "semester")
    private String semester;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public SyllabusFile() {}

    public SyllabusFile(String fileName, String fileType, String course, String semester, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.course = course;
        this.semester = semester;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
