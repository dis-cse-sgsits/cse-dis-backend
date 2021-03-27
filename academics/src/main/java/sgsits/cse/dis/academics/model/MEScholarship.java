package sgsits.cse.dis.academics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "me_scholarship")
public class MEScholarship {

    @Id
    @Column(name = "enrollment", nullable = false)
    private String enrollment;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "admission_year", nullable = false)
    private long admissionYear;

    @Column(name = "year", nullable = false)
    private int year;

}
