package com.catalog.search.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.catalog.search.entities.Filter;
import com.catalog.search.entities.Product;
import com.catalog.search.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findProductByCriteria(Filter filter) {
		Specification<Product> specification = (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(filter != null) {
				if(filter.getType() != null) {
					predicates.add(root.get("type").in(filter.getType()));
				}
				if(filter.getName() != null) {
					predicates.add(root.get("name").in(filter.getName()));
				}
				if(filter.getSize() != null) {
					predicates.add(root.get("size").in(filter.getSize()));
				}
				if(filter.getBrand() != null) {
					predicates.add(root.get("brand").in(filter.getBrand()));
				}
				if(filter.getColor() != null) {
					predicates.add(root.get("color").in(filter.getColor()));
				}
				if(filter.getMinValue() != null && filter.getMaxValue() != null) {
            		predicates.add(criteriaBuilder.between(root.get("price"), 
                			filter.getMinValue(), filter.getMaxValue()));
            	} else if(filter.getMinValue() != null && filter.getMaxValue() == null) {
            		predicates.add(criteriaBuilder.ge(root.get("price"), filter.getMinValue()));
            	} else if(filter.getMinValue() == null && filter.getMaxValue() != null) {
            		predicates.add(criteriaBuilder.le(root.get("price"), filter.getMaxValue()));
            	}
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
		
		return productRepository.findAll(specification);
	}
	
	@Override
	public List<Product> findProductByType(String type){
		Specification<Product> specification = (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("type"), type));
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
		return productRepository.findAll(specification);
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product findProductById(Long id) {
		Optional product = productRepository.findById(id);
		if(product.isPresent()) {
			return (Product)product.get();
		}else {
			return null;
		}
	}
}
