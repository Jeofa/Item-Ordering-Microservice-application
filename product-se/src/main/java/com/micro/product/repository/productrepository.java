package com.micro.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.product.model.Product;

public interface productrepository extends JpaRepository<Product, String>{

}
