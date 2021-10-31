package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        assert buttonPassword != null : "fx:id=\"buttonPassword\" was not injected: check your FXML file 'change-password.fxml'.";
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'change-password.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'change-password.fxml'.";
        assert txtNewPassword != null : "fx:id=\"txtNewPassword\" was not injected: check your FXML file 'change-password.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'change-password.fxml'.";
        assert txtRepeatNewPassword != null : "fx:id=\"txtRepeatNewPassword\" was not injected: check your FXML file 'change-password.fxml'.";

    }
}
