package com.usstu.soprmaterial.connectionDb;

import com.usstu.soprmaterial.model.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Map;

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

    public ObservableList<Material> getAllMaterial()  {
        ObservableList<Material> materials = FXCollections.observableArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM material";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Material material = new Material(id, name);
                materials.add(material);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return materials;
    }

    public Map.Entry<Boolean, String> setMaterial (String text)  {
        Map.Entry<Boolean, String> result = Map.entry(false, "Ощибка сохранения");
        String query = "INSERT INTO material(name) VALUES('"+text+"')";
        try {
            Statement preparedStatement = connection.createStatement();
            int status = preparedStatement.executeUpdate(query);
            if (status == 1) {
                result = Map.entry(true, "Материал сохранен");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return  result;
    }
}
