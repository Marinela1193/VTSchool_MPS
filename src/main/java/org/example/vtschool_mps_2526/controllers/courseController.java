package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dao.CoursDAO;
import org.example.vtschool_mps_2526.models.entities.CoursEntity;
import org.example.vtschool_mps_2526.service.serviceCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
class courseController {

    @Autowired
    private serviceCours serviceCours;

    @Autowired
    private CoursDAO coursDAO;

    @GetMapping("/")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(serviceCours.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@Validated @PathVariable Integer id) {
        CoursEntity course = serviceCours.getCourseById(id);
        if(course == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createCourse(@Validated @RequestBody CoursEntity course) {
        CoursEntity saved = serviceCours.save(course);
        if (saved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateCourse(@Validated @RequestBody CoursEntity course) {
        CoursEntity updated = serviceCours.updateCours(course);
        if (updated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteCourse(@Validated @PathVariable Integer id) {
        if (!coursDAO.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        serviceCours.deleteById(id);
        return ResponseEntity.ok("Curso eliminado correctamente");
    }
}
