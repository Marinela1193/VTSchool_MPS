package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.StudentsDAO;
import org.example.vtschool_mps_2526.models.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceStudent {

    @Autowired
    private StudentsDAO studentsDAO;

    public List<StudentEntity> getStudents() {
        return (List<StudentEntity>) studentsDAO.findAll();
    }

    public StudentEntity getStudentById(int idcard) {
        Optional<StudentEntity> studentEntity = studentsDAO.findById(idcard);

        return studentEntity.isPresent() ? studentEntity.get() : null;
    }

    public StudentEntity getStudentByName(String name) {
        Optional<StudentEntity> student = studentsDAO.findByName(name);
        return student.isPresent() ? student.get() : null;
    }

    public StudentEntity getStudentByEmail(String email) {
        Optional<StudentEntity> student = studentsDAO.findByEmail(email);
        return student.isPresent() ? student.get() : null;
    }

    public StudentEntity getStudentByPhone(String phone) {
        Optional<StudentEntity> student = studentsDAO.findByPhone(phone);
        return student.isPresent() ? student.get() : null;
    }

    public StudentEntity saveStudent(StudentEntity student) {
        if(!studentsDAO.existsById(Integer.valueOf(student.getIdcard()))){
            return studentsDAO.save(student);
        }
        return student;
    }

    public void deleteById(int idcard) {
        if(studentsDAO.existsById(Integer.valueOf(idcard))){
            studentsDAO.deleteById(Integer.valueOf(idcard));
        }
    }

    public StudentEntity updateStudent(StudentEntity student) {

        StudentEntity student2 = new StudentEntity();

        if(studentsDAO.existsById(Integer.valueOf(student.getIdcard()))){
            student2.setIdcard(student.getIdcard());
            student2.setFirstname(student.getFirstname());
            student2.setLastname(student.getLastname());
            student2.setEmail(student.getEmail());
            student2.setPhone(student.getPhone());

            return studentsDAO.save(student2);
        }
        return student2;
    }

}
