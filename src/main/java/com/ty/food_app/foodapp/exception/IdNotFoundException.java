package com.ty.food_app.foodapp.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message="No Id Found";
	
	public IdNotFoundException(){
		
	}
	public IdNotFoundException(String msg) {
		this.message=msg;
	}
	@Override
	public String getMessage() {
		return  message;
	}

}
