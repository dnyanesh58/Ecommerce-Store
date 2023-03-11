package com.epstore.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class ShoppingCart extends BaseEntity
{
	@Min(value = 10,message = "minimum order quantity 10 pcs")
	private int quantity;

	private Date createdOn;

	  @ManyToOne
	  @JoinColumn(name = "product_id")
	  private Products cartProduct;
	  
	  @OneToOne
	  @JoinColumn(name = "customer_id")
	  private Customer customer;
}
