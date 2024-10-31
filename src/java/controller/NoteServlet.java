package controller;

import dao.NoteDao;
import model.Note;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            boolean isPublic = "on".equals(request.getParameter("isPublic"));

            Note note = new Note();
            note.setUserId(user.getId());
            note.setTitle(title);
            note.setContent(content);
            note.setPublic(isPublic);

            NoteDao noteDao = new NoteDao();
            noteDao.addNote(note);
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
