package com.ty.food_app.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Person;
import com.ty.food_app.foodapp.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	 @ApiOperation(value = "Save The Person Details" ,produces = "application/json",consumes = "application/json")
		
		@ApiResponses({
			@ApiResponse(code = 200,message = "Person Saved"),
			@ApiResponse(code = 400,message = "Bad Request,Not Proper Person Data")
		})
	
	@PostMapping("/person")
	public Responcestructure<Person> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	 
	 @ApiOperation(value = "get Person Details", produces = "application/json", consumes = "application/json" )
	  	@ApiResponses({
	  		@ApiResponse(code = 200,message = "get Person Data "),
	  		@ApiResponse(code = 400,message = "No Given Id Found")
	  		
	  	})
	 
	@GetMapping("/person")
	public Responcestructure<Person> getPersonById(@RequestParam int id) {
		return personService.getPersonById(id);
	}
	@GetMapping("/allpersons")
	public Responcestructure<List< Person >> getAllPersons(){
		
		return personService.getAllPesPersons();
	}
	@DeleteMapping("/person")
	public Responcestructure<Boolean> deletePersonById(@RequestParam int id) {
	   return	personService.deletePerson(id);
	}
	@PutMapping("/person")
	public Responcestructure<Person> updatePersonById(@RequestParam int id, @RequestBody Person person) {
		return personService.updatePerson(id, person);
	}
	

}
