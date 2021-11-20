package com.example.adminuser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Main;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUsers {
    InteractionsWithServer interactionsWithServer;

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
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickRegistration(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.registration(txtLogin.getText(), txtPassword.getText(), txtPassword1.getText());
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMain(buttonBack);
    }
}
