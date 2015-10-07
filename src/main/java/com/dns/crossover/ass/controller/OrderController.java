/**
 * 
 */
package com.dns.crossover.ass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.dto.OrderDto;
import com.dns.crossover.ass.service.OrderService;

/**
 * @author dinusha
 * Order related end points 
 */

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	/**
	 * Insert a new order 
	 * @param order 
	 * @return
	 */
	@RequestMapping(method= RequestMethod.POST)
	public OrderDto newOrder(@RequestBody OrderDto order) {
		
		OrderDto newOrder = orderService.createOrder(order);
		return newOrder;
	}
	
	
	/**
	 * List all orders
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<OrderDto> listOrder(){
		
		return orderService.listAllOrders();
	}
	
	/**
	 * Get order details for order number
	 * @param orderNo
	 * @return
	 */
	@RequestMapping(value="{orderNo}",method=RequestMethod.GET)
	public OrderDto getProduct(@PathVariable Long orderNo) {
		
		return orderService.getOrder(orderNo);
	}
	
	/**
	 * Delete order for given order number
	 * @param orderNo
	 * @return
	 */
	@RequestMapping(value="{orderNo}",method=RequestMethod.DELETE)
	public String deleteOrder(@PathVariable Long orderNo) {
		
		orderService.deleteOrder(orderNo);
		return "success";
	}
}
