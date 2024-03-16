<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Kết quả</h1>
	<ul>
		<li>Họ và tên: <b>${bean.fullname}</b></li>
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