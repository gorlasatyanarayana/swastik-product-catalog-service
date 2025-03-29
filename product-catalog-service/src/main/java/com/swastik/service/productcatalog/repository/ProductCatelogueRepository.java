package com.swastik.service.productcatalog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swastik.service.productcatalog.entity.ProductCatelogueEntity;

@Repository
public interface ProductCatelogueRepository extends JpaRepository<ProductCatelogueEntity, UUID>{

}
