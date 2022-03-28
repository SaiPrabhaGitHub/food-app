package com.ty.food_app.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.foodapp.dto.Person;


public interface PersonRepository extends JpaRepository<Person , Integer> {

}
