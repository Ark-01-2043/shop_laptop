package com.comp.shop.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.shop.entity.DanhMuc;
import com.comp.shop.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryApi {
	@Autowired
	private CategoryService categoryService;
	@GetMapping
	public ResponseEntity<?> getAllCategories(){
		List<DanhMuc> danhMucs = categoryService.getAllCategories();
		Map<String, Object> map = new HashMap<>();
		map.put("categories", danhMucs);
		return ResponseEntity.ok(map);
	}
	
}
