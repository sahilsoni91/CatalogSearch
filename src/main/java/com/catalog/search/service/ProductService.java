package com.catalog.search.service;

import java.util.List;

import com.catalog.search.entities.Filter;
import com.catalog.search.entities.Product;

public interface ProductService {

	List<Product> findProductByCriteria(Filter priceFilter);
	List<Product> findProductByType(String type);
	List<Product> findAllProducts();
	Product findProductById(Long id);
}
