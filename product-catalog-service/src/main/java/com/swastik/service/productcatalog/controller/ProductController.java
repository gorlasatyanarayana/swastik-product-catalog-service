package com.swastik.service.productcatalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
			
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/{version}/products")
	public ResponseEntity<?> createNewProduct(@PathVariable("version") String version, @RequestBody ProductRequestDto request){
		log.info("Entered in method-createNewProduct of class-ProductController");
		String response = productService.createNewProduct(request);
		return ResponseEntity.ok("Add a New Product");
	}
	 
	
}
