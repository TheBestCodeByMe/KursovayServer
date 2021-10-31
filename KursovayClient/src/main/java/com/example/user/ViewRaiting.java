package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ViewRaiting {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnFam;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnOtchestvo;

    @FXML
    private TableColumn<?, ?> columnSalaries;

    @FXML
    void initialize() {
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'view-raiting.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'view-raiting.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'view-raiting.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'view-raiting.fxml'.";
        assert columnOtchestvo != null : "fx:id=\"columnOtchestvo\" was not injected: check your FXML file 'view-raiting.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'view-raiting.fxml'.";

    }
}
