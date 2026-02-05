package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.CourseDAO;
import org.example.vtschool_mps_2526.models.entities.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCourse {

    @Autowired
    private CourseDAO courseDAO;

    public List<CourseEntity> getCourses() {
        return (List<CourseEntity>) courseDAO.findAll();
    }

    public CourseEntity getCourseById(Integer id) {
        Optional<CourseEntity> course = courseDAO.findById(id);
        return course.isPresent() ? course.get() : null;
    }

    public CourseEntity save(CourseEntity course) {
        if (!courseDAO.existsById(course.getId())) {
            return courseDAO.save(course);
        }
        return null;
    }

    public CourseEntity updateCours(CourseEntity course) {
        Optional<CourseEntity> coursEntity = courseDAO.findById(course.getId());
        if (coursEntity.isPresent()) {
            CourseEntity cours1 = coursEntity.get();
            cours1.setName(course.getName());
            return courseDAO.save(cours1);
        }
        return null;
    }

    public void deleteById(Integer id) {
        if (courseDAO.existsById(id)) {
            courseDAO.deleteById(id);
        }
    }


}
