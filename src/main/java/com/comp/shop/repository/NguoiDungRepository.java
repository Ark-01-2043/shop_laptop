package com.comp.shop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp.shop.entity.NguoiDung;
import com.comp.shop.entity.VaiTro;
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{

	NguoiDung findByEmail(String email);

//	Page<NguoiDung> findByVaiTro(Set<VaiTro> vaiTro, Pageable of);
	boolean existsByEmail(String email);
	List<NguoiDung> findByVaiTro(VaiTro vaiTro);
	boolean existsByEmailAndPassword(String email, String password);
}
