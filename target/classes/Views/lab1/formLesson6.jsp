<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab1- bài 6</title>
</head>
<style>
.borderOrange {
	border: 1px solid orange;
	padding: 20px;
	border-radius: 10px
}

.btn-custom {
	padding: 10px 20px;
	background-color: orange;
	border: none;
	border-radius: 5px;
	color: white;
}
</style>
<body>
	<form method="post" class="borderOrange" style="text-align: center; width: 20% ;margin: 10px auto;">
		<h3>Thông tin hình chữ nhật</h3>
		<input class="borderOrange" name="cd" placeholder="Nhập chiều dài">
		<br> <br> <input class="borderOrange" name="cr"
			placeholder="Nhập chiều rộng"><br> <br>
		<button class="btn-custom">Tính toán</button>
	</form>
</body>
</html>