package com.micro.product.service;


import java.util.List;

import com.micro.product.dto.ProductRequest;
import com.micro.product.dto.ProductResponse;
import com.micro.product.repository.productrepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.product.model.Product;


@Service
public class ProductService {
	
	@Autowired
	private productrepository productrepo;
	
	public void createProduct(ProductRequest productRequest) {
		
		//map product request to product model
		Product product = new Product();
		product.setDescription(productRequest.getDescription());
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		
		productrepo.save(product);
		
		 Logger logger = LoggerFactory.getLogger(ProductService.class);
		 
		 logger.info("Product {} is saved ",product.getId());
//		System.out.println("Product "+ product.getId()+" is saved");
		
		
	}

	public List<ProductResponse> getAllProducts() {
		
		List<Product> products = productrepo.findAll();
		
		//map products to productresponse class
		return products.stream().map(this::mapToProductResponse).toList();
		
	}
	
	public ProductResponse mapToProductResponse(Product product) {
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setName(product.getName());
		productResponse.setDescription(product.getDescription());
		productResponse.setPrice(product.getPrice());
		return productResponse;
	}

}
