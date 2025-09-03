package ru.zig.service;

import java.sql.*;

public class JdbcStorage implements Storage {
    private final Connection connection;

    public JdbcStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(String data) {
        String insertSQL = "INSERT INTO storage(data) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при сохранении данных", e);
        }
    }

    @Override
    public String retrieve(int id) {
        String selectSQL = "SELECT data FROM storage WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("data");
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при извлечении данных", e);
        }
    }
}
