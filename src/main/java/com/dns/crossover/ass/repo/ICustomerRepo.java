/**
 * 
 */
package com.dns.crossover.ass.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.CustomerKeyVal;

/**
 * @author dinusha
 *
 */
public interface ICustomerRepo extends CrudRepository<Customer,String>{

	 @Query("select count(p) from Customer c ")
	List<CustomerKeyVal> getKeyVal();

	
}
