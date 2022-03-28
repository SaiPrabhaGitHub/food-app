package com.ty.food_app.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.foodapp.dao.PersonDao;
import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Person;
import com.ty.food_app.foodapp.exception.IdNotFoundException;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public Responcestructure<Person> savePerson(Person person) {
		Person person2= personDao.savePerson(person);
		if(person2 == null) {
			throw new IdNotFoundException();
		}
		Responcestructure<Person> responcestructure=new Responcestructure<Person>();
		responcestructure.setData(person2);
		responcestructure.setMsg("Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<Person> getPersonById(int id) {
		Person person= personDao.getPersonById(id);
		if(person == null) {
			throw new IdNotFoundException("No Id "+id+"Not exist");
		}
		Responcestructure< Person> responcestructure=new Responcestructure<Person>();
		responcestructure.setData(person);
		responcestructure.setMsg("get Person");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<List<Person>> getAllPesPersons(){
		List<Person> person= personDao.getAllPersons();
		if(person.isEmpty()) {
			throw new IdNotFoundException();
		}
		
		Responcestructure< List<Person>> responcestructure=new Responcestructure<List<Person>>();
		responcestructure.setData(person);
		responcestructure.setMsg("get Person");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<Boolean> deletePerson(int id) {
	  Boolean b=	personDao.deletePersonById(id);
	  
	  if(b== null) {
		  throw new IdNotFoundException();
	  }
	  Responcestructure< Boolean> responcestructure=new Responcestructure<Boolean>();
		responcestructure.setData(b);
		responcestructure.setMsg("Person Deleted  ");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<Person> updatePerson(int id,Person person) {
		Person person2= personDao.updatePerson(id, person);
		if(person2 == null) {
			throw new IdNotFoundException();
		}
		 Responcestructure< Person> responcestructure=new Responcestructure<Person>();
			responcestructure.setData(person2);
			responcestructure.setMsg("Updated   Person   ");
			responcestructure.setStatus(HttpStatus.OK.value());
			return responcestructure;
	
		
		
	}
	

}
