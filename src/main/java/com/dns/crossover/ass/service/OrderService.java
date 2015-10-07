/**
 * 
 */
package com.dns.crossover.ass.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BadRequestException;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Order;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.dto.OrderDto;
import com.dns.crossover.ass.repo.ICustomerRepo;
import com.dns.crossover.ass.repo.IOrderRepo;
import com.dns.crossover.ass.repo.IProductRepo;
import com.dns.crossover.ass.utill.ValidaterUtill;

/**
 * @author dinusha
 *
 */
@Service
public class OrderService {
	
	@Autowired
	private IOrderRepo orderRepo;
	
	@Autowired
	private IProductRepo  productRepo;
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	
	@Autowired
	private ValidaterUtill validaterUtill;
	
	public OrderDto createOrder(OrderDto order){
		
		Order newOrder = new Order();
		Product product = productRepo.findOne(order.getProductCode());
		Customer customer = customerRepo.findOne(order.getCustomerCode());
		
		//order validations
		boolean isProductAvailable  = validaterUtill.validateOrderQuentity(newOrder.getQuantity(), product.getQuantity());
		
		if(!isProductAvailable) throw new BadRequestException("Not enough stocks");
		
		boolean isCustomerCreditLimit = validaterUtill.validateUserCredit(customer, order.getTotal());
		
		if(!isCustomerCreditLimit) throw new BadRequestException("Exceed customer credit limit");
		
		
		newOrder.setProduct(product);
		newOrder.setCustomer(customer);
		
		newOrder.setOrderNo(order.getOrderNo());
		newOrder.setQuantity(order.getQuantity());
		newOrder.setTotal(order.getTotal());
		
		OrderDto saveOrder =new OrderDto( orderRepo.save(newOrder));
		
		//update the customer current credit
		customer.setCurrentCredit(customer.getCurrentCredit()+ order.getTotal());
		customerRepo.save(customer);
		
		//update the product inventory 
		product.setQuantity(product.getQuantity() - order.getQuantity());
		productRepo.save(product);
		return saveOrder;
	}
	
	public ItemList<OrderDto> listAllOrders(){

		Iterable<Order> list = orderRepo.findAll();
		ArrayList<OrderDto> orderList = new ArrayList<OrderDto>();
		for (Order order : list) {
			orderList.add(new OrderDto(order));
		}
		
		return new ItemList<OrderDto>(orderList);
	}

	public OrderDto getOrder(Long orderNo) {
		Order order = orderRepo.findOne(orderNo);
		OrderDto orderDto = new OrderDto(order);
		return orderDto;
	}

	public void deleteOrder(Long orderNo) {
		orderRepo.delete(orderNo);
	}

}
