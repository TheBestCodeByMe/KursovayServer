package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EditingUsers {

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
    private Button buttonDelete;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnLogin;

    @FXML
    private TableColumn<?, ?> columnPassword;

    @FXML
    private TableColumn<?, ?> columnBlock;

    @FXML
    void initialize() {
        assert buttonEnter != null : "fx:id=\"buttonEnter\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert txtPassword1 != null : "fx:id=\"txtPassword1\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert columnLogin != null : "fx:id=\"columnLogin\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert columnPassword != null : "fx:id=\"columnPassword\" was not injected: check your FXML file 'editing-users.fxml'.";
        assert columnBlock != null : "fx:id=\"columnBlock\" was not injected: check your FXML file 'editing-users.fxml'.";

    }
}
