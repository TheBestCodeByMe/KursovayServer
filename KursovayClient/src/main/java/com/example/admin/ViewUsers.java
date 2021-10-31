package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ViewUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'view-users.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'view-users.fxml'.";
        assert columnLogin != null : "fx:id=\"columnLogin\" was not injected: check your FXML file 'view-users.fxml'.";
        assert columnPassword != null : "fx:id=\"columnPassword\" was not injected: check your FXML file 'view-users.fxml'.";
        assert columnBlock != null : "fx:id=\"columnBlock\" was not injected: check your FXML file 'view-users.fxml'.";

    }
}
