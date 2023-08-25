package com.comp.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.comp.shop.entity.SanPham;
import com.comp.shop.repository.ProductRepository;
import com.comp.shop.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<SanPham> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	
}
