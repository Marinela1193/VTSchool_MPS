package org.example.vtschool_mps_2526.models.dao;

import org.example.vtschool_mps_2526.models.entities.SubjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubjectCoursDAO extends CrudRepository<SubjectEntity,Integer> {
}
