package com.ty.food_app.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.foodapp.dto.Item;
import com.ty.food_app.foodapp.dto.Orders;
import com.ty.food_app.foodapp.dto.Person;
import com.ty.food_app.foodapp.dto.User;
import com.ty.food_app.foodapp.repository.OrderRepository;

@Repository
public class OrderDao {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PersonDao personDao;
	
	public  Orders saveOrders(int uid, Orders orders) {
		
		Person person = personDao.getPersonById(uid);
		
		List<Item> items=orders.getItems();
		
		if(person != null) {
			orders.setPerson(person);
			
			for(Item item:items ) {
				item.setOrders(orders);
			}
			return orderRepository.save(orders);
		}
		
		return null;
	}
	
	public Orders getOrderById(int id) {
		Optional<Orders> optional=orderRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public List<Orders> getAllOrders(){
		return orderRepository.findAll();
	}
	public boolean deleteOrderById(int id) {
	
		Orders orders= getOrderById(id);
		if(orders != null) {
			orderRepository.delete(orders);
			return true;
		}
		return false;	
	}
	public Orders updateFoodOrder(int id,Orders orders) {
		
		Orders existingOrder= getOrderById(id);
	
		if(existingOrder != null) {
			return orderRepository.save(orders);
		}
		return null; 		
	}
 
}
