package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dto.SubjectCourseDTO;
import org.example.vtschool_mps_2526.models.entities.CourseEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectCourseEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.example.vtschool_mps_2526.service.serviceSubjectCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subjectCourse")
class subjectCourseController {
    @Autowired
    private serviceSubjectCourse serviceSubjectCourse;

    @GetMapping("/")
    public ResponseEntity<?> getAllCourseSubjects() {
        return ResponseEntity.ok(serviceSubjectCourse.getAllCourseSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectCourseById(@Validated @PathVariable Integer id) {
       SubjectCourseEntity subjectCourse = serviceSubjectCourse.getSubjectCourseById(id);
       return ResponseEntity.ok(subjectCourse);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@Validated @RequestBody SubjectCourseDTO dto) {
        SubjectCourseEntity entity = new SubjectCourseEntity();
        entity.setId(dto.getId());

        entity.setSubject(dto.getSubject() != null ? new SubjectEntity() : null);
        entity.setCourse(dto.getCourse() != null ? new CourseEntity() : null);

        SubjectCourseEntity saved = serviceSubjectCourse.saveSubjectCourse(entity);
        if(saved == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> update(@Validated @RequestBody SubjectCourseDTO dto) {
        SubjectCourseEntity entity = new SubjectCourseEntity();
        entity.setId(dto.getId());
        entity.setSubject(dto.getSubject() != null ? new SubjectEntity() : null);
        entity.setCourse(dto.getCourse() != null ? new CourseEntity() : null);

        SubjectCourseEntity updated = serviceSubjectCourse.updateSubjectCourse(entity);
        if(updated == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@Validated @PathVariable Integer id) {
        Optional <SubjectCourseEntity> optional = Optional.ofNullable(serviceSubjectCourse.getSubjectCourseById(id));
        if(optional.isPresent()) {
            serviceSubjectCourse.deleteSubjectCourseById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}