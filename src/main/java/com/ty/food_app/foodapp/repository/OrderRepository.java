package com.ty.food_app.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.foodapp.dto.Orders;

public interface OrderRepository  extends JpaRepository<Orders, Integer>{

}
