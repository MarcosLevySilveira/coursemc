package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
