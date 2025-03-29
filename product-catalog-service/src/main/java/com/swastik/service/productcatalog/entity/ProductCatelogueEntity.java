package com.swastik.service.productcatalog.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "swastikdb", name = "product_catelogue")
public class ProductCatelogueEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4132095523482914767L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true,  nullable = false)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "updated_by")
	private String updated_by;	
	
	

}
