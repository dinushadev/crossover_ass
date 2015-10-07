package com.dns.crossover.ass.dto;

import com.dns.crossover.ass.domain.Order;


/**
 * @author dinusha
 *
 */

public class OrderDto {
	
	
	private Long orderNo;
	
	private String customerCode;
	
	private String productCode;
	private int quantity;
	private double total;
	
	public OrderDto() {
	}
	
	public OrderDto(Order order ) {
		this.orderNo = order.getOrderNo();
		this.customerCode = order.getCustomer().getCode();
		this.productCode = order.getProduct().getCode();
		this.quantity = order.getQuantity();
		this.total = order.getTotal();
	}
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
