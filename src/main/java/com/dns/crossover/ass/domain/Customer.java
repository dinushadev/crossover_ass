/**
 * 
 */
package com.dns.crossover.ass.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dinusha
 *
 */
@Entity
//@RepositoryRestResource(excerptProjection = CustomerKeyVal.class)
public class Customer {
	
	@Id
	private String code ;
	private String name;
	private String address;
	private String phone1;
	private String phone2;
	private Double creditLimit;
	private Double currentCredit;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public Double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Double getCurrentCredit() {
		return currentCredit;
	}
	public void setCurrentCredit(Double currentCredit) {
		this.currentCredit = currentCredit;
	}
	
	

}
