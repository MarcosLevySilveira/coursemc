package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{

}
