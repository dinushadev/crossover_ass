/**
 * 
 */
package com.dns.crossover.ass.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.dto.KeyValDto;
import com.dns.crossover.ass.repo.IProductRepo;
import com.dns.crossover.ass.utill.ValidaterUtill;

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
	
	public List<KeyValDto> listAllProductKeyVal() {
		Iterable<Product> list =productRepo.findAll();
		List<KeyValDto> keyValList = new ArrayList<KeyValDto>();
		for (Product product : list) {
			KeyValDto tmp = new KeyValDto(product.getCode(),product.getDisc());
			keyValList.add(tmp);
		}
		
		return keyValList;
	}

	
	public Product getProduct(String code) {
		
		return productRepo.findOne(code);
	}

	public void deleteProduct(String code) {
		
		productRepo.delete(code);
	}

	public Double getProductPrice(String code) {
		double price = productRepo.findPriceByCode(code);
		return price;
	}

}
