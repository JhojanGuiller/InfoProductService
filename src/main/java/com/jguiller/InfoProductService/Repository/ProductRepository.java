package com.jguiller.InfoProductService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jguiller.InfoProductService.Model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
	
}
