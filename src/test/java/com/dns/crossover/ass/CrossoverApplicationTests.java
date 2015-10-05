package com.dns.crossover.ass;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dns.crossover.ass.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverApplication.class)
public class CrossoverApplicationTests {

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void contextLoads() {
		System.out.println("ddd");
		assertTrue(true);
	}
	
	@Test
	public void testListAllCustomer() {
		
		assertTrue(  customerService.listAllCustomer().getList().size()>0);
	}
	
	@Test
	public void/// testProjection() {
		
		//ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
		as/sertTrue(  customerService.listAllCustomerKeyVal().size()>0);
	}

}
