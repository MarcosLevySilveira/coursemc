package com.studies.coursemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.coursemc.domain.ClientOrder;
import com.studies.coursemc.repositories.ClientOrderRepository;
import com.studies.coursemc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientOrderService {

	@Autowired
	private ClientOrderRepository repo;

	public ClientOrder find(Integer id) {
		Optional<ClientOrder> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + ClientOrder.class.getName()));
	}

}
