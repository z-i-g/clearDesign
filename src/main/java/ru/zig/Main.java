package ru.zig;

import ru.zig.service.JdbcStorage;
import ru.zig.service.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Storage storage = new JdbcStorage(connection);
            storage.save("Hello");
            String data = storage.retrieve(1);
            System.out.println(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}