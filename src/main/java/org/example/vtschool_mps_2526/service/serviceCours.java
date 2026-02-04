package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.CoursDAO;
import org.example.vtschool_mps_2526.models.entities.CoursEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCours {

    @Autowired
    private CoursDAO coursDAO;

    public List<CoursEntity> getCourses() {
        return (List<CoursEntity>) coursDAO.findAll();
    }

    public CoursEntity getCourseById(Integer id) {
        Optional<CoursEntity> course = coursDAO.findById(id);
        return course.isPresent() ? course.get() : null;
    }

    public CoursEntity save(CoursEntity course) {
        if (!coursDAO.existsById(course.getId())) {
            return coursDAO.save(course);
        }
        return null;
    }

    public CoursEntity updateCours(CoursEntity course) {
        Optional<CoursEntity> coursEntity = coursDAO.findById(course.getId());
        if (coursEntity.isPresent()) {
            CoursEntity cours1 = coursEntity.get();
            cours1.setName(course.getName());
            return coursDAO.save(cours1);
        }
        return null;
    }

    public void deleteById(Integer id) {
        if (coursDAO.existsById(id)) {
            coursDAO.deleteById(id);
        }
    }


}
