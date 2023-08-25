package com.comp.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.shop.entity.DanhMuc;
import com.comp.shop.repository.CategoryRepository;
import com.comp.shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<DanhMuc> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
