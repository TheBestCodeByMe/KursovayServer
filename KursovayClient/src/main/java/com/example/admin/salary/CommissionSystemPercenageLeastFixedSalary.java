package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Commision_System;
import com.example.kursovayclient.Menu_Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CommissionSystemPercenageLeastFixedSalary {

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<?> tableViewEmployee;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnFam;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPatronymic;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TextField txtIncome;

    @FXML
    private TextField txtMonth;

    @FXML
    private TableView<?> tableViewMonth;

    @FXML
    private TableColumn<?, ?> columnJanuary;

    @FXML
    private TableColumn<?, ?> columnFebruary;

    @FXML
    private TableColumn<?, ?> columnMarch;

    @FXML
    private TableColumn<?, ?> columnApril;

    @FXML
    private TableColumn<?, ?> columnMay;

    @FXML
    private TableColumn<?, ?> columnJune;

    @FXML
    private TableColumn<?, ?> columnJuly;

    @FXML
    private TableColumn<?, ?> columnAugust;

    @FXML
    private TableColumn<?, ?> columnSeptember;

    @FXML
    private TableColumn<?, ?> columnOctober;

    @FXML
    private TableColumn<?, ?> columnNovember;

    @FXML
    private TableColumn<?, ?> columnDecember;

    @FXML
    void initialize() {

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Commision_System commisionSystem = new Commision_System();
            commisionSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
    }

    @FXML
    void clickPayment(ActionEvent event) {
    }
}
