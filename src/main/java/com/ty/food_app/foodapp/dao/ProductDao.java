package com.ty.food_app.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.food_app.foodapp.dto.Product;
import com.ty.food_app.foodapp.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct( Product product) {
		
		return productRepository.save(product);
		
		}
	public Product getProductById( int id) {
		
		 Optional<Product> optional= productRepository.findById(id);
		 if(optional.isEmpty()) {
			 return null;
		 }
		return optional.get();
		
	}
	public List<Product> getProducts(){
		
		return productRepository.findAll();
	}
	public boolean deleteProduct(int id) {
		
		Product product= getProductById(id);
		
		if(product != null) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	public Product updateProduct(int id,Product product) {
		Product existingProduct= getProductById(id);
		
		if(existingProduct != null) {
			existingProduct.setCost(product.getCost());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setFoodtype(product.getFoodtype());
			existingProduct.setImage(product.getImage());
			existingProduct.setName(product.getName());
			existingProduct.setOffer(product.getOffer());
			return productRepository.save(existingProduct);
		}
		return null;
	}

}
