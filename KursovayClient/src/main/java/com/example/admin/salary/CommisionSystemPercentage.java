package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CommisionSystemPercentage {

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
    private Button buttonUpdate;

    @FXML
    private TextField txtIncome;

    @FXML
    void initialize() {
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert columnPatronymic != null : "fx:id=\"columnPatronymic\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";
        assert txtIncome != null : "fx:id=\"txtIncome\" was not injected: check your FXML file 'commision-system-percentage.fxml'.";

    }
}
