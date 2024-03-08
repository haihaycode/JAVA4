<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab3 - bài 4</title>
</head>
<style>
/* Thiết lập font chung cho trang */
body {
	font-family: Arial, sans-serif;
}

/* Thiết lập kích thước chung cho trang */
.container {
	width: 400px;
	margin: auto;
	margin-top: 50px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #fff;
}

/* Thiết lập định dạng cho nút */
button {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
	background-color: #1877f2; /* Màu nền của nút */
	color: #fff; /* Màu chữ của nút */
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

/* Thiết lập định dạng cho link */
a {
	color: #1877f2; /* Màu chữ của link */
	text-decoration: none;
}

/* Thiết lập định dạng cho input */
input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

/* Thiết lập định dạng cho checkbox */
input[type="checkbox"] {
	margin-top: 10px;
	margin-right: 5px;
}
</style>

<body>
	<div class="container">
		
		<h3>Đăng nhập tài khoản</h3>
		<mark style="color: red;">${message}</mark>
		<form action="" method="post">
			Username: <br> <input name="username" type="text" value="${username}"><br>
			Password: <br> <input name="password" type="password"value="${password}"><br>
			<input name="remember" type="checkbox"> Remember me?<br>
			<hr>
			<button>Login</button>
		</form>
	</div>
</body>
</html>