package com.ty.food_app.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.foodapp.dto.Item;
import com.ty.food_app.foodapp.dto.Orders;
import com.ty.food_app.foodapp.repository.ItemRepository;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepository  itemRepository;
	@Autowired
	private OrderDao orderDao;
	
	public Item saveItem( int id,Item  item) {
		
		 Orders orders= orderDao.getOrderById(id);
		 
		 if(orders != null) {
			 item.setOrders(orders);
			 itemRepository.save(item);
			 return item;
		 }
		
		return null;
	}
	
	public Item getItemById(int id) {
		Optional< Item> optional=itemRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public List<Item> getAllItems(){
		return  itemRepository.findAll();
	}
	
	public Boolean deleteItemById(int id) {
		
		Item  item= getItemById(id);
		
		if(item != null) {
			itemRepository.delete(item);
			return true;
		}
		return false;
		
	}
	public Item updateItem(int id,Item item) {
		Item existingItem= getItemById(id);
		
		if(existingItem != null) {
			existingItem.setName(item.getName());
			existingItem.setCost(item.getCost());
			existingItem.setQuantity(item.getQuantity());
			return itemRepository.save(existingItem);
		}
		return null;
		
		
	}
}
