package com.example.grupal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    protected TextField user;
    @FXML
    protected TextField pass;

    public void Confirm(ActionEvent actionEvent) throws IOException, NoSuchFieldException {
        String usuario = this.user.getText();
        String contra = this.pass.getText();
        if (usuario.equals("admin") && contra.equals("admin")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crud.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), (double)620.0F, (double)500.0F);
            Stage stage = new Stage();
            stage.setTitle("CRUD");
            stage.setScene(scene);
            stage.show();
            Stage cerr = (Stage)this.user.getScene().getWindow();
            cerr.close();
        } else if (!usuario.isEmpty() && !contra.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Datos Incorrectos");
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Usuario o Contraseña sin llenar");
            alert.show();
        }

    }

    public void ex(ActionEvent actionEvent) {
        Stage cerr = (Stage)this.user.getScene().getWindow();
        cerr.close();
    }
}
