package com.jguiller.InfoProductService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jguiller.InfoProductService.Model.Product;
import com.jguiller.InfoProductService.Repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository prodRepository;
	
	private ResponseEntity<Product> notFound = ResponseEntity.notFound().build();
	
	// OBTENER TODOS LOS PRODUCTOS
	@GetMapping
	public Flux<Product> getProducts(){
		return prodRepository.findAll();
	}
	
	// CREAR UN PRODUCTO
	@PostMapping("/addProduct")
	public Mono<Product> createProduct(@RequestBody Product product) {
		return prodRepository.save(product);
	}
	
	// OBTENER UN PRODUCTO POR SU ID
	@GetMapping("/{idProducto}")
	public Mono<ResponseEntity<Product>> getProductById(@PathVariable(value = "idProducto") int id) {
		return prodRepository.findById(id)
				.map(producto -> new ResponseEntity<Product>(producto, HttpStatus.OK))
				.defaultIfEmpty(notFound);
	}
	
	// EDITAR UN PRODUCTO POR ID
	@PutMapping("/updateProduct/{idProducto}")
	public Mono<ResponseEntity<Product>> updateProduct(@RequestBody Product product, @PathVariable(value = "idProducto") int id) {
		return prodRepository.findById(id).flatMap(prod -> {
			prod.setTipoProducto(product.getTipoProducto());
			prod.setProducto(product.getProducto());
			return prodRepository.save(prod);
		}).map(prod1 -> new ResponseEntity<Product>(prod1, HttpStatus.OK)).defaultIfEmpty(notFound);
	}
	
	// ELIMINAR UN PRODUCTO POR ID
	@DeleteMapping("/deleteProduct/{idProducto}")
	public Mono<Void> deleteProductById(@PathVariable(value = "idProducto") int id) {
		return prodRepository.deleteById(id);
	}

}
