package com.example.adminuser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonEnter;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPassword1;

    @FXML
    private Button buttonEnter1;

    @FXML
    void initialize() {
        assert buttonEnter != null : "fx:id=\"buttonEnter\" was not injected: check your FXML file 'add-users.fxml'.";
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'add-users.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'add-users.fxml'.";
        assert txtPassword1 != null : "fx:id=\"txtPassword1\" was not injected: check your FXML file 'add-users.fxml'.";
        assert buttonEnter1 != null : "fx:id=\"buttonEnter1\" was not injected: check your FXML file 'add-users.fxml'.";

    }
}
