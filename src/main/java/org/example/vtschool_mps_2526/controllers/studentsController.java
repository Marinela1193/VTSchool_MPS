package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dao.EnrollmentDAO;
import org.example.vtschool_mps_2526.models.dao.StudentsDAO;
import org.example.vtschool_mps_2526.models.dto.StudentsDTO;
import org.example.vtschool_mps_2526.models.entities.EnrollmentEntity;
import org.example.vtschool_mps_2526.models.entities.StudentEntity;
import org.example.vtschool_mps_2526.service.serviceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
class studentsController {
    @Autowired
    serviceStudent serviceStdudent;

    @Autowired
    private StudentsDAO studentsDAO;
    @Autowired
    private EnrollmentDAO enrollmentDAO;


    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentsDAO.findAll());
    }

    @GetMapping("/{idcard}")
    public ResponseEntity<?> getStudent(@Validated @PathVariable("idcard") int idcard) {
        StudentEntity student = serviceStdudent.getStudentById(idcard);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@Validated @RequestBody StudentsDTO student) {

        Optional<StudentEntity> optional = studentsDAO.findById(student.getIdcard());
        if (optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<EnrollmentEntity> enroll = enrollmentDAO.findById(student.getIdcard());
        StudentEntity student1 = new StudentEntity();
        student1.setIdcard(String.valueOf(student.getIdcard()));
        student1.setFirstname(student.getFirstName());
        student1.setLastname(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());

        serviceStdudent.saveStudent(student1);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idcard}")
    public ResponseEntity<?> updateStudent(@Validated @RequestBody StudentsDTO student, @PathVariable("idcard") int idcard) {
        Optional<StudentEntity> optional = studentsDAO.findById(idcard);
        if (optional.isPresent()) {
            Optional<EnrollmentEntity> enroll = enrollmentDAO.findById(student.getIdcard());
            StudentEntity student1 = new StudentEntity();
            student1.setIdcard(String.valueOf(student.getIdcard()));
            student1.setFirstname(student.getFirstName());
            student1.setLastname(student.getLastName());
            student1.setEmail(student.getEmail());
            student1.setPhone(student.getPhone());

            serviceStdudent.updateStudent(student1);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idcard}")
    public ResponseEntity<?> deleteStudent(@Validated @PathVariable("idcard") int idcard) {
        Optional<StudentEntity> optional = studentsDAO.findById(idcard);
        if (optional.isPresent()) {
            serviceStdudent.deleteById(idcard);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
