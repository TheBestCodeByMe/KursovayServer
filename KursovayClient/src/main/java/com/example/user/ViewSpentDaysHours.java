package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ViewSpentDaysHours {

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
    private TableColumn<?, ?> columnDays;

    @FXML
    private TableColumn<?, ?> columnHours;

    @FXML
    void initialize() {
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnOtchestvo != null : "fx:id=\"columnOtchestvo\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnDays != null : "fx:id=\"columnDays\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnHours != null : "fx:id=\"columnHours\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";

    }
}
