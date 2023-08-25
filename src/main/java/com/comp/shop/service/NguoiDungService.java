package com.comp.shop.service;

import java.util.List;

import com.comp.shop.dto.NguoiDungDto;
import com.comp.shop.entity.NguoiDung;


public interface NguoiDungService {
	public NguoiDung convertToNguoiDung(NguoiDungDto nguoiDungDto);
	
	public NguoiDung findByEmail(String email);
	public boolean IsExistedEmail(String email);
	public void register(NguoiDungDto nguoiDungDto);
	public List<NguoiDung> getAllClient();
	public boolean login(String email, String password);
	public NguoiDung getNguoiDungFromToken(String token);
}
