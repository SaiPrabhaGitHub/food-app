package com.ty.food_app.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Product;
import com.ty.food_app.foodapp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
	
	
	@Autowired
	 private ProductService productService;
	
	 @ApiOperation(value = "Save The Product Details" ,produces = "application/json",consumes = "application/json")
		
		@ApiResponses({
			@ApiResponse(code = 200,message = "Product Saved"),
			@ApiResponse(code = 400,message = "Bad Request,Not Proper Product Data")
		})
	
	
	
	@PostMapping("/product")	
	public Responcestructure<Product> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	 
	 @ApiOperation(value = "get Product Details", produces = "application/json", consumes = "application/json" )
	  	@ApiResponses({
	  		@ApiResponse(code = 200,message = "get Product Data "),
	  		@ApiResponse(code = 400,message = "No Given Id Found")
	  		
	  	})
	 
	@GetMapping("/product")
	public Responcestructure<Product> getProductById(@RequestParam int id) {
		return productService.getProductById(id);
	}
	@GetMapping("/allproducts")
	public  Responcestructure<List<Product>>  getAllProducts(){
		return productService.getAllProducts();
	}
	public Responcestructure<Boolean> deleteProductById(@RequestParam int id) {
		return productService.deletePrpduct(id);
		
	}
	

}
