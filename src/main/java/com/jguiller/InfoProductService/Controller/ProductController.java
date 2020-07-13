package com.jguiller.InfoProductService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jguiller.InfoProductService.Model.Product;
import com.jguiller.InfoProductService.Repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository prodRepository;
	
	@PostMapping("/addProduct")
	public String saveProduct(@RequestBody Product prod) {
		prodRepository.save(prod);
		return "Product add successfully: " + prod.getId();
	}
	
	@GetMapping("/findAllProducts")
	public List<Product> getProducts(){
		return prodRepository.findAll();
	}
	
	@GetMapping("/findProduct/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		return prodRepository.findById(id);
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		prodRepository.deleteById(id);
		return "Deleted product successfully: " + id;
	}

}
