package com.dns.crossover.ass.utill;

import org.springframework.stereotype.Component;

import com.dns.crossover.ass.domain.Customer;


/**
 * @author dinusha
 *
 */
@Component
public class ValidaterUtill {
	
	
	/**
	 * @param requestQuantity Requested quantity of the order 
	 * @param currentQuantity Available quantity of the product  
	 * @return If requested quantity <= current quantity return true otherwise return false
	 */
	public boolean validateOrderQuentity(Integer requestQuantity, Integer currentQuantity){
		boolean status = false;
		if(requestQuantity <= currentQuantity){
			status = true;
		}
		
		return status;
	}
	
	
	/**
	 * Check whether the user's credit limit not exceeded for current orderTotal   
	 * @param customer Customer who made the order
	 * @param orderTotal Total price of the order
	 * @return true if user can proceed the order otherwise return false
	 */
	public boolean validateUserCredit(Customer customer,Double orderTotal ){
		boolean status = false;
		if((customer.getCreditLimit() -customer.getCurrentCredit()) >= orderTotal){
			status =true;
			
		}
		
		return status;
	}

}
