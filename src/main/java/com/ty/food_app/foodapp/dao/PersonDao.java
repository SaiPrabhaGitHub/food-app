package com.ty.food_app.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.foodapp.dto.Person;
import com.ty.food_app.foodapp.repository.PersonRepository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(int id) {
		Optional<Person> optional=personRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	public Boolean deletePersonById(int id) {
		Person person= getPersonById(id);
		
		if(person != null) {
			personRepository.delete(person);
			return true;
		}
		return false;
	}
	public Person updatePerson(int id,Person person) {
		Person existingPerson= getPersonById(id);
		if(existingPerson != null) {
			existingPerson.setEmail(person.getEmail());
			existingPerson.setPhone(person.getPhone());
			existingPerson.setName(person.getName());
			personRepository.save(existingPerson);
			return person;
		}
		return null;
	}
}
