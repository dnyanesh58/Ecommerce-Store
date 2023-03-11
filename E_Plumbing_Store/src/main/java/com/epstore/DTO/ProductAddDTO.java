package com.epstore.DTO;

import com.epstore.entities.Categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductAddDTO 
{
	private String title;
	
	private String image;
	
	private double unitPrice;
	
	private boolean isAvailable;
	
	private int unitStock;
	
	private Categories productCategory;
}
