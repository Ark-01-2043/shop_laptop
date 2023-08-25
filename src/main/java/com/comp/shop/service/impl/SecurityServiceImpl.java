package com.comp.shop.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;


import com.comp.shop.service.SecurityService;
import com.comp.shop.entity.*;
@Service
public class SecurityServiceImpl implements SecurityService{
	@Autowired
	private CustomUserDetailsServiceImpl userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public String getEmailOfLoginUser() {
		// TODO Auto-generated method stub
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication: " + authentication);
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			System.out.println("Dang xuat thanh cong");
		}
	}

}
