package LogInApp;
import admin.StudentData;
import db.util.*;

import admin.AdminController;
import admin.PerformanceData;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import student.StudentController;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    LogInModel logInModel=new LogInModel();
    @FXML
    private Labeled dbstatus;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox <Option> combobox;
    @FXML
    private Button LogIn;

    @FXML
    private Label LogInstatus;
    public void initialize(URL url, ResourceBundle rb)
    {
        if(this.logInModel.isDatabaseConnected()){this.dbstatus.setText("Connected to database");
    }else{
            this.dbstatus.setText("Not yet connected to database");
            }
            this.combobox.setItems(FXCollections.observableArrayList(Option.values()));
    }
    @FXML
    public void LogIn(javafx.event.ActionEvent event)
    {
        try {
            if (this.logInModel.isLogin(this.Username.getText(), this.password.getText(),
                    ((Option) this.combobox.getValue()).toString()))
            {
                Stage stage = (Stage) this.LogIn.getScene().getWindow();
                stage.close();
                switch (((Option) this.combobox.getValue()).toString())
                {
                    case "Admin":
                        AdminLogIn();
                        break;
                    case "Student":
                        StudentLogIn();
                        break;
                }

            } else
                {
                    this.LogInstatus.setText("Wrong credentials");
                }
        }catch(Exception localException)
        {

        }

    }
    public void StudentLogIn()  {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/student/StudentFXML.fxml").openStream());
            StudentController studentController = (StudentController)loader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/student/StudentStylesheet.css");
            userStage.setScene(scene);
            userStage.setTitle("Student DashBoard");
            userStage.setResizable(false);
            userStage.show();
            LogIn.setDefaultButton(true);
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public void AdminLogIn()
    {
       try{
            Stage adminStage=new Stage();
            FXMLLoader adminLoader=new FXMLLoader();
            Pane adminroot=(Pane)adminLoader.load(getClass().getResource("/admin/AdminFXML.fxml").openStream());
            AdminController adminController=(AdminController) adminLoader.getController();
            Scene scene=new Scene(adminroot);
            scene.getStylesheets().add("/student/StudentStylesheet.css");
            adminStage.setScene(scene);
            adminStage.setTitle("Administrator Dashboard");
            adminStage.centerOnScreen();
            adminStage.setResizable(false);
            adminStage.show();
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    }

