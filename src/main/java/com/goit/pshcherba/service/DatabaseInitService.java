package com.goit.pshcherba.service;

import com.goit.pshcherba.config.Database;
import com.goit.pshcherba.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInitService {
    public static void main(String[] args) {
        String sql = Util.readSql("./sql/init_db.sql");

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
