<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab2- bài 1</title>
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
		<h3>Lab2 - bài1</h3>
		<input class="borderOrange" name="a" placeholder="Nhập a?">
		<br><br>
		<input class="borderOrange" name="b" placeholder="Nhập b?">
		<br><br>
		<input class="borderOrange" name="c" placeholder="Nhập c?">
		<br> <br>
		<button class="btn-custom" formaction="/LABS/lab2/bai1/chu-vi">Tính chu vi</button>
		<button class="btn-custom" formaction="/LABS/lab2/bai1/dien-tich">Tính diện tích</button>
		
		<h3 style="color: red">${message }</h3>
	</form>
</body>
</html>