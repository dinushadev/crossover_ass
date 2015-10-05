/**
 * 
 */
package com.dns.crossover.ass.repo;


import org.springframework.data.repository.CrudRepository;

import com.dns.crossover.ass.domain.Customer;

/**
 * @author dinusha
 *
 */
public interface ICustomerRepo extends CrudRepository<Customer,String>{

	

	
}
