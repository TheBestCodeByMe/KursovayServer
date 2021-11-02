package com.example.adminuser;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Main;
import com.example.kursovayclient.Time_Based_Daily;
import com.example.kursovayclient.Time_Based_Hourly_Salary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonRegistration;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPassword1;

    @FXML
    private Button buttonBack;

    @FXML
    void initialize() {
    }

    @FXML
    void clickRegistration(ActionEvent event) {

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Main main = new Main();
            main.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open main.\nWith exception " + e.getLocalizedMessage());
        }
    }
}
