package com.epstore.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Orders extends BaseEntity
{
	private Date createdOn;

	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "payment_id") private Payment payment;
	 */
}
