package com.usstu.soprmaterial.connectionDb;

import com.usstu.soprmaterial.MainController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteConnection {
    private static final String location = MainController.class.getResource("main.db").toExternalForm();
    public static Connection Connector() {
        Connection connect;
        String dbPrefix = "jdbc:sqlite:";
        try {
            connect = DriverManager.getConnection(dbPrefix + location);
                    } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    LocalDateTime.now() + ": Could not connect to SQLite DB at ");
            return null;
        }
        return connect;
    }
}
