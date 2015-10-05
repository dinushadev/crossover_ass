package com.dns.crossover.ass.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="cusKeyVal",types={Customer.class})
public interface CustomerKeyVal {

	public String getName() ;
	
	public String getCode() ;
}
