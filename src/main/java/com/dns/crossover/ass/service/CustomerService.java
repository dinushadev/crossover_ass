/**
 * 
 */
package com.dns.crossover.ass.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.dto.KeyValDto;
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

		ItemList<Customer> list = new ItemList<Customer>(
				IteratorUtils.toList(customerRepo.findAll().iterator()));

		return list;
	}

	public List<KeyValDto> listAllCustomerKeyVal() {
		Iterable<Customer> list = customerRepo.findAll();
		List<KeyValDto> keyValList = new ArrayList<KeyValDto>();
		for (Customer customer : list) {
			KeyValDto tmp = new KeyValDto(customer.getCode(),
					customer.getName());
			keyValList.add(tmp);
		}

		return keyValList;
	}
}
