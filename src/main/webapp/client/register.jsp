<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Laptop Shop - Đăng ký</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>


	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="login-page">
		<div class="form">
			<form method="POST" action='register' >
				<h2 class="form-signin-heading" style="text-align: center">LaptopShop - Đăng ký tài khoản</h2>
				<hr/>
				<div class="form-group">
					<input type="email" name="email" class="form-control"
						placeholder="Email" autofocus="true" required="required"></input>
					
				</div>

				<div class="form-group">
					<input type="password" name="password" class="form-control"
						required="required" placeholder="Mật khẩu" ></input>
					
				</div>

				<div class="form-group">
					<input type="password" name="confirmPassword"
						class="form-control" placeholder="Nhắc lại mật khẩu"
						required="required"></input>
					
				</div>

				<div class="form-group">
					<input type="text" name="hoTen" class="form-control"
						placeholder="Họ và tên" required="required"></input>
					
				</div>

				<div class="form-group">
					<input type="number" name="soDienThoai" class="form-control"
						placeholder="Số điện thoại" required="required"></input>
					
				</div>

				<div class="form-group">
					<input type="text" name="diaChi" class="form-control"
						placeholder="Địa chỉ" required="required"></input>
					
					
				</div>
				<input id="submit" type="submit" value="ĐĂNG KÝ">
				<input type="hidden" value="2" name="maVaiTro">
				<p class="message" style="font-size: 18; padding-top:10px"> Đã có tài khoản? <a href="<c:url value='/login1'/> ">Đăng nhập</a></p>
			</form>
		</div>
	</div>
	<script src="js/register.js"></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>
</html>