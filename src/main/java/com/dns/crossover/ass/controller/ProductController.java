package com.dns.crossover.ass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dns.crossover.ass.domain.Customer;
import com.dns.crossover.ass.domain.ItemList;
import com.dns.crossover.ass.domain.Product;
import com.dns.crossover.ass.dto.KeyValDto;
import com.dns.crossover.ass.dto.KeyValListDto;
import com.dns.crossover.ass.service.ProductService;


/**
 * @author dinusha
 * Product related end points
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	/**
	 * Insert give product
	 * @param product The product going to be inserted 
	 * @return Inserted product details
	 */
	@RequestMapping(method= RequestMethod.POST)
	public Product	 newProduct(@RequestBody Product product) {
		
		Product saveProduct =  productService.createProduct(product);
		return saveProduct;
	}
	
	
	/** List all Product 
	 * @return all product 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ItemList<Product> listProduct() {
		
		return productService.listAllProduct();
	}
	
	
	
	/**
	 * @param  code Product code
	 * @return Delete the porduct for give product code
	 */
	@RequestMapping(value="{code}",method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable String code) {
		
		productService.deleteProduct(code);
		return "success";
	}
	
	
	/**
	 * @return Product code as a key and Product name as a value
	 */
	@RequestMapping(value="keyval",method=RequestMethod.GET)
	public KeyValListDto listKeyValProduct() {
		
		List<KeyValDto> dtos = productService.listAllProductKeyVal();
		KeyValListDto lists = new KeyValListDto();
		lists.setList(dtos);
		
		return lists;
	}
	
	/**
	 * @param code Product code
	 * @return Product details for give product code
	 */
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable String code) {
		
		return productService.getProduct(code);
	}
	
	
	/**
	 * @param code Product code
	 * @return product price give product code
	 */
	@RequestMapping(value="{code}/price",method=RequestMethod.GET)
	public Double getProductPrice(@PathVariable String code) {
		
		return productService.getProductPrice(code);
	}
	
}
