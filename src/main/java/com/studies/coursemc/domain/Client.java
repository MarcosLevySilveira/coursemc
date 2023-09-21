package com.studies.coursemc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studies.coursemc.domain.enums.ClientType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String sinNumberOrBusinessNumber;
	private Integer type;
	
	
	@OneToMany(mappedBy="client")
	private List<Address> address = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="phoneNumber")
	private Set<String> phoneNumber = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="client")	
	private List<ClientOrder> orders = new ArrayList<>();
	
	
	public Client() {
		
	}


	public Client(Integer id, String name, String email, String sinNumberOrBusinessNumber, ClientType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sinNumberOrBusinessNumber = sinNumberOrBusinessNumber;
		this.type = type.getCod();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSinNumberOrBusinessNumber() {
		return sinNumberOrBusinessNumber;
	}


	public void setSinNumberOrBusinessNumber(String sinNumberOrBusinessNumber) {
		this.sinNumberOrBusinessNumber = sinNumberOrBusinessNumber;
	}


	public ClientType getType() {
		return ClientType.toEnum(type);
	}


	public void setType(ClientType type) {
		this.type = type.getCod();
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public Set<String> getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Set<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}


	public List<ClientOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<ClientOrder> orders) {
		this.orders = orders;
	}
	
	
}
