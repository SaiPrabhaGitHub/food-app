package com.ty.food_app.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dao.UserDao;
import com.ty.food_app.foodapp.dto.User;
import com.ty.food_app.foodapp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
  @ApiOperation(value = "Save The User Details" ,produces = "application/json",consumes = "application/json")
	
	@ApiResponses({
		@ApiResponse(code = 200,message = "User Saved"),
		@ApiResponse(code = 400,message = "Bad Request,Not Proper User Data")
	})
	
	
	@PostMapping("/user")
	public Responcestructure<User> userSave(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
  	
  	@ApiOperation(value = "get Use Details", produces = "application/json", consumes = "application/json" )
  	@ApiResponses({
  		@ApiResponse(code = 200,message = "get user Data "),
  		@ApiResponse(code = 400,message = "No Given Id Found")
  		
  	})
	
	@GetMapping("/User")
	public Responcestructure<User> getUserById(@RequestParam int id) {
		
		return userService.getUserById(id);
		
	}
	
	@GetMapping("/allusers")
	public Responcestructure<List<User>> getAllUsers(){
		
		return userService.getAllUsers();
		
	}
	@DeleteMapping("/user")
	public Responcestructure<Boolean> deleteUser(@RequestParam int id) {
		
		return userService.deleteUserById(id);
	}

}
