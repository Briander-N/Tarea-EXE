module com.example.grupal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.grupal to javafx.fxml;
    exports com.example.grupal;
}