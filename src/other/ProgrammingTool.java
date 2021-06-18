package other;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ProgrammingTool extends Application {
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       Connection connection = getConnection();
    }
    private static final String SqCon = "jdbc:sqlite:ProgrammingToolDatabase.db";

    //Set up a connection to the database
    public static Connection getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SqCon);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
