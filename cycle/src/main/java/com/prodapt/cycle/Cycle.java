package com.prodapt.cycle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String brand;
    private int stock;
    private boolean available;

	public void setAvailable(boolean b) {
		available = b;
	}

	public boolean isAvailable() {
	
		return available;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


}
