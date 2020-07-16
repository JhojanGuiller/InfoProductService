package com.jguiller.InfoProductService.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jguiller.InfoProductService.Model.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, Integer> {

}
