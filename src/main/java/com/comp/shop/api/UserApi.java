package com.comp.shop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.shop.entity.NguoiDung;
import com.comp.shop.service.NguoiDungService;

@RestController
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	private NguoiDungService nguoiDungService;
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
	public ResponseEntity<?> getUser(@PathVariable Long id){
		NguoiDung nguoiDung = new NguoiDung();
		
		return ResponseEntity.ok(nguoiDung);
	}
}
