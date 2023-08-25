package com.comp.shop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.comp.shop.dto.NguoiDungDto;
import com.comp.shop.entity.NguoiDung;
import com.comp.shop.entity.VaiTro;
import com.comp.shop.repository.NguoiDungRepository;
import com.comp.shop.repository.VaiTroRepository;
import com.comp.shop.service.NguoiDungService;
import com.comp.shop.util.JwtUtil;

import lombok.Builder;


@Service
public class NguoiDungServiceImpl implements NguoiDungService {
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	@Autowired
	private VaiTroRepository vaiTroRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Override
	public NguoiDung findByEmail(String email) {
		return nguoiDungRepository.findByEmail(email);
	}
	@Override
	public NguoiDung convertToNguoiDung(NguoiDungDto nguoiDungDto) {
		Set<VaiTro> roles = new HashSet<>();
		roles.add(vaiTroRepository.findById(nguoiDungDto.getMaVaiTro()).get());
		
		return NguoiDung.builder()
				.email(nguoiDungDto.getEmail())
				.password(passwordEncoder.encode(nguoiDungDto.getPassword()))
				.hoTen(nguoiDungDto.getHoTen())
				.diaChi(nguoiDungDto.getDiaChi())
				.soDienThoai(nguoiDungDto.getSdt())
				.vaiTro(roles)
				.build();
	}
	@Override
	public void register(NguoiDungDto nguoiDungDto) {
		
		nguoiDungRepository.save(convertToNguoiDung(nguoiDungDto));
	}
	@Override
	public List<NguoiDung> getAllClient(){
		return nguoiDungRepository.findAll();
	}
	@Override
	public boolean IsExistedEmail(String email) {
		// TODO Auto-generated method stub
		return nguoiDungRepository.existsByEmail(email);
	}
	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println(passwordEncoder.encode(password));
		return nguoiDungRepository.existsByEmailAndPassword(email, passwordEncoder.encode(password));
	}
	@Override
	public NguoiDung getNguoiDungFromToken(String token) {
		// TODO Auto-generated method stub
		String email = jwtUtil.getEmailFromToken(token);
		if (email != null) {
			return nguoiDungRepository.findByEmail(email);
		}
		return null;
	}
	
}
