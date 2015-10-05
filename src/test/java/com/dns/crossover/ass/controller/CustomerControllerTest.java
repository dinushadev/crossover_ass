/**
 * 
 */
package com.dns.crossover.ass.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dns.crossover.ass.service.CustomerService;

/**
 * @author dinusha
 *
 */
public class CustomerControllerTest {

	/**
	 * Test method for {@link com.dns.crossover.ass.controller.CustomerController#newCustomer(com.dns.crossover.ass.domain.Customer)}.
	 */
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testNewCustomer() {
	 	//assertTrue(  customerService.listAllCustomer().getList().size()>0);
	}

}
