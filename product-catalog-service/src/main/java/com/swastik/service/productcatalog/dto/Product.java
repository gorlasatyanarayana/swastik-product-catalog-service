package com.swastik.service.productcatalog.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {	
	
	private String id;	
	private String name;
	private String description;
	private BigDecimal price;	
	private String category;	
	private int stock;

}
