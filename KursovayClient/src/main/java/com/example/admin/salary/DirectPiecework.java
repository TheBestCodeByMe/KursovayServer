package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Menu_Admin;
import com.example.kursovayclient.Piecework_System;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DirectPiecework {

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

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Piecework_System pieceworkSystem = new Piecework_System();
            pieceworkSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open piecework system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
    }

    @FXML
    void clickPayment(ActionEvent event) {
    }
}
