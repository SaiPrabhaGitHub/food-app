package com.ty.food_app.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.foodapp.dao.ItemDao;
import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Item;
import com.ty.food_app.foodapp.exception.IdNotFoundException;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public Responcestructure<Item> saveItem( int id,Item item) {
		Item item2= itemDao.saveItem(id, item);
		if(item2 == null) {
			throw new IdNotFoundException();
		}
		Responcestructure<Item> responcestructure=new Responcestructure<Item>();
		responcestructure.setData(item2);
		responcestructure.setMsg("Item Is Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<Item> getItemById(int id) {
		
		Item item= itemDao.getItemById(id);
		if(item == null) {
			throw new IdNotFoundException("No Id "+id+"Not exist");
		}
		Responcestructure<Item> responcestructure=new Responcestructure<Item>();
		responcestructure.setData(item);
		responcestructure.setMsg("getting the Item ");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<List<Item>> getAllItems(){
		List<Item> item= itemDao.getAllItems();
		if(item.isEmpty()) {
			throw new IdNotFoundException();
		}
		Responcestructure<List<Item>> responcestructure=new Responcestructure<List<Item>>();
		responcestructure.setData(item);
		responcestructure.setMsg("getting All Items ");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<Boolean> deleteItemById(int id) {
		 Boolean b= itemDao.deleteItemById(id);
		 
		 if(b==false) {
			 throw new IdNotFoundException();
		 }
		 Responcestructure<Boolean> responcestructure=new Responcestructure<Boolean>();
			responcestructure.setData(b);
			responcestructure.setMsg("Deleted Items ");
			responcestructure.setStatus(HttpStatus.OK.value());
			return responcestructure;
		 
	}
	public Responcestructure<Item> updateItem(int id,Item item) {
		 Item item2= itemDao.updateItem(id, item);
		 if(item == null) {
			 throw new IdNotFoundException();
		 }
		 Responcestructure<Item> responcestructure=new Responcestructure<Item>();
			responcestructure.setData(item2);
			responcestructure.setMsg("updated Items ");
			responcestructure.setStatus(HttpStatus.OK.value());
			return responcestructure;
			
		 
	}

}
