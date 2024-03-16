<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users Manager</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
.table tbody tr:hover {
	background-color: #ecf0f1;
	color: black;
}

.pagination {
	display: flex;
	justify-content: center;
}
</style>
<body>






	<div class="container-fluid w-75 mt-3">

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

		<p class="text-center fs-1 fw-bold  mt-4">
			Users <STRong> Manager</STRong>
		</p>
		<p class="text-center h6 fw-light mb-5 ">Quản lí các tài khoản
			người dùng</p>

		<div class="row">
			<div class="col-sm-4">
				<form method="post" action="">
					<div class="mb-3">
						<label class="form-label">UserName</label> <input type="text"
							class="form-control" required="required"
							${user!=null ? 'disabled' : ''} value="${user.ID }" name="ID">

					</div>
					<div class="mb-3">
						<label class="form-label">FullName</label> <input type="text"
							class="form-control" required="required"
							value="${user.fullname }" name="fullname">

					</div>
					<div class="mb-3">
						<label class="form-label">Email address</label> <input
							type="email" class="form-control" required="required"
							value="${user.email }" name="email" aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" required="required"
							value="${user.password }" name="password">
					</div>
					<div class="mb-3 form-check">
						<input type="radio" name="admin" value="true"
							${user.admin ? 'checked' : ''}> Admin <input type="radio"
							name="admin" value="false" ${!user.admin ? 'checked' : ''}>
						User
					</div>
					<hr>
					<button type="submit" formaction="/LABS/user/create"
						class="btn btn-primary">Create</button>
					<button type="submit" formaction="/LABS/user/update"
						class="btn btn-primary">Update</button>
					<button type="submit" formaction="/LABS/user/delete"
						class="btn btn-primary">Delete</button>
					<a href="/LABS/user/index" class="btn btn-danger">Reset</a>
				</form>
			</div>
			<div class="col-sm-8">
				<table class="table">
					<thead>
						<tr>
							<th>[ID]</th>
							<th>[Password]</th>
							<th>[Fullname]</th>
							<th>[Email]</th>
							<th>[Role]</th>
							<th>[Edit]</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="user">
							<tr>
								<td>${user.ID}</td>
								<td>${user.password}</td>
								<td>${user.fullname}</td>
								<td>${user.email}</td>
								<td>${user.admin == true ? "admin" : "user"}</td>
								<td><a href="/LABS/user/edit/id/${user.ID}"><i
										class="fas fa-edit"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<nav>
					<ul class="pagination">
						<li class="page-item ${pageCount == 0 ? 'disabled' : ''}"><a
							class="page-link" href="/LABS/user/index?page=0" tabindex="-1">Prev</a>
						</li>

						<c:forEach begin="0" end="${Pages-1}" var="i">
							<li class="page-item ${i==pageCount ?'active' : '' }"><a
								class="page-link" href="/LABS/user/index?page=${i}">${i}</a></li>
						</c:forEach>

						<li class="page-item  ${pageCount == Pages-1 ? 'disabled' : ''}"><a
							class="page-link" href="/LABS/user/index?page=${Pages-1}"
							tabindex="-1">Last</a></li>
					</ul>
				</nav>
			</div>
		</div>


	</div>
</body>
</html>