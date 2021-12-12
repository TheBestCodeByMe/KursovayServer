package com.example.adminuser;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUsers {
    InteractionsWithServer interactionsWithServer;

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
        txtLogin.setText("");
        txtPassword.setText("");
        txtPassword1.setText("");
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMain(buttonBack);
    }
}
