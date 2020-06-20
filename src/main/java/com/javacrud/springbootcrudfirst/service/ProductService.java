package com.javacrud.springbootcrudfirst.service;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacrud.springbootcrudfirst.entity.Product;
import com.javacrud.springbootcrudfirst.repository.ProductRepository;


@Service
@PersistenceContext
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	//Post
	 public Product saveProduct(Product product) {
		return repository.save(product);
	 }
	 public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	 }
	 
	 //Get
	
	 public List<Product> getProducts() {
			return repository.findAll();
	 }
		
	 public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	 }
	 public Product getProductByName(String name) {
			return repository.findByName(name);
	 }
	 
	 public String deleteProduct(int id) {
		 repository.deleteById(id);
		 
		return "product removed !!" +id;
	 }
	 public Product updateProduct(Product product) {
		 Product existingProduct = repository.findById(product.getId()).orElse(null);
		 existingProduct.setName(product.getName());
		 existingProduct.setQuantity(product.getQuantity());
		 existingProduct.setPrice(product.getPrice());
		 return repository.save(existingProduct);
	 }
	
}
