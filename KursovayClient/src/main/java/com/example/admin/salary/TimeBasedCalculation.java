package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TimeBasedCalculation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonUpdate;

    @FXML
    void initialize() {
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'time-based-calculation.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'time-based-calculation.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'time-based-calculation.fxml'.";
    }

    @FXML
    void clickPayment(ActionEvent event) {
        try {
            buttonPayment.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Time_Based_Hourly_Salary timeBasedHourlySalary = new Time_Based_Hourly_Salary();
            timeBasedHourlySalary.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open time based hourly salary.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        try {
            buttonUpdate.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Time_Based_Daily timeBasedDaily = new Time_Based_Daily();
            timeBasedDaily.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open time based daily.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_Admin menuAdmin = new Menu_Admin();
            menuAdmin.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open admin menu.\nWith exception " + e.getLocalizedMessage());
        }
    }
}
