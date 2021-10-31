package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EditingEmployees {

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
    private TextField txtPassword11;

    @FXML
    private TextField txtPassword12;

    @FXML
    private TextField txtPassword111;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonUpdate;

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
    private TableColumn<?, ?> columnHours;

    @FXML
    private TableColumn<?, ?> columnDays;

    @FXML
    private TableColumn<?, ?> columnAmount;

    @FXML
    private TableColumn<?, ?> columnSalaries;

    @FXML
    void initialize() {
        assert buttonEnter != null : "fx:id=\"buttonEnter\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtPassword1 != null : "fx:id=\"txtPassword1\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtPassword11 != null : "fx:id=\"txtPassword11\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtPassword12 != null : "fx:id=\"txtPassword12\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert txtPassword111 != null : "fx:id=\"txtPassword111\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnOtchestvo != null : "fx:id=\"columnOtchestvo\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnHours != null : "fx:id=\"columnHours\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnDays != null : "fx:id=\"columnDays\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnAmount != null : "fx:id=\"columnAmount\" was not injected: check your FXML file 'editing-employees.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'editing-employees.fxml'.";

    }
}
