package org.example.vtschool_mps_2526.models.dto;

public class SubjectCoursDTO {
    private Integer id;
    private SubjectDTO subject;
    private CoursDTO course;

    public SubjectCoursDTO() {
    }

    public SubjectCoursDTO(Integer id, SubjectDTO subject, CoursDTO course) {
        this.id = id;
        this.subject = subject;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public CoursDTO getCourse() {
        return course;
    }

    public void setCourse(CoursDTO course) {
        this.course = course;
    }
}
