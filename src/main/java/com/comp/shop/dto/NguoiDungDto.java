package com.comp.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NguoiDungDto {
private String id;
	
	@NotEmpty(message="Phải nhập địa chỉ email")
	@Email(message= "Phải nhập đúng địa chỉ email")
	private String email;

	@NotEmpty(message = "Phải nhập mật khẩu")
	private String password;
	@NotEmpty(message = "Phải nhập lại mật khẩu")
	private String confirmPassword;
	
	@NotEmpty(message="Địa chỉ không được trống")
	private String diaChi;
	
	@NotEmpty(message="Họ tên không được trống")
	private String hoTen;
	
	@NotEmpty(message="Số điện thoại không được trống")
	private String sdt;
	private long maVaiTro;
}
