package com.epstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Categories extends BaseEntity
{
	@NotBlank(message = "title cannot be blank")
	@Column(length = 40)
	private String title;

	@NotBlank(message = "description cannot be blank")
	@Column(length = 60)
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private List<Products> categoryProducts = new ArrayList<>();
}
