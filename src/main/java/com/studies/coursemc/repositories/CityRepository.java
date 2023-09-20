package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
