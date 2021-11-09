package com.example.admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Menu_Admin;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickEnter(ActionEvent event)
    {}

    @FXML
    void clickUpdate(ActionEvent event)
    {}

    @FXML
    void clickDelete(ActionEvent event){}
}
