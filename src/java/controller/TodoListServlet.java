package controller;

import dao.TodoListDao;
import model.TodoList;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/todolist")
public class TodoListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String title = request.getParameter("title");
            String tasks = request.getParameter("tasks");
            boolean isPublic = "on".equals(request.getParameter("isPublic"));

            TodoList todoList = new TodoList();
            todoList.setUserId(user.getId());
            todoList.setTitle(title);
            todoList.setTasks(tasks);
            todoList.setPublic(isPublic);

            TodoListDao todoListDao = new TodoListDao();
            todoListDao.addTodoList(todoList);
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
