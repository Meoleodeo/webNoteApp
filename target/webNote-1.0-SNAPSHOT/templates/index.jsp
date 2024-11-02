<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.NoteDao" %>
<%@ page import="dao.TodoListDao" %>
<%@ page import="model.Note" %>
<%@ page import="model.TodoList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to webNote</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Welcome to webNote</h1>
    <div class="buttons">
        <a href="login.jsp" class="btn btn-primary">Login</a>
        <a href="register.jsp" class="btn btn-secondary">Register</a>
    </div>

    <h2>Public Take Notes</h2>
    <div class="public-notes">
        <%
            NoteDao noteDao = new NoteDao();
            List<Note> publicNotes = noteDao.getPublicNotes();
            for (Note note : publicNotes) {
        %>
            <div class="note-item">
                <h4><%= note.getTitle() %></h4>
                <p><%= note.getContent() %></p>
                <small>Posted by User ID: <%= note.getUserId() %></small>
            </div>
        <%
            }
        %>
    </div>

    <h2>Public Todo Lists</h2>
    <div class="public-todolists">
        <%
            TodoListDao todoListDao = new TodoListDao();
            List<TodoList> publicTodoLists = todoListDao.getPublicTodoLists();
            for (TodoList todoList : publicTodoLists) {
        %>
            <div class="todo-item">
                <h4><%= todoList.getTitle() %></h4>
                <p><%= todoList.getTasks().replace("\n", "<br>") %></p>
                <small>Posted by User ID: <%= todoList.getUserId() %></small>
            </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
