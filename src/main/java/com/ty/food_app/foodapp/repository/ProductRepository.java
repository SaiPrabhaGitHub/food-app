package com.ty.food_app.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.foodapp.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
