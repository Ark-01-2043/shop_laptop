package com.comp.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp.shop.entity.VaiTro;


@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	public VaiTro findByTenVaiTro(String tenVaiTro);
}
