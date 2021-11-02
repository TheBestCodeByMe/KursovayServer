package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Menu_Admin;
import com.example.kursovayclient.Varieble_System;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TimeBasedHourlySalary {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnFam;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPatronymic;

    @FXML
    private TableColumn<?, ?> columnSalaries;

    @FXML
    private TableColumn<?, ?> columnHours;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TextField txtIncome1;

    @FXML
    void initialize() {
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnPatronymic != null : "fx:id=\"columnPatronymic\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert columnHours != null : "fx:id=\"columnHours\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";
        assert txtIncome1 != null : "fx:id=\"txtIncome1\" was not injected: check your FXML file 'time-based-hourly-salary.fxml'.";

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Varieble_System variebleSystem = new Varieble_System();
            variebleSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open varieble system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
    }

    @FXML
    void clickPayment(ActionEvent event) {
    }
}
