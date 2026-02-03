package org.example.vtschool_mps_2526.models.dao;

import org.example.vtschool_mps_2526.models.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentsDAO extends CrudRepository<StudentEntity, Integer> {

}
