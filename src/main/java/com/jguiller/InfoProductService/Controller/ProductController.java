package com.jguiller.InfoProductService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jguiller.InfoProductService.Model.Product;
import com.jguiller.InfoProductService.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// OBTENER TODOS LOS PRODUCTOS
	@GetMapping
	public Flux<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	// AGREGAR UN PRODUCTO
	@PostMapping("/addProduct")
	public Mono<Product> createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	// OBTENER UN PRODUCTO POR SU ID
	@GetMapping("/{idProducto}")
	public Mono<Product> getProductoById(@PathVariable(value = "idProducto") int id) {
		return productService.getProductById(id);
	}
	
	// EDITAR UN PRODUCTO POR ID
	@PutMapping("/updateProduct/{idProducto}")
	public Mono<Product> updateProducto(@RequestBody Product product, @PathVariable(value = "idProducto") int id) {
		return productService.updateProduct(product, id);
	}
	
	// ELIMINAR UN PRODUCTO POR ID
	@DeleteMapping("/deleteProduct/{idProducto}")
	public Mono<Void> deleteProductById(@PathVariable(value = "idProducto") int id) {
		return productService.deleteProduct(id);
	}

}
