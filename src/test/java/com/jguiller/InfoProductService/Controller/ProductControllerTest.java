package com.jguiller.InfoProductService.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.jguiller.InfoProductService.Model.Product;
import com.jguiller.InfoProductService.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest()
public class ProductControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void getAllProductTest() {

		Mockito
		.when(this.productService.getAllProducts())
		.thenReturn(Flux.just(new Product(1, "Cuentas Bancarias", "Ahorro"), new Product(2, "Creditos", "A plazo fijo")));

		this.webTestClient
		.get()
		.uri("/products")
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody()
		.jsonPath("$[0].idProducto").isEqualTo(1)
		.jsonPath("$[0].tipoProducto").isEqualTo("Cuentas Bancarias")
		.jsonPath("$[0].producto").isEqualTo("Ahorro")
		.jsonPath("$[1].idProducto").isEqualTo(2)
		.jsonPath("$[1].tipoProducto").isEqualTo("Creditos")
		.jsonPath("$[1].producto").isEqualTo("A plazo fijo");		
		
	}
	
	@Test
	public void getProductByIdTest() {
		
		Integer id = 1;
				
		Mockito
		.when(this.productService.getProductById(id))
		.thenReturn(Mono.just(new Product (1, "Cuentas Bancarias", "Ahorro")));
		
		this.webTestClient
		.get()
		.uri("/products/{id}", id)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody()
		.jsonPath("$..idProducto").isEqualTo(1)
		.jsonPath("$..tipoProducto").isEqualTo("Cuentas Bancarias")
		.jsonPath("$..producto").isEqualTo("Ahorro");
		
	}
	
	@Test
	public void addProductTest() {
		
		Product product = new Product (1, "Cuentas Bancarias", "Ahorro");
		
		Mockito
		.when(this.productService.addProduct(product))
		.thenReturn(Mono.just(product));
		
		this.webTestClient
		.post()
		.uri("/products/addProduct")
		.body(Mono.just(product), Product.class)
		.exchange()
		.expectStatus().isOk();
		
	}
	
	@Test
	public void updateProductTest() {
		
		Product product1 = new Product(1, "Cuentas Bancarias", "Ahorro");
		Product product2 = new Product(2, "Creditos", "A plazo fijo");
		
		webTestClient
		.put()
		.uri("/products/updateProduct/{idProducto}", product1.getIdProducto())
		.body(Mono.just(product2), Product.class)
		.exchange()
		.expectStatus().isOk();
		
	}
	
	@Test
	public void deleteProductTest() {
		
		Integer id = 1;

		webTestClient
		.delete()
		.uri("/products/deleteProduct/{id}", id)
		.exchange()
		.expectStatus().isOk();
	}

}
