package com.dns.crossover.ass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.dto.ComboBoxItem;
import com.dns.crossover.ass.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping( method=RequestMethod.POST)
	public Customer	newCustomer(@RequestBody Customer cus) {
	  return customerService.createCustomer(cus);
	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<Customer> listCustomer() {
		
		return customerService.listAllCustomer();
	}
	/*
	@RequestMapping(value="keyval",method=RequestMethod.GET)
	public List<ComboBoxItem> listCustomerKeyVal() {
		
		return customerService.listAllCustomerKeyVal();
	}*/
}
