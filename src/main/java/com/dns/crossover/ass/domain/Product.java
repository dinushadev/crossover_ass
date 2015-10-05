/**
 * 
 */
package com.dns.crossover.ass.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dinusha
 *
 */
@Entity
public class Product {
	
	@Id
	private String code;
	private String disc;
	private double price;
	private int quantity;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
