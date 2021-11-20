package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Commision_System;
import com.example.kursovayclient.Menu_User;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
    private PasswordField txtPassword;

    @FXML
    private TextField txtNewLogin;

    @FXML
    private Button buttonBack;
    InteractionsWithServer interactionsWithServer;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuUser(buttonBack);
    }

    @FXML
    void clickLogin(ActionEvent event) {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        String newLogin = txtNewLogin.getText();

        if (HelpersCl.validateTextFields(login, password, newLogin)) {
            if (!login.equals("admin")) {
                interactionsWithServer.editUserLogin(login, newLogin, password);
                HelpersCl.notBug("Смена логина прошла успешно.");
                txtLogin.setText("");
                txtNewLogin.setText("");
                txtPassword.setText("");
            } else {
                HelpersCl.bug("Введённый вами логин использовать нельзя.");
            }
        } else {
            HelpersCl.bug("Все поля должны быть заполнены!!!");
        }
    }
}
