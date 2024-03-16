<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Online Shopping Mall</title>


<script>
<%@ include file="/Views/lab4/js/jquery.min.js"%>
<%@ include file="/Views/lab4/js/bootstrap.min.js"%>
</script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
rel="stylesheet">
<style type="text/css">
<%@ include file="/Views/lab4/css/bootstrap.min.css"%>
<%@ include file="/Views/lab4/css/poly.css"%>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="/Views/lab4/header.jsp"%>
		<%@ include file="/Views/lab4/menu.jsp"%>

		<div class="poly-sheet row">
               
			<article class="col-sm-9">
				<div class="row poly-card">
				<%
				 int i;
				 for(i=0;i<13;i++){ 
				%>
			
				<jsp:include page="/Views/lab4/item.jsp">
				 <jsp:param value="<%= \"Iphone \" + i + \" Promax\" %>" name="title"/>
				 <jsp:param value="https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png" name="img"/>
				 <jsp:param value="15.999.999 VNĐ" name="price"/>
				</jsp:include>
				<%} %>
				</div>
			</article>
			<%@ include file="/Views/lab4/aside.jsp"%>

		</div>
		<%@ include file="/Views/lab4/footer.jsp"%>

	</div>
</body>
</html>