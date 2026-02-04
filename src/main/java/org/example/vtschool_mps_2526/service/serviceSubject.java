package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.SubjectDAO;
import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSubject {
    @Autowired
    private SubjectDAO subjectDAO;

    public List<SubjectEntity> getSubjects() {
        return (List<SubjectEntity>) subjectDAO.findAll();
    }

    public SubjectEntity findSubjectById(Integer id) {
        Optional<SubjectEntity> subjectEntity = subjectDAO.findById(id);

        return subjectEntity.isPresent() ? subjectEntity.get() : null;
    }


    public SubjectEntity saveSubject(SubjectEntity subject) {
        if(subjectDAO.existsById(subject.getId())) {
            return null;
        }
        return subjectDAO.save(subject);
    }

    public SubjectEntity updateSubject(SubjectEntity subject) {
        if(!subjectDAO.existsById(subject.getId())) {
            return null;
        }
        SubjectEntity existing = subjectDAO.findById(subject.getId()).get();
        existing.setName(subject.getName());
        existing.setYear(subject.getYear());
        existing.setHours(subject.getHours());
        return subjectDAO.save(existing);
    }

    public void deleteSubjectById(Integer id) {
        if(subjectDAO.existsById(id)) {
            subjectDAO.deleteById(id);
        }
    }

}
