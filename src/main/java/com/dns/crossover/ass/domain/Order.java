/**
 * 
 */
package com.dns.crossover.ass.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author dinusha
 *
 */
@Entity(name="sales_order")
public class Order implements Serializable{
	
	@Id
	private Long orderNo;
	
	@ManyToOne(targetEntity=Customer.class)
	private Customer customer;
	
	@ManyToOne(targetEntity=Product.class)
	private Product product;
	
	private int quantity;
	
	private double total;
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
