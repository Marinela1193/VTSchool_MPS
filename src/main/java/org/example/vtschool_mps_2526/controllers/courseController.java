package org.example.vtschool_mps_2526.controllers;

import org.example.vtschool_mps_2526.models.dao.CourseDAO;
import org.example.vtschool_mps_2526.models.entities.CourseEntity;
import org.example.vtschool_mps_2526.service.serviceCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
class courseController {

    @Autowired
    private serviceCourse serviceCourse;

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(serviceCourse.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@Validated @PathVariable Integer id) {
        CourseEntity course = serviceCourse.getCourseById(id);
        if(course == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createCourse(@Validated @RequestBody CourseEntity course) {
        CourseEntity saved = serviceCourse.save(course);
        if (saved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateCourse(@Validated @RequestBody CourseEntity course) {
        CourseEntity updated = serviceCourse.updateCours(course);
        if (updated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteCourse(@Validated @PathVariable Integer id) {
        if (!courseDAO.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        serviceCourse.deleteById(id);
        return ResponseEntity.ok("Curso eliminado correctamente");
    }
}
