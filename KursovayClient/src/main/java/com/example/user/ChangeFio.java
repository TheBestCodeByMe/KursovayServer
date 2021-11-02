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

public class ChangeFio {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtNewLogin;

    @FXML
    private Button buttonBack;

    @FXML
    void initialize() {
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'change-fio.fxml'.";
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'change-fio.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'change-fio.fxml'.";
        assert txtNewLogin != null : "fx:id=\"txtNewLogin\" was not injected: check your FXML file 'change-fio.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'change-fio.fxml'.";

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
    void clickLogin(ActionEvent event) {
    }
}
