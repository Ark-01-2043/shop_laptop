package com.comp.shop.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.comp.shop.dto.LoginDto;
import com.comp.shop.dto.NguoiDungDto;
import com.comp.shop.entity.NguoiDung;
import com.comp.shop.service.SecurityService;
import com.comp.shop.service.impl.NguoiDungServiceImpl;
import com.comp.shop.util.JwtUtil;




@Controller
@RequestMapping
public class AuthController {
	@Autowired
	private NguoiDungServiceImpl nguoiDungService;
	
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private SecurityService securityService;
	
	
    @GetMapping("/login1")
    public String getLoginPage(){
    	
    	
//        System.out.println("login ");
        return "client/login";
    }
    @PostMapping("/login1")
    public ResponseEntity<String> loginAsClient(@RequestBody LoginDto logindto){
//    	System.out.println("login1");
    	String email = logindto.getEmail();
    	String password = logindto.getPassword();
//    	System.out.println(password);
        if (securityService.login(email, password)) {
        	String token = jwtUtils.createToken(email);
//        	Map<String, Object> tokenMap = new HashMap<>();
//        	tokenMap.put("token", token);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } else {
//        	System.out.println("Dang nhap that bai");
//        	Map<String, Object> error = new HashMap<>();
//        	error.put("error", "Sai thông tin đăng nhập");
            
        	return new ResponseEntity<>("Sai thông tin đăng nhập", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/logout1")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
    	securityService.logout(request, response);
    	return "redirect:/login1?logout";
    }
    @GetMapping("/register")
    public String getRegisterPage() {
    	return "client/register";
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerAClientAcc(@RequestBody NguoiDungDto nguoiDungDto){
    	if (nguoiDungDto.getEmail() == null || nguoiDungDto.getPassword() == null || nguoiDungDto.getConfirmPassword() == null || nguoiDungDto.getHoTen() == null || nguoiDungDto.getDiaChi() == null || nguoiDungDto.getSdt() == null) {
//			System.out.println(nguoiDungDto);
    		return new ResponseEntity<>("Vui lòng điền đầy đur thông tin", HttpStatus.BAD_REQUEST);
		}
    	if (nguoiDungService.IsExistedEmail(nguoiDungDto.getEmail())) {
			return new ResponseEntity<>("Email đã được đăng kí", HttpStatus.BAD_REQUEST);
		} else if (!nguoiDungDto.getConfirmPassword().equals(nguoiDungDto.getPassword())) {
			return new ResponseEntity<>("Mật khẩu nhập lại không khớp", HttpStatus.BAD_REQUEST);
		}
    	nguoiDungService.register(nguoiDungDto);
    	return ResponseEntity.ok().body("Đăng kí thành công");
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllClient(){
    	return ResponseEntity.ok(nguoiDungService.getAllClient());
    }
    @GetMapping("/")
    public String getHomePage(){
    	return "client/home";
    }
    @GetMapping("/admin")
    public String getAdminPage(){
    	return "client/admin";
    }
    @GetMapping("/accessDenied")
    public String getPage() {
    	return "client/accessDenied";
    }
    @GetMapping("/token")
    public ResponseEntity<?> getLoginUser(@RequestParam("token") String token) {
    	if (token == null) {
			return new ResponseEntity<>("Không có token", HttpStatus.BAD_REQUEST);
		}
    	return ResponseEntity.ok(nguoiDungService.getNguoiDungFromToken(token));
    }
}
