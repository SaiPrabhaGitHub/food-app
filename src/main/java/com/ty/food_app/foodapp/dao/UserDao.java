package com.ty.food_app.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.food_app.foodapp.dto.User;
import com.ty.food_app.foodapp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	public User getUserById(int id) {
		
	      Optional<User> optional=	userRepository.findById(id);
	      
	      if(optional.isEmpty()) {
	    	  return null;
	      }
	      return optional.get();
		
	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
		
	}
	public Boolean deleteUser(int id) {
		
		User user= getUserById(id);
		if(user != null) {
			
			 userRepository.deleteById(id);
			 return true;
		}
		
		 return null;
		
	}

}
