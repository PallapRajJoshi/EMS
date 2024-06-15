package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.model.Product;

public interface ProductRepositary extends JpaRepository<Product, Integer> {

}
