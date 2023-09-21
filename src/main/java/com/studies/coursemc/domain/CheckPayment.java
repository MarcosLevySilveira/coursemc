package com.studies.coursemc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studies.coursemc.domain.enums.PaymentStatus;

import jakarta.persistence.Entity;

@Entity
public class CheckPayment extends Payment{

	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dueDate;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date payDate;
	
	
	public CheckPayment() {
		
	}


	public CheckPayment(Integer id, PaymentStatus status, ClientOrder order, Date dueDate, Date PayDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payDate = payDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getPayDate() {
		return payDate;
	}


	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
	
}
