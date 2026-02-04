package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.SubjectCoursDAO;
import org.example.vtschool_mps_2526.models.entities.SubjectCoursEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSubjectCours {

    @Autowired
    private SubjectCoursDAO subjectCoursDAO;

    public SubjectCoursEntity findSubjectCoursById(Integer id) {
        Optional<SubjectEntity> subjectCoursEntity = subjectCoursDAO.findById(id);
        return subjectCoursEntity.isPresent() ? subjectCoursEntity.get() : null;
    }

    public List<SubjectCoursEntity> findAllSubjecCourses() {
        return (List<SubjectCoursEntity>) subjectCoursDAO.findAll();
    }

    public SubjectCoursEntity saveSubjectCours(SubjectCoursEntity entity) {
        if(subjectCoursDAO.existsById(entity.getId())) {
            return null;
        }
        return subjectCoursDAO.save(entity);
    }

    public SubjectCoursEntity updateSubjectCours(SubjectCoursEntity entity) {
        if(!subjectCoursDAO.existsById(entity.getId())) {
            return null;
        }
        SubjectCoursEntity existing = subjectCoursDAO.findById(entity.getId()).get();
        existing.setSubject(entity.getSubject());
        existing.setCourse(entity.getCourse());
        return subjectCoursDAO.save(existing);
    }

    public void deleteSubjectCoursById(Integer id) {
        if(subjectCoursDAO.existsById(id)) {
            subjectCoursDAO.deleteById(id);
        }
    }


}
