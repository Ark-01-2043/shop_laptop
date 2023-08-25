package com.comp.shop.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import com.comp.shop.service.impl.CustomUserDetailsServiceImpl;
import com.comp.shop.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader = null; 
		String email = null;
		String token = null;
		authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			email = jwtUtil.getEmailFromToken(token);
		}
//		System.out.println(token);
		if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails customUserDetails = customUserDetailsServiceImpl.loadUserByUsername(email);
//			System.out.println(email);
			if (jwtUtil.validateToken(token, email)) {
//				System.out.println("Token ok");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
						UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
