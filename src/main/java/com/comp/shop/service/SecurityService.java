package com.comp.shop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityService {
	public boolean login(String email, String password);
	public String getEmailOfLoginUser();
	public void logout(HttpServletRequest request, HttpServletResponse response); 
}
