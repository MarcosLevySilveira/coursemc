package com.studies.coursemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.coursemc.domain.Client;
import com.studies.coursemc.repositories.ClientRepository;
import com.studies.coursemc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Client.class.getName()));
	}

}
