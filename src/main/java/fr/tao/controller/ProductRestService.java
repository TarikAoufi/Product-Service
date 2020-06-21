package fr.tao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.tao.dao.ProductRepository;
import fr.tao.entities.Product;

/**
 * API REST: Pour gérer des produits, 
 * basée sur Spring Data REST
 *
 */
@RestController
public class ProductRestService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/listProduct") 
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	@GetMapping(value = "/listProduct/{id}") 
	public Product getProduct(@PathVariable(name = "id") Long id) {
		return productRepository.findById(id).get();
	}
	
	@PutMapping(value = "/listProduct/{id}") 
	public Product update(@PathVariable(name = "id") Long id, @RequestBody Product product) {
		product.setId(id);
		return productRepository.save(product);
	}
	
	@PostMapping(value = "/listProduct") 
	public Product save(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping(value = "/listProduct/{id}") 
	public void delete(@PathVariable(name = "id") Long id) {
		productRepository.deleteById(id);
	}

}
