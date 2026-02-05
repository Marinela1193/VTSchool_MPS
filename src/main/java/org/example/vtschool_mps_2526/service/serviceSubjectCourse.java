/*package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.SubjectCourseDAO;
import org.example.vtschool_mps_2526.models.entities.SubjectCourseEntity;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSubjectCours {

    @Autowired
    private SubjectCourseDAO subjectCoursDAO;

    public SubjectCourseEntity findSubjectCoursById(Integer id) {
        Optional<SubjectEntity> subjectCoursEntity = subjectCoursDAO.findById(id);
        return subjectCoursEntity.isPresent() ? subjectCoursEntity.get() : null;
    }

    public List<SubjectCourseEntity> findAllSubjecCourses() {
        return (List<SubjectCourseEntity>) subjectCoursDAO.findAll();
    }

    public SubjectCourseEntity saveSubjectCours(SubjectCourseEntity entity) {
        if(subjectCoursDAO.existsById(entity.getId())) {
            return null;
        }
        return subjectCoursDAO.save(entity);
    }

    public SubjectCourseEntity updateSubjectCours(SubjectCourseEntity entity) {
        if(!subjectCoursDAO.existsById(entity.getId())) {
            return null;
        }
        SubjectCourseEntity existing = subjectCoursDAO.findById(entity.getId()).get();
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
*/