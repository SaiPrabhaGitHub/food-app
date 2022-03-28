package com.ty.food_app.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Item;
import com.ty.food_app.foodapp.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	 @ApiOperation(value = "Save The Item Details" ,produces = "application/json",consumes = "application/json")
		
		@ApiResponses({
			@ApiResponse(code = 200,message = "Item Saved"),
			@ApiResponse(code = 400,message = "Bad Request,Not Proper Item Data")
		})
	
	@PostMapping("/orders/{oid}/item")
	public Responcestructure<Item> saveItem(@PathVariable int oid,@RequestBody Item  item) {
		return itemService.saveItem(oid, item);
	}
	 
	 @ApiOperation(value = "get Item Details", produces = "application/json", consumes = "application/json" )
	  	@ApiResponses({
	  		@ApiResponse(code = 200,message = "get Item Data "),
	  		@ApiResponse(code = 400,message = "No Given Id Found")
	  		
	  	})
	 
	 
	@GetMapping("/item")
	public Responcestructure<Item> getItemById(@RequestParam int id) {
		return itemService.getItemById(id);
	}
	@GetMapping("/allitems")
	public Responcestructure<List<Item>> getAllItems(){
		return itemService.getAllItems();
	}
	@DeleteMapping("/item")
	public Responcestructure<Boolean> deleteItemById(@RequestParam int id) {
		return itemService.deleteItemById(id);
	}
	public Responcestructure<Item> updateItem(@RequestParam int id,@RequestBody Item item) {
		
		return itemService.updateItem(id, item) ;
	}
	
	@GetMapping("ji")
	public Item get() {
		return new Item();
	}

}
