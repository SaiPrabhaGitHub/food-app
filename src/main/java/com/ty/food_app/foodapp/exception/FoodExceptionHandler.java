package com.ty.food_app.foodapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class FoodExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleFoodExceptionHandler(IdNotFoundException idNotFoundException){
		
		String msg=idNotFoundException.getMessage();
		
		ResponseEntity<String> responseEntity=new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		return responseEntity;
		
	}

}
