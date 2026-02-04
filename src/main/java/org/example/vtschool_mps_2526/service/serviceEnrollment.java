package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.EnrollmentDAO;
import org.example.vtschool_mps_2526.models.dao.StudentsDAO;
import org.example.vtschool_mps_2526.models.entities.EnrollmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEnrollment {

    @Autowired
    private EnrollmentDAO enrollmentDAO;
    @Autowired
    private StudentsDAO studentsDAO;

    public List<EnrollmentEntity> getEnrollments() {
        return (List<EnrollmentEntity>) enrollmentDAO.findAll();
    }

    public EnrollmentEntity getEnrollmentById(Integer id) {
        Optional<EnrollmentEntity> enrollmentEntity = enrollmentDAO.findById(id);
        return enrollmentEntity.isPresent() ? enrollmentEntity.get() : null;
    }


     public EnrollmentEntity save(EnrollmentEntity enrollment) {
        if(!enrollmentDAO.existsById(Integer.valueOf(enrollment.getId()))){
            return enrollmentDAO.save(enrollment);
        }
        return enrollment;
    }

    public void deleteById(int id) {
        if(enrollmentDAO.existsById(Integer.valueOf(id))){
            enrollmentDAO.deleteById(Integer.valueOf(id));
        }
    }

    public EnrollmentEntity update(EnrollmentEntity enrollment) {

        EnrollmentEntity enroll = new EnrollmentEntity();

        if(enrollmentDAO.existsById(Integer.valueOf(enrollment.getId()))){
            enroll.setId(enrollment.getId());
            enroll.setCourse(enrollment.getCourse());
            enroll.setYear(enrollment.getYear());

            return enrollmentDAO.save(enroll);
        }
        return enroll;
    }


}
