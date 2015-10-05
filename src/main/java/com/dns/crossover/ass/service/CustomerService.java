/**
 * 
 */
package com.dns.crossover.ass.service;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.CustomerKeyVal;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.dto.ComboBoxItem;
import com.dns.crossover.ass.repo.ICustomerRepo;

/**
 * @author dinusha
 *
 */
@Service
public class CustomerService {

	@Autowired
	private ICustomerRepo customerRepo;
	
	public Customer createCustomer(Customer cus) {
	Customer saveCus = customerRepo.save(cus);
		
		return saveCus;
	}

	public ItemList<Customer> listAllCustomer() {
		
		ItemList<Customer> list = new ItemList<Customer>( IteratorUtils.toList(customerRepo.findAll().iterator()));
		
		return list;
				
	}

	public List<CustomerKeyVal> listAllCustomerKeyVal() {
		List<CustomerKeyVal> list =customerRepo.getKeyVal();
		return list;
	}
}
