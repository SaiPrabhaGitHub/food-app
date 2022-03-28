package com.ty.food_app.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.foodapp.dao.ProductDao;
import com.ty.food_app.foodapp.dao.Responcestructure;
import com.ty.food_app.foodapp.dto.Product;
import com.ty.food_app.foodapp.exception.IdNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Responcestructure<Product> saveProduct(Product  product) {
		Product product2= productDao.saveProduct(product);
		
		if(product2 == null) {
			throw new IdNotFoundException();
		}
		
		Responcestructure< Product> responcestructure=new Responcestructure<Product>();
		responcestructure.setData(product2);
		responcestructure.setMsg("Product Is Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	
	public Responcestructure<Product> getProductById(int id) {
		
		Product product= productDao.getProductById(id);
		
		if(product ==null) {
			throw new IdNotFoundException("No Id "+id+"Not exist");
		}
		
		Responcestructure<Product> responcestructure=new Responcestructure<Product>();
		responcestructure.setData(product);
		responcestructure.setMsg("Getting Product By Id");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	public Responcestructure<List<Product>> getAllProducts(){
		List<Product> products= productDao.getProducts();
		
		if(products.isEmpty()) {
			throw new IdNotFoundException("Product Id Is NotFound");
		}
		Responcestructure<List<Product>> responcestructure=new Responcestructure<List<Product>>();
		responcestructure.setData(products);
		responcestructure.setMsg("Products Are Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
		
	}
	public Responcestructure<Boolean> deletePrpduct(int id) {
			
		Boolean b= productDao.deleteProduct(id);
		
		if(b == null) {
			
			throw new IdNotFoundException("Product Id Is Incorrect");
		}
		Responcestructure<Boolean> responcestructure=new Responcestructure<Boolean>();
		responcestructure.setData(b);
		responcestructure.setMsg("  Saved");
		responcestructure.setStatus(HttpStatus.OK.value());
		return responcestructure;
	}
	
	
}
