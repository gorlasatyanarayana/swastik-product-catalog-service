package com.swastik.service.productcatalog.service;

import com.swastik.service.productcatalog.dto.ProductListResponse;
import com.swastik.service.productcatalog.dto.ProductRequestDto;
import com.swastik.service.productcatalog.dto.ProductResponse;

public interface ProductService {
	
	ProductResponse createNewProduct(ProductRequestDto request);
	ProductListResponse getAllProducts();	
	
	

}
