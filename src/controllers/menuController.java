package controllers;

import objects.userProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import other.ProgrammingTool;

import javax.xml.transform.Source;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class menuController implements Initializable {
    //Logged In User Profile:
    private userProfile currentUser;

    //FXML Objects Connection:
    @FXML
    private VBox menuBox;
    @FXML
    private Button menuButton;
    @FXML
    private Button debugButton;
    @FXML
    private Label userName;
    @FXML
    private Circle userImage;
    @FXML
    private ComboBox<?> projectSelection;
    @FXML
    private Button ticketsButton;
    @FXML
    private Button taskButton;
    @FXML
    private Button docsButton;
    @FXML
    private Button notesButton;
    @FXML
    private Button settingButton;

//    @FXML
//    void menuControl(ActionEvent event) {
//        if (menuBox.getOpacity() == 100) {
//            menuBox.setOpacity(0);
//        } else {
//            menuBox.setOpacity(100);
//        }
//        System.out.println("Testrin");
//
//    }

    @FXML
    void debug(ActionEvent event) {
//        System.out.println("Connected");
//        if (menuBox.getOpacity() == 100) {
//            menuBox.setOpacity(0);
//        } else {
//            menuBox.setOpacity(100);
//        }
//
        populateComboBox();
    }


    @FXML
    void docs(ActionEvent event) {

    }

    @FXML
    void notes(ActionEvent event) {

    }

    @FXML
    void setting(ActionEvent event) {

    }

    @FXML
    void tasks(ActionEvent event) {

    }

    @FXML
    void tickets(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void populateComboBox() {
        //Adding User Projects To The Project Selection.
        int testUser = 1;
        ArrayList<String> tempProjects = new ArrayList<>();
        ArrayList<String> tempCreation = new ArrayList<>();
        try (Connection connection = ProgrammingTool.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("SELECT ProjectName,CreationDate FROM Projects WHERE User = ? ");
            pstmt.setInt(1, testUser);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                tempProjects.add(resultSet.getString("ProjectName"));
                tempCreation.add(resultSet.getString("CreationDate"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        currentUser = new userProfile(testUser, tempProjects, tempCreation);
        test();
    }

    public void test() {
        System.out.println(currentUser.getDates());
        System.out.println(currentUser.getProjects());
        System.out.println(currentUser.getUser());
    }
}



