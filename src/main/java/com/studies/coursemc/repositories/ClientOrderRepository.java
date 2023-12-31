package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.ClientOrder;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Integer>{

}
