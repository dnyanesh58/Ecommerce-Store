package com.epstore.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.epstore.DTO.ProductAddDTO;
import com.epstore.entities.Categories;
import com.epstore.entities.Products;
import com.epstore.service.CategoriesService;
import com.epstore.service.ImageHandlingService;
import com.epstore.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController 
{
	@Autowired
	private ProductsService productService;
	
	@Autowired
	private CategoriesService catService;
	
	@Autowired
	private ImageHandlingService imageService;
	
	public ProductsController()
	{
		System.out.println("In ctor of : "+getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProducts()
	{
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping("cat/{id}")
	public ResponseEntity<?> getAllProductsByCategoryId(@PathVariable Long id)
	{
		return ResponseEntity.ok(productService.getAllByCategoriesId(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id)
	{
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@PostMapping("/{catId}")
	public ResponseEntity<?> saveNewProduct(@RequestBody ProductAddDTO newProduct
			,@PathVariable Long catId)
	{
		Categories category = catService.getCategoryById(catId);
		newProduct.setProductCategory(category);
		return ResponseEntity.ok(productService.addNewProduct(newProduct));
	}
	
	@PatchMapping
	public ResponseEntity<?> updateProduct(@RequestBody Products existProduct)
	{
		return ResponseEntity.ok(productService.updateProduct(existProduct));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeProductById(@PathVariable Long id)
	{
		return ResponseEntity.ok(productService.removeProduct(id));
	}
	
	@PostMapping(value="/{id}/image",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
			@PathVariable Long id
			) throws IOException {
		System.out.println("in upload img " + id + " " + imageFile.getOriginalFilename());
		return new ResponseEntity<>(imageService.uploadImage(id, imageFile), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}/image", produces = { MediaType.IMAGE_GIF_VALUE, 
			MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long id) throws IOException
	{
		return new ResponseEntity<>(imageService.serveImage(id),HttpStatus.OK);
	}
}
