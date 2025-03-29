package com.swastik.service.productcatalog.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.service.productcatalog.dto.Product;
import com.swastik.service.productcatalog.dto.ProductListResponse;
import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.dto.ProductResponse;
import com.swastik.service.productcatalog.entity.ProductCatelogueEntity;
import com.swastik.service.productcatalog.repository.ProductCatelogueRepository;
import com.swastik.service.productcatalog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductCatelogueRepository productCatelogueRepository;
	
	@Override
	public ProductResponse createNewProduct(ProductRequestDto request) {
		
		ProductResponse response = null;
		// TODO Auto-generated method stub		
		log.info("[Create-New-Product] entered {} ",request);
	
		log.info("[Create-New-Product] saving product");
		ProductCatelogueEntity productCatelogueEntity  = new ProductCatelogueEntity();
		productCatelogueEntity.setCategory(request.getCategory());
		productCatelogueEntity.setName(request.getName());
		productCatelogueEntity.setPrice(request.getPrice());
		productCatelogueEntity.setDescription(request.getDescription());
		productCatelogueEntity.setStock(request.getStock());
		
		productCatelogueEntity.setCreatedBy("Product Service");
		productCatelogueEntity.setCreatedAt(LocalDateTime.now());	
		productCatelogueEntity = productCatelogueRepository.save(productCatelogueEntity);
		
		
		if(productCatelogueEntity !=null && productCatelogueEntity.getId() != null) {
			log.info("[Create-New-Product] prodcut added successfully with product id : {} ",productCatelogueEntity.getId());
			response = ProductResponse.builder().success(true).productId(productCatelogueEntity.getId().toString()).build();
		} else {	
			log.info("[Create-New-Product] failed to create product");
			response = ProductResponse.builder().success(false).productId(null).build();
		}
		
		
		return response;
	}

	@Override
	public ProductListResponse getAllProducts() {
		// TODO Auto-generated method stub
		ProductListResponse response = null;
		// TODO Auto-generated method stub		
		log.info("[Get-All-Products] entered");
	
		log.info("[Get-All-Products] fetching all available products");
		List<ProductCatelogueEntity> productList = productCatelogueRepository.findAll();
		if(productList != null && productList.size()>0) {
			log.info("[Get-All-Products] products are available");
			response  = ProductListResponse.builder().success(true).productList(
					
					productList.stream().map(pc -> Product.builder().id(pc.getId().toString()).build()).toList()
					
					).build();
			
		} else {
			log.info("[Get-All-Products] products not available");
			response = ProductListResponse.builder().success(true).build();
			
			
		}
		
		
		
		return response;
	}

}
