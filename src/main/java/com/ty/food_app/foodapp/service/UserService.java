package com.ty.food_app.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dao.UserDao;
import com.ty.food_app.foodapp.dto.User;
import com.ty.food_app.foodapp.exception.IdNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public Responcestructure<User> saveUser(User user) {
		User user2= userDao.saveUser(user);
		if(user2 == null) {
			throw new IdNotFoundException();
		}
		Responcestructure<User> responcestructure=new Responcestructure<User>();
		responcestructure.setData(user2);
		responcestructure.setMsg("User Is Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<User> getUserById(int id) {
		
		User  user= userDao.getUserById(id);
		
		if(user == null) {
			throw new IdNotFoundException("Give Id"+ id+  "  Does Not Exist");
		}
		
		Responcestructure< User>responcestructure=new Responcestructure<User>();
		responcestructure.setData(user);
		responcestructure.setMsg(" got User");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<List<User>> getAllUsers(){
		List<User> users= userDao.getAllUsers();
		if(users.isEmpty()) {
			throw new IdNotFoundException();
		}
		Responcestructure<List<User>>responcestructure=new Responcestructure<List<User>>();
		responcestructure.setData(users);
		responcestructure.setMsg(" got User");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public  Responcestructure<Boolean> deleteUserById(int id) {
		    Boolean b= userDao.deleteUser(id);
		    
		    if(b== false) {
		    	throw new IdNotFoundException();
		    }
		    Responcestructure<Boolean> responcestructure=new Responcestructure<Boolean>();
		    responcestructure.setData(b);
			responcestructure.setMsg(" got User");
			responcestructure.setStatus(HttpStatus.OK.value());
			return responcestructure;
	}
	

}
