package com.usstu.soprmaterial.controllers;

import com.usstu.soprmaterial.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

public class MaterialModalWindowController extends MainController implements Initializable{
    @FXML
    private Button btn_add_material;

    @FXML
    private TextField text_material;

    private void getNameAndSetData (String text) {
        Map.Entry<Boolean, String> result =  SuperController.loginModel.setMaterial(text);
        JOptionPane.showMessageDialog(null, result.getValue());
        clickBtnSaveForm();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_add_material.setOnAction(actionEvent -> getNameAndSetData(text_material.getText()));
    }


}

