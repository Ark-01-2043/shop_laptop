package com.comp.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp.shop.entity.DanhMuc;
@Repository
public interface CategoryRepository extends JpaRepository<DanhMuc, Long>{
	public List<DanhMuc> findAll();
}
