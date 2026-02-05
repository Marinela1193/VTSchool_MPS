package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dao.EnrollmentDAO;
import org.example.vtschool_mps_2526.models.dto.EnrollmentDTO;
import org.example.vtschool_mps_2526.models.entities.CourseEntity;
import org.example.vtschool_mps_2526.models.entities.EnrollmentEntity;
import org.example.vtschool_mps_2526.models.entities.ScoreEntity;
import org.example.vtschool_mps_2526.models.entities.StudentEntity;
import org.example.vtschool_mps_2526.service.serviceCourse;
import org.example.vtschool_mps_2526.service.serviceEnrollment;
import org.example.vtschool_mps_2526.service.serviceScore;
import org.example.vtschool_mps_2526.service.serviceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
class enrollmentController {

    @Autowired
    serviceEnrollment serviceEnrollment;

    @Autowired
    serviceStudent serviceStudent;
    @Autowired
    serviceScore serviceScore;
    @Autowired
    serviceCourse serviceCourse;
    @Autowired
    EnrollmentDAO enrollmentDAO;

    @GetMapping("/enrollments")
    public ResponseEntity<?> getEnrollments() {
        return ResponseEntity.ok(enrollmentDAO.findAll());
    }

    @GetMapping("/enrollments/{id}")
    public ResponseEntity<?> getEnrollmentById(@Validated @PathVariable("id") int id) {
        EnrollmentEntity enrollment = serviceEnrollment.getEnrollmentById(id);
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping("/crearEnrollment")
    public ResponseEntity<?> createEnrollment(@Validated @RequestBody EnrollmentDTO enrollmentDTO) {

        Optional<EnrollmentEntity> optional = enrollmentDAO.findById(enrollmentDTO.getId());
        if(optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        EnrollmentEntity enrollment = new EnrollmentEntity();
        enrollment.setId(enrollmentDTO.getId());
        enrollment.setYear(enrollmentDTO.getYear());

        StudentEntity student = serviceStudent.getStudentById(enrollmentDTO.getStudent().getIdcard());
        enrollment.setStudent(student);

        CourseEntity course = serviceCourse.getCourseById(enrollmentDTO.getCourse().getId());
        enrollment.setCourse(course);

        /*ScoreEntity score = serviceScore.getScoresById(enrollmentDTO.getId());
        enrollment.setScores(score);*/

        serviceEnrollment.save(enrollment);
        return ResponseEntity.ok(enrollment);
    }

    @PutMapping("/ActualizarEnrollment")
    public ResponseEntity<?>  updateEnrollment(@Validated @RequestBody EnrollmentDTO enrollmentDTO) {
        Optional<EnrollmentEntity> optional = enrollmentDAO.findById(enrollmentDTO.getId());
        if(optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<EnrollmentEntity> enrolment = enrollmentDAO.findById(enrollmentDTO.getId());
        if(enrolment.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        EnrollmentEntity enrollment = new EnrollmentEntity();
        enrollment.setId(enrollmentDTO.getId());
        enrollment.setYear(enrollmentDTO.getYear());

        StudentEntity student = serviceStudent.getStudentById(enrollmentDTO.getStudent().getIdcard());
        enrollment.setStudent(student);

        CourseEntity course = serviceCourse.getCourseById(enrollmentDTO.getCourse().getId());
        enrollment.setCourse(course);

       /* ScoreEntity score = serviceScore.getScoresById(enrollmentDTO.getScores().getClass());
        enrollment.setScores(score);//crear metodo para devolver todas las notas de un alumno*/

        serviceEnrollment.update(enrollment);
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping("/EliminarEnrollment")
    public ResponseEntity<?> deleteEnrollment(@Validated @RequestBody EnrollmentDTO enrollmentDTO) {
        Optional<EnrollmentEntity> optional = enrollmentDAO.findById(enrollmentDTO.getId());
        if(optional.isPresent()) {
            serviceEnrollment.deleteById(enrollmentDTO.getId());
            return ResponseEntity.ok(enrollmentDTO);
        }
        return ResponseEntity.badRequest().build();
    }



}
