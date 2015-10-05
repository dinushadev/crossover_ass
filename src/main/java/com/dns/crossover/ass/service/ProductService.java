/**
 * 
 */
package com.dns.crossover.ass.service;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.repo.IProductRepo;

/**
 * @author dinusha
 *
 */
@Service
public class ProductService {
	
	@Autowired
	private IProductRepo productRepo;
	

	public Product createProduct(Product product) {
	Product saveProduct = productRepo.save(product);
		
		return saveProduct;
	}

	public ItemList<Product> listAllProduct() {
		
		ItemList<Product> list = new ItemList<Product>( IteratorUtils.toList(productRepo.findAll().iterator()));
		
		return list;
				
	}

}
