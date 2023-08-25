const submitBtn = document.querySelector("#submit");
submitBtn.onclick = (e) =>{
    e.preventDefault();
    const email = document.querySelector("input[name = 'email']").value;
    const password = document.querySelector("input[name = 'password']").value;
    const confirmPassword = document.querySelector("input[name = 'confirmPassword']").value;
    const hoTen = document.querySelector("input[name = 'hoTen']").value;
    const diaChi = document.querySelector("input[name = 'diaChi']").value;
    const soDienThoai = document.querySelector("input[name = 'soDienThoai']").value;
    const maVaiTro = document.querySelector("input[name = 'maVaiTro']").value;
    const params = {
        email: email,
        password: password,
        confirmPassword: confirmPassword,
        hoTen: hoTen,
        diaChi: diaChi,
        sdt: soDienThoai,
        maVaiTro: maVaiTro
    }
    
    fetch("http://localhost:8080/register", {
        method:  "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(params)
    }
    ).then(response => {
		console.log(response);
        return response.text();
    }).then(data => {
        if (data == "Đăng kí thành công") {
            window.location.href = "http://localhost:8080/login1";
        } else {
            alert(data);
        }    
    }).catch((err) =>{
		console.log(err);
	});
}