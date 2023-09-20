package com.studies.coursemc.domain;

import com.studies.coursemc.domain.enums.PaymentStatus;

import jakarta.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment{

	private static final long serialVersionUID = 1L;
	private Integer installments;
	
	public CreditCardPayment() {
		
	}

	public CreditCardPayment(Integer id, PaymentStatus status, ClientOrder order, Integer installments) {
		super(id, status, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
	
	
}
