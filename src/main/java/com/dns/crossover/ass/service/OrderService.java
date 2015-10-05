/**
 * 
 */
package com.dns.crossover.ass.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Order;
import com.dns.crossover.ass.dto.OrderDto;
import com.dns.crossover.ass.repo.IOrderRepo;

/**
 * @author dinusha
 *
 */
@Service
public class OrderService {
	
	@Autowired
	private IOrderRepo orderRepo;
	
	public OrderDto createOrder(Order order){
		OrderDto newOrder =new OrderDto( orderRepo.save(order));
		
		return newOrder;
	}
	
	public ItemList<OrderDto> listAllOrders(){

		Iterable<Order> list = orderRepo.findAll();
		ArrayList<OrderDto> orderList = new ArrayList<OrderDto>();
		for (Order order : list) {
			orderList.add(new OrderDto(order));
		}
		
		
		return new ItemList<OrderDto>(orderList);
	}

}
