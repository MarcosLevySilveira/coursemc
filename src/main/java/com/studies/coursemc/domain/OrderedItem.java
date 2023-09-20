package com.studies.coursemc.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderedItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderedItemPK id = new OrderedItemPK();
	
	private Double saving;
	private Integer quantity;
	private Double price;
	
	public OrderedItem() {
		
	}

	public OrderedItem(ClientOrder clientOrder, Product product, Double saving, Integer quantity, Double price) {
		super();
		id.setClientOrder(clientOrder);
		id.setProduct(product);
		this.saving = saving;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderedItemPK getId() {
		return id;
	}

	public void setId(OrderedItemPK id) {
		this.id = id;
	}

	public Double getSaving() {
		return saving;
	}

	public void setSaving(Double saving) {
		this.saving = saving;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public ClientOrder getClientOrder() {
		return id.getClientOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
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
		OrderedItem other = (OrderedItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
