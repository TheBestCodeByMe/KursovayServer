package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class TimeBasedDaily {

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
    private TableColumn<?, ?> copumnDays;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TextField txtIncome1;

    @FXML
    void initialize() {
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert columnPatronymic != null : "fx:id=\"columnPatronymic\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert copumnDays != null : "fx:id=\"copumnDays\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'time-based-daily.fxml'.";
        assert txtIncome1 != null : "fx:id=\"txtIncome1\" was not injected: check your FXML file 'time-based-daily.fxml'.";

    }
}
