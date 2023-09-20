package com.studies.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.coursemc.domain.OrderedItem;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer>{

}
