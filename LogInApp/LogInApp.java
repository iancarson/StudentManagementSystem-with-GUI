package LogInApp;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.color;

public class LogInApp extends Application {
    public void start(Stage stage) throws Exception
    {
        Parent root=(Parent) FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("School Management System");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String args[])
    {
        launch(args);
    }

}
