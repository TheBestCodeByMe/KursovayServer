package com.example.user;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.kursovayclient.*;
import com.example.helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuUser {

    @FXML
    private Button buttonSpentDaysHours;

    @FXML
    private Button buttonChangePass;

    @FXML
    private Button buttonChangeFIO;

    @FXML
    private Button buttonOutput;

    @FXML
    private Button buttonViewSalary;

    @FXML
    private Button buttonViewCompany;

    @FXML
    void clickViewCompany(ActionEvent event){
        try {
            buttonViewCompany.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Company viewCompany = new View_Company();
            viewCompany.start(stage);
            Constants.FLAG_TRANSITION = true;
        } catch (Exception e) {
            System.out.println("Cannot open view company.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickChangeFIO(ActionEvent event) {
        try {
            buttonChangeFIO.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Change_FIO changeFio = new Change_FIO();
            changeFio.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open change FIO.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickChangePass(ActionEvent event) {
        try {
            buttonChangePass.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Change_Password changePassword = new Change_Password();
            changePassword.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open change password.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickOutput(ActionEvent event) {
        HelpersCl.backToMain(buttonOutput);
    }

    @FXML
    void clickSpentDaysHours(ActionEvent event) {
        try {
            buttonSpentDaysHours.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Spent_Days spentDays = new Spent_Days();
            spentDays.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open spent days and hours.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickViewSalary(ActionEvent event) {
        try {
            buttonViewSalary.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Salaries viewSalaries = new View_Salaries();
            viewSalaries.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open view salary.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickGrafics(ActionEvent event) {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Grafics viewGrafics = new View_Grafics();
            viewGrafics.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open view diagram.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickGrafics1(ActionEvent event) {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Grafics1 viewGrafics = new View_Grafics1();
            viewGrafics.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open grafic.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickSave(ActionEvent event) throws IOException, ClassNotFoundException {
        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        HelpersCl.notBug(interactionsWithServer.saveFile());
    }
}
