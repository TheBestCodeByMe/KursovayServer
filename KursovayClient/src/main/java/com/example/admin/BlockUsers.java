package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class BlockUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBlock;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnLogin;

    @FXML
    private TableColumn<?, ?> columnPassword;

    @FXML
    private Button buttonUnblock;

    @FXML
    void initialize() {
        assert buttonBlock != null : "fx:id=\"buttonBlock\" was not injected: check your FXML file 'block-users.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'block-users.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'block-users.fxml'.";
        assert columnLogin != null : "fx:id=\"columnLogin\" was not injected: check your FXML file 'block-users.fxml'.";
        assert columnPassword != null : "fx:id=\"columnPassword\" was not injected: check your FXML file 'block-users.fxml'.";
        assert buttonUnblock != null : "fx:id=\"buttonUnblock\" was not injected: check your FXML file 'block-users.fxml'.";

    }
}
