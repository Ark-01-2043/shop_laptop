package com.comp.shop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.shop.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductApi {
	@Autowired
	private ProductService productService;
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
}
