package com.ty.food_app.foodapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String costomer_name;
	private long costomer_phone;
	@CreationTimestamp
	private LocalDateTime dateTime;
	private String status;
	private double totalCost;
	
	@OneToMany(mappedBy = "orders",cascade=	CascadeType.ALL)
	private List<Item> items;
	
	@ManyToOne
	@JoinColumn
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCostomer_name() {
		return costomer_name;
	}
	public void setCostomer_name(String costomer_name) {
		this.costomer_name = costomer_name;
	}
	public long getCostomer_phone() {
		return costomer_phone;
	}
	public void setCostomer_phone(long costomer_phone) {
		this.costomer_phone = costomer_phone;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@JsonIgnore
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
