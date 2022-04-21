package com.usstu.soprmaterial;

import com.usstu.soprmaterial.connectionDb.LoginModel;
import com.usstu.soprmaterial.model.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

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
    private ComboBox<String> material_select;

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
        ObservableList<Material> materials = loginModel.getAllMaterial();
        List<String> list = new LinkedList<>();
        for (Material material: materials){
            list.add(material.getName());
        }
        ObservableList<String> dataList = FXCollections.observableArrayList(list);

        material_select.setItems(dataList);

        if (loginModel.isDbConnected()){
            bdInfo.setText("База данных подключена");
            bdInfo.setStyle("-fx-text-fill: green");
        } else {
            bdInfo.setText("База данных не подключена");
            bdInfo.setStyle("-fx-text-fill: red");
        }
    }

}