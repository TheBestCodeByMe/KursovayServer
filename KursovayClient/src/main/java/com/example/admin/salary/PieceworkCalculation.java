package com.example.admin.salary;

import com.example.kursovayclient.*;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PieceworkCalculation {

    @FXML
    private Button buttonPayment;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonUpdate;

    @FXML
    void initialize() {
        assert buttonPayment != null : "fx:id=\"buttonPayment\" was not injected: check your FXML file 'piecework-calculation.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'piecework-calculation.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'piecework-calculation.fxml'.";
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickPayment(ActionEvent event) {
        try {
            buttonUpdate.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Direct_Piecework directPiecework = new Direct_Piecework();
            directPiecework.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open direct piecework.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        try {
            buttonPayment.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Indirectly_Piecework indirectlyPiecework = new Indirectly_Piecework();
            indirectlyPiecework.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open indirectly piecework.\nWith exception " + e.getLocalizedMessage());
        }
    }
}
