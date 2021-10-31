package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
}
