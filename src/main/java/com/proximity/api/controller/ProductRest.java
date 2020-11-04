package com.proximity.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proximity.api.bean.Product;
import com.proximity.api.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/product")
public class ProductRest {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/{productId}")
	@ApiOperation(value = "Get product by id")
	public Product getProductById(@PathVariable("productId") Long productId) {
		return productService.getProductById(productId);
	}
	
	@GetMapping
	@ApiOperation(value = "Get all products available")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PutMapping
	@ApiOperation(value = "Create product")
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PostMapping
	@ApiOperation(value = "Update product")
	public Product update(@RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("/{productId}")
	@ApiOperation(value = "Delete product")
	public Product delete(@PathVariable("productId") Long productId) {
		return productService.delete(productId);
	}
	
}
