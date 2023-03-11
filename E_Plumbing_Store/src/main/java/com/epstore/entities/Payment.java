package com.epstore.entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Payment extends BaseEntity
{
	@NotBlank(message = "cardNo cannot be blank")
	@Column(length = 16,unique = true)
	private String cardNo;

	@NotBlank(message = "cardName cannot be blank")
	@Column(length = 30)
	private String nameOnCard;

	@Column(nullable = true)
	private int amount;

	private Date paymentDate;

	/*
	 * @OneToMany(mappedBy = "payment",orphanRemoval = true,cascade =
	 * CascadeType.ALL) private List<Orders> orders = new ArrayList<>();
	 */
}
