/**
 * 
 */
package com.dns.crossover.ass.repo;

import org.springframework.data.repository.CrudRepository;

import com.dns.crossover.ass.domain.Order;

/**
 * @author dinusha
 *
 */
public interface IOrderRepo extends CrudRepository<Order, Long> {

}
