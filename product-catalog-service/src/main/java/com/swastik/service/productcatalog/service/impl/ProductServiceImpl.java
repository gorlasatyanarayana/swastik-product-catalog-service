package com.swastik.service.productcatalog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.entity.ProductCatelogueEntity;
import com.swastik.service.productcatalog.repository.ProductCatelogueRepository;
import com.swastik.service.productcatalog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductCatelogueRepository productCatelogueRepository;
	
	@Override
	public String createNewProduct(ProductRequestDto request) {
		// TODO Auto-generated method stub		
		log.info("[Create-New-Product] entered {} ",request);
	
		log.info("[Create-New-Product] saving product");
		
		
		ProductCatelogueEntity productCatelogueEntity = new ProductCatelogueEntity();
		
		
		
		
		return null;
	}

}
