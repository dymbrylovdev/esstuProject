package com.usstu.soprmaterial.connectionDb;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel() {
        connection = SqliteConnection.Connector();
        if (connection == null) System.exit(1);
    }

    public Boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
