// uy^&UY
const submitBtn = document.querySelector("#submit");
submitBtn.onclick = (e) => {
	e.preventDefault();
	const email = document.querySelector("input[name = 'email']").value;
	const password = document.querySelector("input[name = 'password']").value;
	const params = {
		email: email,
		password: password
	}
	fetch("http://localhost:8080/login1", {
		method:  "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(params)
	}).then(response =>{
		console.log(response);
		
		return response.text();
	}).then(data => {
		console.log(data);
		if(data == "Sai thông tin đăng nhập"){
			window.location.href = "http://localhost:8080/login1?error";
		}
		else{
			localStorage.setItem("userToken", data);
			window.location.href = "http://localhost:8080";
			
		}
	})
}