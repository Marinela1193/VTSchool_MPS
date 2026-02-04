package org.example.vtschool_mps_2526.models.dao;

import org.example.vtschool_mps_2526.models.entities.CoursEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoursDAO extends CrudRepository<CoursEntity, Integer> {
}
