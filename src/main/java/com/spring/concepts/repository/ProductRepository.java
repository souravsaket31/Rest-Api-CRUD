package com.spring.concepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.concepts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
