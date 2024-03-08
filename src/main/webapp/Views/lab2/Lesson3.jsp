<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab2- bài 3</title>
</head>
<style>
.borderOrange {
	border: 1px solid orange;
	padding: 20px;
	border-radius: 10px;
	width: 60%
}

.btn-custom {
	padding: 10px 20px;
	background-color: orange;
	border: none;
	border-radius: 5px;
	color: white;
	width: 100%
}
</style>
<body>
	<form method="post" class="borderOrange" style="margin: 10px auto;">
		<h3>Lab2 - bài3</h3>
		<label>Tên đăng nhập</label> <br> <input class="borderOrange"
			type="text" name="username" placeholder="Nhập tên đăng nhập ?">
		<br>
		<br> <label>Mật khẩu</label><br> <input class="borderOrange"
			type="password" name="password" placeholder="Nhập mật khẩu?">
		<br>
		<br> <label>Giới tính</label><br> <input class=""
			type="radio" name="gender" value="true"> Nam <input class=""
			type="radio" name="gender" value="false"> Nữ <br>
		<br> <label>Tình trạng</label><br> Đã kết hôn <input
			class="borderOrange" type="checkbox" name="married"> <br>
		<br> <label>Quốc tịch</label><br> <select name="country"
			class="borderOrange">
			<option value="Vn">Việt Nam</option>
			<option value="Us">United States</option>
		</select> <br>
		<br> <label>Sở thích</label><br> <input name="hobbies"
			type="checkbox" value="R">Đọc sách <input name="hobbies"
			type="checkbox" value="T">Du lịch <input name="hobbies"
			type="checkbox" value="M">Âm nhạc <input name="hobbies"
			type="checkbox" value="O">Khác<br> <br>
		<br> <label>Ghi chú </label><br>
		<textarea rows="3" cols="30" name="notes" class="borderOrange"></textarea>
		<br>
		<br>
		<hr>
		<button class="btn-custom">Đăng ký</button>

		<h3 style="color: red">${message }</h3>
	</form>
</body>
</html>