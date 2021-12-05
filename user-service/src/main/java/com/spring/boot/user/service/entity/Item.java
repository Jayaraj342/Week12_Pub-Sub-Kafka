package com.spring.boot.user.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private Integer id;
	
	private String name;
	private int numberOfItemsAvailable;
	private int price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfItemsAvailable() {
		return numberOfItemsAvailable;
	}

	public void setNumberOfItemsAvailable(int numberOfItemsAvailable) {
		this.numberOfItemsAvailable = numberOfItemsAvailable;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getName() + " price: " + getPrice() + " ";
	}
}
