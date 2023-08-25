function loadMenu(){
	fetch("http://localhost:8080/api/category", {
		method:  "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        credentials: 'include',
	}).then(response =>{
		
		
		if(response.ok){
			response.json().then(categories =>{
				let content = `<ul>\n`;
				list = categories.categories;
				
				list.forEach(category => {
					
					content += `<li><a href='` + `/product/category/` + category.id + `'>` + category.tenDanhMuc + `</a></li>\n`;
				});
				content += `</ul>\n`;
				
				const categoryList = document.querySelector("#categoryList");
				categoryList.innerHTML += content;
				categoryList.append(content);
			})
			
		}
		else{
			alert("loi: " + response);
		}
	}).catch(err =>{
		alert("err " + err);
	})
}
function logout(e){
	e.preventDefault();
	localStorage.removeItem("userToken");
	fetch("http://localhost:8080/logout1", {
		method:  "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        credentials: 'include',
	}).then(response => {
		console.log("Dang xuat thanh cong");
		
	})
}
function loadProducts(){
	
}
$(document).ready(() => {
	loadMenu();
	const userToken = localStorage.getItem("userToken");
	const toolbar = document.querySelector(".toolbar ul");
	console.log(userToken);
	if(userToken === null || userToken === undefined){
		console.log("chua dang nhap");
		toolbar.innerHTML += `<li><a href="/login"> Đăng nhập </a></li>\n
				<li><a href="/signup">Đăng ký</a></li>`;
	} else{
		console.log("token " + userToken);
		fetch("http://localhost:8080/token?token=" + userToken, {
			method:  "GET",
	        headers: {
	            'Accept': 'application/json',
	            'Content-Type': 'application/json',
	            'Authorization': 'Bearer ' + userToken
	        },
	        credentials: 'include',		
		}).then(response =>{
			return response.json();
		}).then(data =>{
			console.log(data);
			var content = `<li class="text-nowrap">
						<a class="nav-link"
						href="/history/` + data.id + `"> ` + data.hoTen + 
					`</a>\n
					</li>\n
					<li><a href="/logout1" id="logout" onclick = logout>Đăng Xuất</a></li>\n`;
			const logoutBtn = document.querySelector("#logout");
			
			toolbar.innerHTML += content;
		}).catch(err =>{
			console.log("loi token" + err);
			toolbar.innerHTML += `<li><a href="/login1"> Đăng nhập </a></li>\n
				<li><a href="/signup">Đăng ký</a></li>`;
		});
	}
			
});

