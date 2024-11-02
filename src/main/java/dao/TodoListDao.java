package dao;

import model.TodoList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListDao {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=webNote;user=sa;password=1234567;";
        return DriverManager.getConnection(url);
    }

    public void addTodoList(TodoList todoList) {
        String query = "INSERT INTO TodoLists (userId, title, tasks, isPublic) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, todoList.getUserId());
            stmt.setString(2, todoList.getTitle());
            stmt.setString(3, todoList.getTasks());
            stmt.setBoolean(4, todoList.isPublic());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TodoList> getTodoListsByUserId(int userId) {
        List<TodoList> todoLists = new ArrayList<>();
        String query = "SELECT * FROM TodoLists WHERE userId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(rs.getInt("id"));
                todoList.setUserId(rs.getInt("userId"));
                todoList.setTitle(rs.getString("title"));
                todoList.setTasks(rs.getString("tasks"));
                todoList.setPublic(rs.getBoolean("isPublic"));
                todoLists.add(todoList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoLists;
    }

    public void updateTodoList(TodoList todoList) {
        String query = "UPDATE TodoLists SET title = ?, tasks = ?, isPublic = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, todoList.getTitle());
            stmt.setString(2, todoList.getTasks());
            stmt.setBoolean(3, todoList.isPublic());
            stmt.setInt(4, todoList.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodoList(int id) {
        String query = "DELETE FROM TodoLists WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
