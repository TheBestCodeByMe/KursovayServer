package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Commision_System;
import com.example.kursovayclient.Menu_Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CommissionSystemPercenageLeastFixedSalary {

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
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert columnPatronymic != null : "fx:id=\"columnPatronymic\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert columnSalaries != null : "fx:id=\"columnSalaries\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";
        assert txtIncome != null : "fx:id=\"txtIncome\" was not injected: check your FXML file 'commission-system-percenage-least-fixed-salary.fxml'.";

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