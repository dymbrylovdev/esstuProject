package com.usstu.soprmaterial;

import com.usstu.soprmaterial.controllers.SuperController;
import com.usstu.soprmaterial.model.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
    public static final PopOver popConfig = new PopOver();

    public void clickBtnSaveForm()  {
        ObservableList<Material> materials = SuperController.loginModel.getAllMaterial();
        List<String> list = new LinkedList<>();
        for (Material material : materials) {
            list.add(material.getName());
        }
        ObservableList<String> dataList = FXCollections.observableArrayList(list);

        material_select.setItems(dataList);
    }

    public void clickBtnAddMaterial() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Parent popContent = FXMLLoader.load(getClass().getResource("material-view.fxml"));

        Scene scene = new Scene(popContent);

        window.setScene(scene);
        window.showAndWait();
    }

    public void showInfoDatabase() {

    }

    @Override
    public void initialize(URL var1, ResourceBundle var2) {
            clickBtnSaveForm();
        add_material_button.setOnAction(actionEvent -> {
            try {
                clickBtnAddMaterial();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        if (SuperController.loginModel.isDbConnected()){
            bdInfo.setText("База данных подключена");
            bdInfo.setStyle("-fx-text-fill: green");
        } else {
            bdInfo.setText("База данных не подключена");
            bdInfo.setStyle("-fx-text-fill: red");
        }

    }


}