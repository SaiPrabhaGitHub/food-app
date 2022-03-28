package com.ty.food_app.foodapp.dao;



public class Responcestructure<T> {
	
	private int status;
	private String msg;
	private T data;
	public void setData(T data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}


}
