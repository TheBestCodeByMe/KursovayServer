package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Commision_System;
import com.example.kursovayclient.Menu_User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangePassword {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonPassword;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField txtRepeatNewPassword;

    @FXML
    void initialize() {

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_User menuUser = new Menu_User();
            menuUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open menu user.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickPassword(ActionEvent event) {
    }
}
