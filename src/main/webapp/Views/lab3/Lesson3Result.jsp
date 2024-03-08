<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả lab3 - bài 1</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
}

h1 {
	color: #333;
}

ul {
	list-style-type: none;
	padding: 20px;
	margin: 10px auto;
	width: 30%;
}

ul li {
	margin-bottom: 10px;
}

ul li b {
	font-weight: bold;
}

img {
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-top: 10px;
}

/* Định dạng các dòng trong thẻ <ul> */
ul li {
	margin-bottom: 10px;
	line-height: 1.5;
}

/* Định dạng các dòng trong thẻ <ul> màu đậm */
ul li b {
	font-weight: bold;
	color: #007bff; /* Màu xanh lá cây */
}
</style>
</head>
<body>

	<ul>
		<li><h3>Kết quả</h3> </li>
		<li>Họ và tên: <b>${bean.fullname}</b></li>
		<li><img alt="${bean.photo_file}" style="width: 300px"
			src="/LABS/files/${bean.photo_file}"></li>
		<li>Mật Khẩu: <b>${bean.password}</b></li>

		<li>Ngày sinh: <b>${bean.birthday}</b></li>
		<li>Giới tính: <b>${bean.gender}</b></li>
		<li>Quốc tịch: <b>${bean.country}</b></li>
		<li>TT hôn nhân: <b>${bean.married}</b></li>
		<li>Sở thích: <b>${bean.hobbies}</b></li>
		<li>Ghi chú: <b>${bean.notes}</b></li>
	</ul>
</body>
</html>