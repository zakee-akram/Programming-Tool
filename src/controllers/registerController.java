package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.ProgrammingTool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerController {


    @FXML
    private TextField Username;

    @FXML
    private TextField SecondName;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField Password;

    @FXML
    private TextField Email;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button ExitButton;

    @FXML
    void exit(ActionEvent event) {
        exit();
    }
    void exit(){
        try {
            //Redirect To Login Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = null;
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) Username.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Label prompt;
    @FXML
    void register(ActionEvent event) {
        if (!Username.getText().isEmpty() && !SecondName.getText().isEmpty() && !FirstName.getText().isEmpty() && !Password.getText().isEmpty()
                && !Email.getText().isEmpty()) {
            try (Connection connection = ProgrammingTool.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(Username,FirstName,SecondName,Password,Email) VALUES(?,?,?,?,?)");
                preparedStatement.setString(1, Username.getText());
                preparedStatement.setString(2, FirstName.getText());
                preparedStatement.setString(3, SecondName.getText());
                preparedStatement.setString(4, Password.getText());
                preparedStatement.setString(5, Email.getText());
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            exit();
        }
        else{
            prompt.setText("INVALID!!!!!!!");
        }
    }

}
