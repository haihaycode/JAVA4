<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body>
	<div class="card" style="width: 18rem; margin: 10px auto;">
		<div class="card-body p-0 ">
			<h5 class="card-title border text-center">${item.name }</h5>
			<img src="${item.image }" class="card-img-top text-center"
				alt="Nokia">

			<p class="card-text">
			<ul>
				<li>Giá Gốc : <strike>${item.price}</strike>
				</li>
				<li>Giá Mới : <c:set var="newprice"
						value="${item.price*(1-item.discount)}" /> <fmt:formatNumber
						value="${newprice}" /></li>

				<li> Mức giá : <c:choose>
						<c:when test="${newprice< 100}">Giá thấp</c:when>
						<c:when test="${newprice> 1000}">Giá cao</c:when>
						<c:otherwise>Bình thường</c:otherwise>
					</c:choose>
				</li>
			</ul>
			</p>

			<div class="card-footer">Featured</div>
		</div>
	</div>
</body>
</html>