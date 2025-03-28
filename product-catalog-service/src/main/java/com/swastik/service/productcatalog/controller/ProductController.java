package com.swastik.service.productcatalog.controller;

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

	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/{version}/products")
	public ResponseEntity<?> createNewProduct(@PathVariable("version") String version, @RequestBody ProductRequestDto request){
		System.out.println("Entered into createNewProduct");
		String response = productService.createNewProduct(request);
		return ResponseEntity.ok("Add a New Product");
	}
	
	
}
