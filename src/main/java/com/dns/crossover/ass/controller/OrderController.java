/**
 * 
 */
package com.dns.crossover.ass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Order;
import com.dns.crossover.ass.dto.OrderDto;
import com.dns.crossover.ass.repo.IOrderRepo;
import com.dns.crossover.ass.service.OrderService;

/**
 * @author dinusha
 *
 */

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method= RequestMethod.POST)
	public OrderDto newOrder(@RequestBody Order order) {
		
		OrderDto newOrder = orderService.createOrder(order);
		return newOrder;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<OrderDto> listOrder(){
		
		return orderService.listAllOrders();
	}
}
