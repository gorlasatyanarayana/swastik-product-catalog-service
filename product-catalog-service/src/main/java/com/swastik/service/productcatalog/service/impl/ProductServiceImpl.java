package com.swastik.service.productcatalog.service.impl;

import org.springframework.stereotype.Service;

import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public String createNewProduct(ProductRequestDto request) {
		// TODO Auto-generated method stub
		System.out.println("[Create-New-Product] entered");
		return null;
	}

}
