package com.epstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Products extends BaseEntity
{
	@NotBlank(message = "title cannot be blank")
	@Column(length = 30)
	private String title;

	@NotBlank(message = "url cannot be blank")
	@Column(length = 300)
	private String image;

	private double unitPrice;

	@Column(nullable = true)
	private boolean isAvailable;

	@Column(nullable = true)
	private int unitStock;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories productCategory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cartProduct",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ShoppingCart> addedProducts;
}
