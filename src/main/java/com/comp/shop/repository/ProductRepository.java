package com.comp.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.shop.entity.SanPham;

public interface ProductRepository extends JpaRepository<SanPham, Long>{
	
}
