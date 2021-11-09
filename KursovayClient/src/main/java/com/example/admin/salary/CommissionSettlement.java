package com.example.admin.salary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.admin.EditingUsers;
import com.example.kursovayclient.*;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CommissionSettlement {

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
    private Button buttonUpdate1;

    @FXML
    void initialize() {

    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickPayment(ActionEvent event) {
        try {
            buttonPayment.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Commission_System_Percentage commisionSystemPercentage = new Commission_System_Percentage();
            commisionSystemPercentage.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission system percenage.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        try {
            buttonUpdate.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Comm_Fixed_Percentage commFixedPercentage = new Comm_Fixed_Percentage();
            commFixedPercentage.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission fixed percentage.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate1(ActionEvent event) {
        try {
            buttonUpdate1.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Comm_Least_Percenage commLeastPercenage = new Comm_Least_Percenage();
            commLeastPercenage.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission least fixed percentage.\nWith exception " + e.getLocalizedMessage());
        }
    }
}
