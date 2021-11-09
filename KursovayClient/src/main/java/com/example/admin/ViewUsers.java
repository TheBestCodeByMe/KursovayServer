package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Menu_Admin;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }
}
