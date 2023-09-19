package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
