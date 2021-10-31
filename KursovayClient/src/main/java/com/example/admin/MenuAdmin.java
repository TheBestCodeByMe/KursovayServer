package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.admin.salary.CommisionSystemPercentage;
import com.example.admin.salary.PieceworkCalculation;
import com.example.kursovayclient.*;
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
    private Button buttonAddDays;

    @FXML
    private Button buttonAddHours;

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
    private Button buttonAddUsers;

    @FXML
    private Button buttonEditEmployee;

    @FXML
    void initialize() {

    }

    @FXML
    void clickAddUsers(ActionEvent event) throws IOException {
        try {
            buttonAddUsers.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Add_Users userMenu = new Add_Users();
            userMenu.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open registration.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickAddDays(ActionEvent event) throws IOException {
        try {
            buttonAddDays.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Add_Days add_days = new Add_Days();
            add_days.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open add working days.\nWith exception " + e.getLocalizedMessage());
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
        try {
            buttonOutput.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Main main = new Main();
            main.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open main.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickVariebleSystem(ActionEvent event) throws IOException {
        try {
            buttonVariebleSystem.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Varieble_System variebleSystem = new Varieble_System();
            variebleSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open varieble system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickCommSystem(ActionEvent event) throws IOException {
        try {
            buttonCommSystem.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Commision_System commisionSystem = new Commision_System();
            commisionSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickPieceworkSystem(ActionEvent event) throws IOException {
        try {
            buttonPieceworkSystem.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Piecework_System pieceworkSystem = new Piecework_System();
            pieceworkSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open piecework system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickAddHours(ActionEvent event) throws IOException {
        try {
            buttonAddHours.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Add_Hours add_hours = new Add_Hours();
            add_hours.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open add working hours.\nWith exception " + e.getLocalizedMessage());
        }
    }
}


