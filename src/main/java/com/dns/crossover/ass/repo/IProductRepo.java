package com.dns.crossover.ass.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dns.crossover.ass.domain.Product;

public interface IProductRepo extends JpaRepository<Product, String>{

	

	
	@Query("select u.price from Product u where u.code = ?1")
	Double findPriceByCode(String  code);


}
