package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) throws IOException {
        if(!passwordField.getText().isEmpty()&& !usernameField.getText().isEmpty()){
            //Redirect To Menu Page if Successful.
            FXMLLoader loader  = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();
        }
        else{
            System.out.println("Invalid Details");
        }
    }
}
