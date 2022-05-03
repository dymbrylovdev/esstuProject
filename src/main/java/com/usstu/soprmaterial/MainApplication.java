package com.usstu.soprmaterial;

import com.usstu.soprmaterial.controllers.SuperController;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication extends Application {


    final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("1", "Joe", "Pesci"),
            new Person("2", "Audrey", "Hepburn"),
            new Person("3", "Gregory", "Peck"),
            new Person("4", "Cary", "Grant"),
            new Person("5", "De", "Niro"),
            new Person("6", "Katharine", "Hepburn"),
            new Person("7", "Jack", "Nicholson"),
            new Person("8", "Morgan", "Freeman"),
            new Person("9", "Elizabeth", "Taylor"),
            new Person("10", "Marcello", "Mastroianni"),
            new Person("11", "Innokenty", "Smoktunovsky"),
            new Person("12", "Sophia", "Loren"),
            new Person("13", "Alexander", "Kalyagin"),
            new Person("14", "Peter", "OToole"),
            new Person("15", "Gene", "Wilder"),
            new Person("16", "Evgeny", "Evstegneev"),
            new Person("17", "Michael", "Caine"),
            new Person("18", "Jean-Paul", "Belmondo"),
            new Person("19", " Julia", "Roberts"),
            new Person("20", "James", "Stewart"),
            new Person("21", "Sandra", "Bullock"),
            new Person("22", "Paul", "Newman"),
            new Person("23", "Oleg", "Tabakov"),
            new Person("24", "Mary", "Steenburgen"),
            new Person("25", "Jackie", "Chan"),
            new Person("26", "Rodney", "Dangerfield"),
            new Person("27", "Betty", "White"),
            new Person("28", "Eddie", "Murphy"),
            new Person("29", "Amitabh", "Bachchan"),
            new Person("30", "Nicole", "Kidman"),
            new Person("31", "Adriano", "Celentano"),
            new Person("32", "Rhonda", " Fleming's"),
            new Person("32", "Humphrey", "Bogart"));
    private Pagination pagination;


    public int itemsPerPage() {
        return 1;
    }

    public int rowsPerPage() {
        return 5;
    }

    public VBox createPage(int pageIndex) {
        int lastIndex = 0;
        int displace = data.size() % rowsPerPage();
        if (displace > 0) {
            lastIndex = data.size() / rowsPerPage();
        } else {
            lastIndex = data.size() / rowsPerPage() - 1;

        }

        VBox box = new VBox(5);
        int page = pageIndex * itemsPerPage();

        for (int i = page; i < page + itemsPerPage(); i++) {
            TableView<Person> table = new TableView<Person>();
            TableColumn numCol = new TableColumn("ID");
            numCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("num"));

            numCol.setMinWidth(20);

            TableColumn firstNameCol = new TableColumn("First Name");
            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("firstName"));


            firstNameCol.setMinWidth(160);

            TableColumn lastNameCol = new TableColumn("Last Name");
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("lastName"));

            lastNameCol.setMinWidth(160);

            table.getColumns().addAll(numCol, firstNameCol, lastNameCol);
            if (lastIndex == pageIndex) {
                table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + displace)));
            } else {
                table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + rowsPerPage())));
            }


            box.getChildren().add(table);
        }
        return box;
    }



    @Override
    public void start(Stage primeStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/form-style.css").toExternalForm());
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);



//        pagination = new Pagination((data.size() / rowsPerPage() + 1), 0);
////           pagination = new Pagination(20 , 0);
//        pagination.setStyle("-fx-border-color:red;");
//        pagination.setPageFactory(new Callback<Integer, Node>()  {
//            @Override
//            public Node call(Integer pageIndex) {
//                if (pageIndex > data.size() / rowsPerPage() + 1) {
//                    return null;
//                } else {
//                    return createPage(pageIndex);
//                }
//            }
//        });
//        Stage stage = new Stage();
//        AnchorPane anchor = new AnchorPane();
//        AnchorPane.setTopAnchor(pagination, 10.0);
//        AnchorPane.setRightAnchor(pagination, 10.0);
//        AnchorPane.setBottomAnchor(pagination, 10.0);
//        AnchorPane.setLeftAnchor(pagination, 10.0);
//        anchor.getChildren().addAll(pagination);
//        root.getChildrenUnmodifiable().addAll(anchor);
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Table pager");
        stage.show();

    }


    public static void main(String[] args) {
        checkDrivers();
        launch();
    }

    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
            return false;
        }
    }


    public static class Person {

        private final SimpleStringProperty num;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        private Person(String id, String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.num = new SimpleStringProperty(id);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getNum() {
            return num.get();
        }

        public void setNum(String id) {
            num.set(id);
        }
    }
}
