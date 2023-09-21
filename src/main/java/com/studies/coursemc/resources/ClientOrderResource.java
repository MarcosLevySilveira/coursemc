package com.studies.coursemc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studies.coursemc.domain.ClientOrder;
import com.studies.coursemc.services.ClientOrderService;

@RestController
@RequestMapping(value = "/clientorders")
public class ClientOrderResource {

	@Autowired
	private ClientOrderService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ClientOrder obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
		
		
	}
	
}
