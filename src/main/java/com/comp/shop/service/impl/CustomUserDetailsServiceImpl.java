package com.comp.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.comp.shop.entity.CustomUserDetails;
import com.comp.shop.entity.NguoiDung;
import com.comp.shop.repository.NguoiDungRepository;
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(username);
		if (nguoiDung == null) {
			throw new UsernameNotFoundException("Email không tồn tại");
		}
		return CustomUserDetails.convertToUserDetails(nguoiDung);
	}

}
