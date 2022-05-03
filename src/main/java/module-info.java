module com.usstu.soprmaterial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.desktop;

    opens com.usstu.soprmaterial to javafx.fxml;
    exports com.usstu.soprmaterial;
    exports com.usstu.soprmaterial.controllers;
    opens com.usstu.soprmaterial.controllers to javafx.fxml;
}