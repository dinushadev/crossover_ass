package com.dns.crossover.ass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.dto.KeyValDto;
import com.dns.crossover.ass.dto.KeyValListDto;
import com.dns.crossover.ass.service.CustomerService;



/**
 * @author dinusha
 * Customer related endpoints 
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	
	
	/**
	 * Insert new customer
	 * @param cus customer who is going to insert
	 * @return inserted customer
	 */
	@RequestMapping( method=RequestMethod.POST)
	public Customer	newCustomer(@RequestBody Customer cus) {
	  return customerService.createCustomer(cus);
	
	}
	
	/**
	 * Get all customers
	 * @return All customers in the system
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<Customer> listCustomer() {
		
		return customerService.listAllCustomer();
	}
	
	
	
	/**
	 * Get customer for given customer code
	 * @param code Customer code
	 * @return Customer details for given customer code
	 */
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable String code) {
		
		return customerService.getCustomer(code);
	}
	
	
	
	/**
	 * Delete the customer for given customer code 
	 * @param code  Customer code
	 * @return 
	 */
	@RequestMapping(value="{code}",method=RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable String code) {
		
		customerService.deleteCustomer(code);
		return "success";
	}
	
	
	/**
	 * @return Customer code as a key and Customer name as a value
	 */
	@RequestMapping(value="keyval",method=RequestMethod.GET)
	public KeyValListDto listCustomerKeyVal() {
		List<KeyValDto> dtos = customerService.listAllCustomerKeyVal();
		KeyValListDto lists = new KeyValListDto();
		lists.setList(dtos);
		
		return lists;
	}
}
