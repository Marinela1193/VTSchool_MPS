package org.example.vtschool_mps_2526.models.dto;

public class ScoreDTO {
    private Integer id;
    private EnrollmentDTO enrollment;
    private SubjectDTO subject;
    private Integer score;

    public ScoreDTO() {
    }

    public ScoreDTO(Integer id, EnrollmentDTO enrollment, SubjectDTO subject, Integer score) {
        this.id = id;
        this.enrollment = enrollment;
        this.subject = subject;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnrollmentDTO getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(EnrollmentDTO enrollment) {
        this.enrollment = enrollment;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
