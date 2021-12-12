package com.example.user;

import com.example.connection.InteractionsWithServer;
import com.example.entity.property.EmployeeProperty;
import com.example.entity.property.SalariesProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewRaiting {

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<EmployeeProperty> tableViewEmployee;

    @FXML
    private TableColumn<EmployeeProperty, Integer> columnId;

    @FXML
    private TableColumn<EmployeeProperty, String> columnFam;

    @FXML
    private TableColumn<EmployeeProperty, String> columnName;

    @FXML
    private TableColumn<EmployeeProperty, String> columnPatronymic;

    @FXML
    private TableView<SalariesProperty> tableViewMonth;

    @FXML
    private TableColumn<SalariesProperty, Double> columnJanuary;

    @FXML
    private TableColumn<SalariesProperty, Double> columnFebruary;

    @FXML
    private TableColumn<SalariesProperty, Double> columnMarch;

    @FXML
    private TableColumn<SalariesProperty, Double> columnApril;

    @FXML
    private TableColumn<SalariesProperty, Double> columnMay;

    @FXML
    private TableColumn<SalariesProperty, Double> columnJune;

    @FXML
    private TableColumn<SalariesProperty, Double> columnJuly;

    @FXML
    private TableColumn<SalariesProperty, Double> columnAugust;

    @FXML
    private TableColumn<SalariesProperty, Double> columnSeptember;

    @FXML
    private TableColumn<SalariesProperty, Double> columnOctober;

    @FXML
    private TableColumn<SalariesProperty, Double> columnNovember;

    @FXML
    private TableColumn<SalariesProperty, Double> columnDecember;

    InteractionsWithServer interactionsWithServer;
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<SalariesProperty> salariesPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();

        HelpersCl.viewTableEmployee(columnId, columnName, columnFam, columnPatronymic);
        HelpersCl.viewTableSalary(columnApril, columnAugust, columnDecember, columnFebruary, columnJanuary, columnJuly, columnJune, columnMarch, columnMay, columnNovember, columnOctober, columnSeptember);
        HelpersCl.updateEmployeeSalaries(employeePropertyObservableList, salariesPropertyObservableList, interactionsWithServer, tableViewEmployee, tableViewMonth);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuUser(buttonBack);
    }
}
