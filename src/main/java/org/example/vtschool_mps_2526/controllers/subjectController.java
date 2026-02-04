package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dto.SubjectDTO;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.example.vtschool_mps_2526.service.serviceSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subjects")
class subjectController {
    @Autowired
    private serviceSubject serviceSubject;

    @GetMapping("/")
    public ResponseEntity<?> getSubjects() {
        return ResponseEntity.ok(serviceSubject.getSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubject(@Validated @PathVariable Integer id) {
        Optional<SubjectEntity> optional = Optional.ofNullable(serviceSubject.findSubjectById(id));
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createSubject(@Validated @RequestBody SubjectDTO dto) {
        SubjectEntity subject = new SubjectEntity();
        subject.setId(dto.getId());
        subject.setName(dto.getName());
        subject.setYear(dto.getYear());
        subject.setHours(dto.getHours());

        SubjectEntity saved = serviceSubject.saveSubject(subject);
        if(saved == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateSubject(@Validated @RequestBody SubjectDTO dto) {
        SubjectEntity subject = new SubjectEntity();
        subject.setId(dto.getId());
        subject.setName(dto.getName());
        subject.setYear(dto.getYear());
        subject.setHours(dto.getHours());

        SubjectEntity updated = serviceSubject.updateSubject(subject);
        if(updated == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteSubject(@Validated @PathVariable Integer id) {
        Optional <SubjectEntity> optional = Optional.ofNullable(serviceSubject.findSubjectById(id));

        if(!optional.isPresent())
        {
            return ResponseEntity.badRequest().build();
        }

        serviceSubject.deleteSubjectById(id);
        return ResponseEntity.ok("Subject eliminado correctamente");
    }
}
