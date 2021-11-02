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

public class AddDayOff {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField txtFam;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatronymic;

    @FXML
    private Button buttonBack;

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'add-day-off.fxml'.";
        assert txtFam != null : "fx:id=\"txtFam\" was not injected: check your FXML file 'add-day-off.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'add-day-off.fxml'.";
        assert txtPatronymic != null : "fx:id=\"txtPatronymic\" was not injected: check your FXML file 'add-day-off.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'add-day-off.fxml'.";

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
    void clickAdd(ActionEvent event) {
    }
}
