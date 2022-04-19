package com.usstu.soprmaterial;

import com.usstu.soprmaterial.connectionDb.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.EventListener;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    public LoginModel loginModel = new LoginModel();

    @FXML
    private Button add_dobavca_button;

    @FXML
    private Button add_material_button;

    @FXML
    private Button button_img1;

    @FXML
    private Button button_img2;

    @FXML
    private Button button_img3;

    @FXML
    private Button button_img4;

    @FXML
    private MenuButton dobavca_select;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private MenuButton material_select;

    @FXML
    private TextField number_obrazca;

    @FXML
    private TextField procent;

    @FXML
    private Button save_form;

    @FXML
    private TextField sloi;

    @FXML
    private Label bdInfo;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void clickBtnSaveForm() {

    }
    public void clickBtnAddMaterial() {

    }

    @Override
    public void initialize(URL var1, ResourceBundle var2){

        if (loginModel.isDbConnected()){
            bdInfo.setText("База данных подключена");
            bdInfo.setStyle("-fx-text-fill: green");
        } else {
            bdInfo.setText("База данных не подключена");
            bdInfo.setStyle("-fx-text-fill: red");
        }
    }

}