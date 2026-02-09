package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.SubjectCourseDAO;
import org.example.vtschool_mps_2526.models.entities.SubjectCourseEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSubjectCourse {

    @Autowired
    private SubjectCourseDAO subjectCourseDAO;

    public SubjectCourseEntity getSubjectCourseById(Integer id) {
        Optional<SubjectCourseEntity> subjectCourseEntity = subjectCourseDAO.findById(id);
        return subjectCourseEntity.isPresent() ? subjectCourseEntity.get() : null;
    }

    public List<SubjectCourseEntity> getAllCourseSubjects() {
        return (List<SubjectCourseEntity>) subjectCourseDAO.findAll();
    }

    public SubjectCourseEntity saveSubjectCourse(SubjectCourseEntity entity) {
        if(!subjectCourseDAO.existsById(entity.getId())) {
            return subjectCourseDAO.save(entity);
        }
        return entity;
    }

    public SubjectCourseEntity updateSubjectCourse(SubjectCourseEntity entity) {
        if(!subjectCourseDAO.existsById(entity.getId())) {
            return null;
        }
        SubjectCourseEntity existing = subjectCourseDAO.findById(entity.getId()).get();
        existing.setSubject(entity.getSubject());
        existing.setCourse(entity.getCourse());
        return subjectCourseDAO.save(existing);
    }

    public void deleteSubjectCourseById(Integer id) {
        if(subjectCourseDAO.existsById(id)) {
            subjectCourseDAO.deleteById(id);
        }
    }
}
