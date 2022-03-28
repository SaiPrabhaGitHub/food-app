package com.ty.food_app.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.foodapp.dao.ItemDao;
import com.ty.food_app.foodapp.dao.OrderDao;
import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Item;
import com.ty.food_app.foodapp.dto.Orders;
import com.ty.food_app.foodapp.exception.IdNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	
	public Responcestructure<Orders> saveOrder( int id,Orders orders) {
		
		double total=0;
		
		Orders orders2=orderDao.saveOrders(id, orders);
		List<Item> items=orders.getItems();
		
		for(Item item:items ) {
			total =total+item.getCost();
		}
		total=1.18*total;
		orders.setTotalCost(total);
		if(orders2== null) {
			throw new IdNotFoundException();
		}
		Responcestructure< Orders> responcestructure=new Responcestructure<Orders>();
		responcestructure.setStatus(HttpStatus.OK.value());
		responcestructure.setMsg("Prepaired");
		responcestructure.setData(orders2);
		return responcestructure;

	}
	
	public Responcestructure<Orders> getOrderByid(int id) {
		Orders orders= orderDao.getOrderById(id);
		
		if(orders == null) {
			throw new IdNotFoundException("No Id "+id+"Not exist");
		}
		
		Responcestructure< Orders> responcestructure=new Responcestructure<Orders>();
		responcestructure.setData(orders);
		responcestructure.setMsg("Order Is Getting");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<List<Orders>> getAllOrders(){
		
		List<Orders> orders=orderDao.getAllOrders();
		
		if(orders.isEmpty()) {
			throw new IdNotFoundException();
		}
		Responcestructure<List<Orders>> responcestructure=new Responcestructure<List<Orders>>();
		responcestructure.setMsg("All Orders Are Found");
		responcestructure.setData(orders);
		responcestructure.setStatus(HttpStatus.OK.value());
		return  responcestructure;
		
	}
	public Responcestructure<Boolean> deleteOrderById(int id) {
		
		Boolean b=orderDao.deleteOrderById(id);
		
		if(b == false) {
			throw new IdNotFoundException();
		}
		Responcestructure< Boolean> responcestructure=new Responcestructure<Boolean>();
		responcestructure.setData(b);
		responcestructure.setMsg("Deleted Food Order By Id");
		responcestructure.setStatus(id);
	
		return responcestructure;
	}
	
	public Responcestructure<Orders> updateOrders(int id,Orders  orders) {
		
		double total=0;
		
		Orders existingOrder= orderDao.updateFoodOrder(id, orders);
		List<Item> items=existingOrder.getItems();
		for(Item  item: items  ){
			total+=item.getCost();
			
		}
		total=1.8*total;
		orders.setTotalCost(total);
		if(items == null) {
			throw new IdNotFoundException();
		}
		Responcestructure< Orders> responcestructure=new Responcestructure<Orders>();
		responcestructure.setData(existingOrder);
		responcestructure.setMsg("Food Order Is Updated");
		responcestructure.setStatus(id);
		return responcestructure;
		
	}

}
