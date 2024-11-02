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
    <title>Add Todo List</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Add New Todo List</h2>
    <form action="todolist" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="tasks">Tasks:</label>
            <textarea class="form-control" id="tasks" name="tasks" rows="5" required></textarea>
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="isPublic" name="isPublic">
            <label class="form-check-label" for="isPublic">Make Public</label>
        </div>
        <button type="submit" class="btn btn-primary">Save Todo List</button>
    </form>
    <br>
    <a href="dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
</div>
</body>
</html>
