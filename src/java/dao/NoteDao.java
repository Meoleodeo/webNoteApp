package dao;

import model.Note;
import view.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    public List<Note> getPublicNotes() {
        List<Note> notes = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Notes WHERE isPublic = 1");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt("id"));
                note.setTitle(rs.getString("title"));
                note.setContent(rs.getString("content"));
                notes.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notes;
    }

    public void addNote(Note note) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            PreparedStatement stmt = conn
                    .prepareStatement("INSERT INTO Notes (userId, title, content, isPublic) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, note.getUserId());
            stmt.setString(2, note.getTitle());
            stmt.setString(3, note.getContent());
            stmt.setBoolean(4, note.isPublic());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
