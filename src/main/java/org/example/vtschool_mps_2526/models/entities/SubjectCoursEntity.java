package org.example.vtschool_mps_2526.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "subject_courses", schema = "_da_vtschool_2526")
public class SubjectCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_courses_id_gen")
    @SequenceGenerator(name = "subject_courses_id_gen", sequenceName = "subject_courses_code_seq", allocationSize = 1)
    @Column(name = "code", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subjectEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private CoursEntity course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubjectEntity getSubject() {
        return subjectEntity;
    }

    public void setSubject(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public CoursEntity getCourse() {
        return course;
    }

    public void setCourse(CoursEntity course) {
        this.course = course;
    }

}