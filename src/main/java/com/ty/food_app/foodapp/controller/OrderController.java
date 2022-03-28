package com.ty.food_app.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Orders;
import com.ty.food_app.foodapp.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	 @ApiOperation(value = "Save The Order Details" ,produces = "application/json",consumes = "application/json")
		
		@ApiResponses({
			@ApiResponse(code = 200,message = "Order Saved"),
			@ApiResponse(code = 400,message = "Bad Request,Not Proper Order Data")
		})
	
	@PostMapping("/person/{id}/orders")
	public Responcestructure<Orders> saveOrders(@PathVariable int id, @RequestBody Orders orders) {
		return orderService.saveOrder(id, orders);
	}
	 
	 @ApiOperation(value = "get Order Details", produces = "application/json", consumes = "application/json" )
	  	@ApiResponses({
	  		@ApiResponse(code = 200,message = "get Order Data "),
	  		@ApiResponse(code = 400,message = "No Given Id Found")
	  		
	  	})
	 
	 
	@GetMapping("/order")
	public Responcestructure<Orders> getOrderById(@RequestParam int id) {
		return orderService.getOrderByid(id);
	}
	public void deleteOrderByIdf(int id) {
		orderService.deleteOrderById(id);
	}
	@PutMapping("/order")
	public Responcestructure<Orders> updateOrders(@RequestParam int id,@RequestBody Orders orders) {
		return  orderService.updateOrders(id, orders);
	}

}
