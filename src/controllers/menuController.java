package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class menuController {

    @FXML
    private VBox menuBox;

    @FXML
    private Button menuButton;
    @FXML
    private Button debugButton;

    @FXML
    void menuControl(ActionEvent event) {
        if (menuBox.getOpacity() == 100) {
            menuBox.setOpacity(0);
        } else {
            menuBox.setOpacity(100);
        }
        System.out.println("Testrin");

    }

    @FXML
    void debug(ActionEvent event) {
        System.out.println("Connected");
        if (menuBox.getOpacity() == 100) {
            menuBox.setOpacity(0);
        } else {
            menuBox.setOpacity(100);
        }
    }
}
