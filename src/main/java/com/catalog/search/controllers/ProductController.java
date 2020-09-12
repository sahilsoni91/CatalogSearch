package com.catalog.search.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.search.custom.ProductNotFoundException;
import com.catalog.search.entities.Filter;
import com.catalog.search.entities.Product;
import com.catalog.search.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path = "/products")
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}
	
	@GetMapping(path = "/products/{id}")
	public Product getProduct(@PathVariable long id) {
		Product p = productService.findProductById(id);
		if(p == null) {
			throw new ProductNotFoundException("Product Id : " + id + " not found.");
		}
		return p;
	}
	
	@GetMapping(path = "/products/type/{type}")
	public List<Product> getProductsByType(@PathVariable String type) {
		return productService.findProductByType(type);
	}
	
	@PostMapping(path = "/products/filter")
	public List<Product> getProductsByCriteria(@RequestBody Filter filter){
		return productService.findProductByCriteria(filter);
	}
}
