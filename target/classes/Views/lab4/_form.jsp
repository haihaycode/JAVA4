<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>User Edition</h3>
${message}
<form action="" method="post">
	Username: <input name="username" value="${form.username}"><br>
	Password: <input name="password"><br> <input
		name="remember" type="checkbox" ${form.remember?'checked':''}>
	Remember me? <br>
	<button>Create</button>
</form>