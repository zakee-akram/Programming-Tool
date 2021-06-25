package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.task;
import objects.user;
import objects.userProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private user currentUser;
    //Logged In User Projects And Info
    private userProfile userProjects;
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
    private ComboBox<String> projectSelection;
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

    //Passes Parameter From Other Controller And Runs Some Form Setup Code:
    public void setData(user currentUser) {
        this.currentUser = currentUser;
        populateComboBox();
        userName.setText(currentUser.getUsername());
    }

    private void populateComboBox() {
        //Adding User Projects To The Project Selection.
        ArrayList<String> tempProjects = new ArrayList<>();
        ArrayList<String> tempCreation = new ArrayList<>();
        try (Connection connection = ProgrammingTool.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("SELECT ProjectName,CreationDate FROM Projects WHERE User = ? ");
            pstmt.setInt(1, currentUser.getId());
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                tempProjects.add(resultSet.getString("ProjectName"));
                tempCreation.add(resultSet.getString("CreationDate"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        userProjects = new userProfile(currentUser, tempProjects, tempCreation);
        projectSelection.getItems().clear();
        ;
        projectSelection.getItems().addAll(userProjects.getProjects());
    }

    public void test() {
        System.out.println(userProjects.getDates());
        System.out.println(userProjects.getProjects());
        System.out.println(userProjects.getCurrentUser().getUsername());
    }


    @FXML
    void comboAction(ActionEvent event) {
        updateTaskTable();
    }

    //Table View Data For Tasks
    @FXML
    private TableView<task> taskTable;
    @FXML
    private TableColumn<task, Integer> TaskId;
    @FXML
    private TableColumn<task, String> Task;
    @FXML
    private TableColumn<task, String> DueDate;
    @FXML
    private TableColumn<task, Integer> Creator;
    private ObservableList<task> taskList;

    private void updateTaskTable() {
        try (Connection connection = ProgrammingTool.getConnection()) {
            this.taskList = FXCollections.observableArrayList();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Tasks WHERE ProjectName = ? ");
            pstmt.setString(1, projectSelection.getValue());
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                this.taskList.add(new task(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
            resultSet.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        this.TaskId.setCellValueFactory(new PropertyValueFactory<task, Integer>("TaskId"));
        this.Task.setCellValueFactory(new PropertyValueFactory<task, String>("Task"));
        this.DueDate.setCellValueFactory(new PropertyValueFactory<task, String>("DueDate"));
        this.Creator.setCellValueFactory(new PropertyValueFactory<task, Integer>("Id"));

        this.taskTable.setItems(this.taskList);
    }


}
//    CREATE TABLE "Tasks" (
//        "Id"	INTEGER NOT NULL,
//        "TaskId"	INTEGER NOT NULL,
//        "Task"	TEXT NOT NULL,
//        "DueDate"	TEXT,
//        FOREIGN KEY("Id") REFERENCES "Users"("Id"),
//        PRIMARY KEY("TaskId" AUTOINCREMENT)
//        );


