package com.swastik.service.productcatalog.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swastik.service.productcatalog.dto.CustomError;
import com.swastik.service.productcatalog.dto.ProductListResponse;
import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.dto.ProductResponse;
import com.swastik.service.productcatalog.service.ProductService;
import com.swastik.service.productcatalog.service.TokenService;


@RestController
@RequestMapping("/api")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
			
	@Autowired
	ProductService productService;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping(value = "/{version}/products")
	public ResponseEntity<?> createNewProduct(@RequestHeader("Authorization") String token, @PathVariable("version") String version, @RequestBody ProductRequestDto request){
		log.info("Entered in method-createNewProduct of class-ProductController");
		ProductResponse response = productService.createNewProduct(request);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{version}/products")
	public ResponseEntity<?> getAllAvailableProducts(@RequestHeader("Authorization") String token, @PathVariable("version") String version){
		log.info("Entered in method-createNewProduct of class-ProductController");
		
		if (tokenService.validateToken(token)) {
			ProductListResponse response = productService.getAllProducts();
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.ok(ProductListResponse.builder().success(false).
					errors(Collections.singletonList(CustomError.builder().message("Token in invalid").build())
							
							).build());
		}
		
		
		
	}
	 
	
}
