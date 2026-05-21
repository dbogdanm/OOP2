package ro.unibuc.biblioteca.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericDbService {
    private static GenericDbService instance;
    private DatabaseService dbService = DatabaseService.getInstance();

    private GenericDbService() {}

    public static GenericDbService getInstance() {
        if (instance == null) {
            instance = new GenericDbService();
        }
        return instance;
    }

    public void executeUpdate(String sql, Object... params) {
        Connection conn = dbService.getConnection();
        if (conn == null) return;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Eroare la executia update/insert: " + e.getMessage());
        }
    }

    public interface RowMapper<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }

    public <T> List<T> executeSelect(String sql, RowMapper<T> mapper, Object... params) {
        Connection conn = dbService.getConnection();
        List<T> results = new ArrayList<>();
        if (conn == null) return results;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.add(mapper.mapRow(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Eroare la executia select: " + e.getMessage());
        }
        return results;
    }
}