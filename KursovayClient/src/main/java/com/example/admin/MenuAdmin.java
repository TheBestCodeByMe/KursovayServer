package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.admin.salary.CommisionSystemPercentage;
import com.example.admin.salary.PieceworkCalculation;
import com.example.constants.Constants;
import com.example.kursovayclient.*;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuAdmin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBlockUsers;

    @FXML
    private Button buttonEditUsers;

    @FXML
    private Button buttonViewUsers;

    @FXML
    private Button buttonCommSystem;

    @FXML
    private Button buttonPieceworkSystem;

    @FXML
    private Button buttonVariebleSystem;

    @FXML
    private Button buttonOutput;

    @FXML
    private Button buttonEditEmployee;

    @FXML
    private Button buttonViewCompany;

    @FXML
    private Button buttonEditCompany;

    @FXML
    void initialize() {

    }

    @FXML
    void clickViewCompany(ActionEvent event) {
        try {
            buttonViewCompany.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Company viewCompany = new View_Company();
            viewCompany.start(stage);
            Constants.FLAG_TRANSITION = false;
        } catch (Exception e) {
            System.out.println("Cannot open view company.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickEditCompany(ActionEvent event) {
        try {
            buttonViewCompany.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Edit_Company editCompany = new Edit_Company();
            editCompany.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open view company.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickEditUsers(ActionEvent event) throws IOException {
        try {
            buttonEditUsers.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Edit_Users editUser = new Edit_Users();
            editUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open editing users.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickBlockUsers(ActionEvent event) throws IOException {
        try {
            buttonBlockUsers.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Block_Users blockUser = new Block_Users();
            blockUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open block users.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickViewUsers(ActionEvent event) throws IOException {
        try {
            buttonViewUsers.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            View_Users viewUser = new View_Users();
            viewUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open view users.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickEditEmployee(ActionEvent event) throws IOException {
        try {
            buttonEditEmployee.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Edit_Employee editEmployee = new Edit_Employee();
            editEmployee.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open edit employees.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickOutput(ActionEvent event) throws IOException {
        HelpersCl.backToMain(buttonOutput);
    }

    @FXML
    void clickVariebleSystem(ActionEvent event) throws IOException {
        HelpersCl.backToVariebleSystem(buttonVariebleSystem);
    }

    @FXML
    void clickCommSystem(ActionEvent event) throws IOException {
        HelpersCl.backToCommSystem(buttonCommSystem);
    }

    @FXML
    void clickPieceworkSystem(ActionEvent event) throws IOException {
        HelpersCl.backToPieceworkSystem(buttonPieceworkSystem);
    }
}


