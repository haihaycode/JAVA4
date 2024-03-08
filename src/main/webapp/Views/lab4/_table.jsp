<%@ page import="lab4.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
    <h3>User List</h3>
    <table border="1" style="width: 100%;">
        <thead>
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Remember?</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<User> userList = (List<User>) request.getAttribute("items");
                for (User user : userList) {
            %>
                <tr>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getPassword() %></td>
                    <td><%= user.isRemember() ? "Yes" : "No" %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
