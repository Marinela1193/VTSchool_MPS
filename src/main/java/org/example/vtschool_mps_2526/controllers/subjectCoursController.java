package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dto.SubjectCoursDTO;
import org.example.vtschool_mps_2526.models.entities.CoursEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectCoursEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.example.vtschool_mps_2526.service.serviceSubjectCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subjectCours")
class subjectCoursController {
    @Autowired
    private serviceSubjectCours serviceSubjectCours;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(serviceSubjectCours.findAllSubjecCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@Validated @PathVariable Integer id) {
       SubjectCoursEntity subjectCours = serviceSubjectCours.findSubjectCoursById(id);
       return ResponseEntity.ok(subjectCours);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@Validated @RequestBody SubjectCoursDTO dto) {
        SubjectCoursEntity entity = new SubjectCoursEntity();
        entity.setId(dto.getId());

        entity.setSubject(dto.getSubject() != null ? new SubjectEntity() : null);
        entity.setCourse(dto.getCourse() != null ? new CoursEntity() : null);

        SubjectCoursEntity saved = serviceSubjectCours.saveSubjectCours(entity);
        if(saved == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> update(@Validated @RequestBody SubjectCoursDTO dto) {
        SubjectCoursEntity entity = new SubjectCoursEntity();
        entity.setId(dto.getId());
        entity.setSubject(dto.getSubject() != null ? new SubjectEntity() : null);
        entity.setCourse(dto.getCourse() != null ? new CoursEntity() : null);

        SubjectCoursEntity updated = serviceSubjectCours.updateSubjectCours(entity);
        if(updated == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@Validated @PathVariable Integer id) {
        Optional <SubjectCoursEntity> optional = Optional.ofNullable(serviceSubjectCours.findSubjectCoursById(id));
        if(optional.isPresent()) {
            serviceSubjectCours.deleteSubjectCoursById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
