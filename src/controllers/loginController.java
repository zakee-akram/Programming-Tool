package controllers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.user;
import other.ProgrammingTool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    private user loggedInUser;

    @FXML
    void login(ActionEvent event) throws IOException {
        if (!passwordField.getText().isEmpty() && !usernameField.getText().isEmpty()) {
            try (Connection connection = ProgrammingTool.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM Users Where Username = ? and Password = ?");
                preparedStatement.setString(1, usernameField.getText());
                preparedStatement.setString(2, passwordField.getText());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    loggedInUser = new user(resultSet.getInt("Id"), resultSet.getString("Username"),
                            resultSet.getString("FirstName"), resultSet.getString("Password"), resultSet.getString("Email"), resultSet.getString("SecondName"));
                }
                //Basic Test That Data Has Passed Through
//                System.out.println(loggedInUser.getId());
//                System.out.println(loggedInUser.getFirstName());
//                System.out.println(loggedInUser.getEmail());
//                System.out.println(loggedInUser.getPassword());
//                System.out.println(loggedInUser.getSecondName());
//                System.out.println(loggedInUser.getUsername());
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } else {
            System.out.println("Invalid Details");
        }
    }

    @FXML
    private Button RegisterButton;

    void redirect() throws IOException {
        //Redirect To Menu Page if Successful.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void Register(ActionEvent event) throws IOException {
        //Change to Register Account Page.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/register.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.close();
    }

}
