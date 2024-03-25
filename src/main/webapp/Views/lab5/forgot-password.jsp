<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form đăng ký</title>
<!-- Đường link tới Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${not empty mess}">
		<c:choose>
			<c:when test="${mess.contains('công')}">
				<div class="alert alert-primary" role="alert">${mess}</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger" role="alert">${mess}</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">Đăng ký tài khoản</div>
					<div class="card-body">
						<form method="post">
							
							<div class="form-group">
								<label for="password">Mật khẩu:</label> <input type="password"
									class="form-control" required="required" id="password"
									name="password">
							</div>
							
							<div class="form-group">
								<label for="email">Email:</label> <input type="email"
									class="form-control" required="required" id="email"
									name="email">
							</div>

							
							<button type="submit" class="btn btn-primary">Đăng ký</button>
							<a class="text-success " href="/LABS/account/sign-in">Đăng
								Nhập ?</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Đường link tới Bootstrap JavaScript -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
