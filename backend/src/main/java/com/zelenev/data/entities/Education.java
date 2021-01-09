package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

@Entity(name = "Education")
@Table(
        name = "education",
        schema = "public"
)
public class Education implements Serializable {

    @Id
    @SequenceGenerator(
            name = "education_sequence",
            sequenceName = "education_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "education_sequence"

    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "university",
            nullable = false,
            length = 150
    )
    private String university;

    @Column(
            name = "faculty",
            nullable = false,
            length = 150
    )
    private String faculty;

    @Column(
            name = "degree",
            nullable = false,
            length = 25
    )
    private String degree;

    @Column(
            name = "date_attended_from",
            nullable = false
    )
    @Temporal(DATE)
    private Date dateAttendedFrom;

    @Column(
            name = "date_attended_to",
            nullable = false
    )
    @Temporal(DATE)
    private Date dateAttendedTo;

    public Education() {
    }

    public Education(String university,
                     String faculty,
                     String degree,
                     Date dateAttendedFrom,
                     Date dateAttendedTo) {
        this.university = university;
        this.faculty = faculty;
        this.degree = degree;
        this.dateAttendedFrom = dateAttendedFrom;
        this.dateAttendedTo = dateAttendedTo;
    }

    public Education(Integer id,
                     String university,
                     String faculty,
                     String degree,
                     Date dateAttendedFrom,
                     Date dateAttendedTo) {
        this.id = id;
        this.university = university;
        this.faculty = faculty;
        this.degree = degree;
        this.dateAttendedFrom = dateAttendedFrom;
        this.dateAttendedTo = dateAttendedTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDateAttendedFrom() {
        return dateAttendedFrom;
    }

    public void setDateAttendedFrom(Date dateAttendedFrom) {
        this.dateAttendedFrom = dateAttendedFrom;
    }

    public Date getDateAttendedTo() {
        return dateAttendedTo;
    }

    public void setDateAttendedTo(Date dateAttendedTo) {
        this.dateAttendedTo = dateAttendedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return id.equals(education.id) && university.equals(education.university) && faculty.equals(education.faculty) && degree.equals(education.degree) && dateAttendedFrom.equals(education.dateAttendedFrom) && dateAttendedTo.equals(education.dateAttendedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, university, faculty, degree, dateAttendedFrom, dateAttendedTo);
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", degree='" + degree + '\'' +
                ", dateAttendedFrom=" + dateAttendedFrom +
                ", dateAttendedTo=" + dateAttendedTo +
                '}';
    }
}
