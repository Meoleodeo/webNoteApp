<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Welcome, <%= user.getFullname() %></h1>
    <h2>Your Take Notes and Todo Lists</h2>
    <a href="addNote.jsp" class="btn btn-primary">Add Note</a>
    <a href="addTodoList.jsp" class="btn btn-primary">Add Todo List</a>
</div>
</body>
</html>
