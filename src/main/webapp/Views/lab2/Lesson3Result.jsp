<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
		<li>Tên đăng nhập: <b>${param.username}</b></li>
		<li>Mật khẩu: <b>${param.password}</b></li>
		<li>Giới tính: <b>${param.gender}</b></li>
		<li>Tình trạng hôn nhân: <b>${param.married}</b></li>
		<li>Quốc tịch: <b>${param.country}</b></li>
		 <% 
            // Mảng chứa các sở thích
            String[] hobbies = request.getParameterValues("hobbies");

            // Duyệt qua mảng và in ra mỗi sở thích
            if (hobbies != null) {
                for (String hobby : hobbies) {
        %>
            <li>Sở thích: <b><%= hobby %></b></li>
        <%
                }
            }
        %>
		<li>Ghi chú: <b>${param.notes}</b></li>
	</ul>
</body>
</html>