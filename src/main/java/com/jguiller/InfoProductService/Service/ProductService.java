package com.jguiller.InfoProductService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jguiller.InfoProductService.Model.Product;
import com.jguiller.InfoProductService.Repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	// OBTENER TODOS LOS PRODUCTOS
	public Flux<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// AGREGAR UN PRODUCTO
	public Mono<Product> addProduct(Product product) {
		return productRepository.save(product);
	}
	
	// OBTENER UN PRODUCTO POR SU ID
	public Mono<Product> getProductById(Integer id) {
		return productRepository.findById(id);
	}
	
	// EDITAR UN PRODUCTO POR ID
	public Mono<Product> updateProduct(Product product, Integer id) {
		return productRepository.findById(id).flatMap(prod -> {
			prod.setTipoProducto(product.getTipoProducto());
			prod.setProducto(product.getProducto());
			return productRepository.save(prod);
		});
	}
	
	// ELIMINAR UN PRODUCTO POR ID
	public Mono<Void> deleteProduct(Integer id) {
		return productRepository.deleteById(id);
	}

}
