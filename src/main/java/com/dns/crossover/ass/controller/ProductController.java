package com.dns.crossover.ass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.dto.KeyValDto;
import com.dns.crossover.ass.dto.KeyValListDto;
import com.dns.crossover.ass.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method= RequestMethod.POST)
	public Product	 newProduct(@RequestBody Product product) {
		
		Product saveProduct =  productService.createProduct(product);
		return saveProduct;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<Product> listProduct() {
		
		return productService.listAllProduct();
	}
	
	@RequestMapping(value="keyval",method=RequestMethod.GET)
	public KeyValListDto listKeyValProduct() {
		
		List<KeyValDto> dtos = productService.listAllProductKeyVal();
		KeyValListDto lists = new KeyValListDto();
		lists.setList(dtos);
		
		return lists;
	}
	
}
