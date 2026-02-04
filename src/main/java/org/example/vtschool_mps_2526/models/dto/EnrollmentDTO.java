package org.example.vtschool_mps_2526.models.dto;

import java.util.Set;

public class EnrollmentDTO {
    private Integer id;
    private StudentsDTO students;
    private CoursDTO course;
    private Integer year;
    private Set<ScoreDTO> scores;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Integer id, StudentsDTO students, CoursDTO course, Integer year, Set<ScoreDTO> scores) {
        this.id = id;
        this.students = students;
        this.course = course;
        this.year = year;
        this.scores = scores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentsDTO getStudents() {
        return students;
    }

    public void setStudents(StudentsDTO students) {
        this.students = students;
    }

    public CoursDTO getCourse() {
        return course;
    }

    public void setCourse(CoursDTO course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<ScoreDTO> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreDTO> scores) {
        this.scores = scores;
    }
}
