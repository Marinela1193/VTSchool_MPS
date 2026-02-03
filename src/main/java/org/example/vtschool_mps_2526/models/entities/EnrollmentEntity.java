package org.example.vtschool_mps_2526.models.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "enrollments", schema = "_da_vtschool_2526")
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student", nullable = false)
    private StudentEntity studentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course", nullable = false)
    private CoursEntity course;

    @Column(name = "year", nullable = false)
    private Integer year;

    @OneToMany(mappedBy = "enrollment")
    private Set<ScoreEntity> scoreEntities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return studentEntity;
    }

    public void setStudent(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public CoursEntity getCourse() {
        return course;
    }

    public void setCourse(CoursEntity course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<ScoreEntity> getScores() {
        return scoreEntities;
    }

    public void setScores(Set<ScoreEntity> scoreEntities) {
        this.scoreEntities = scoreEntities;
    }

}