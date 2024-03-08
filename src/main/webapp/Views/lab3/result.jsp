<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h2 {
    font-size: 24px;
    color: #333; /* Màu chữ đen */
    margin-bottom: 10px; /* Khoảng cách phía dưới của h2 */
}

img {
    margin-bottom: 20px; /* Khoảng cách phía dưới của ảnh */
}

a {
    text-decoration: none; /* Loại bỏ gạch chân từ link */
    color: #007bff; /* Màu xanh lá cây */
}

a:hover {
    color: #0056b3; /* Màu xanh lá cây tối khi hover */
}

</style>
<body>
	<h2>1. Hình: ${img.name}</h2>
	<img src="/LABS/files/${img.name}" height="100">
	<h2>2. Tài liệu: ${doc.name}</h2>
	<a href="/LABS/files/${doc.name}">Tải về file tài liệu</a>
</body>
</html>