package com.example.admin.salary;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.property.EmployeeProperty;
import com.example.entity.property.SalariesProperty;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CommissionSystemPercenageLeastFixedSalary {

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
    private TextField txtIncome;

    @FXML
    private TextField txtMonth;

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

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<SalariesProperty> salariesPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        HelpersCl.viewTableEmployee(columnId, columnName, columnFam, columnPatronymic);
        HelpersCl.viewTableSalary(columnApril, columnAugust, columnDecember, columnFebruary, columnJanuary, columnJuly, columnJune, columnMarch, columnMay, columnNovember, columnOctober, columnSeptember);

        clickUpdate(event1);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToCommSystem(buttonBack);
    }

    @FXML
    void clickUpdate(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.updateEmployeeSalaries(employeePropertyObservableList, salariesPropertyObservableList, interactionsWithServer, tableViewEmployee, tableViewMonth);
    }

    @FXML
    void clickPayment(ActionEvent event) throws IOException, ClassNotFoundException {
        String profitability = txtIncome.getText();
        String month = txtMonth.getText();

        if (HelpersCl.validateTextFields(profitability, month)) {
            if (tableViewEmployee.getSelectionModel().getSelectedItem() != null) {
                if (HelpersCl.validateTextFields(month)) {
                    if (profitability.matches(Constants.REGULAR_FOR_SALARY)) {
                        interactionsWithServer.calculateCommPercLeast(tableViewEmployee.getSelectionModel().getSelectedItem().getId(), HelpersCl.replacementMonth(month), Double.parseDouble(profitability));
                        txtMonth.setText("");
                        txtIncome.setText("");
                    } else {
                        HelpersCl.bug("Вы ввели некорректное число. Число должно содержать не более 2 знаков после запятой, а также быть положительным.");
                    }
                    clickUpdate(event1);
                } else {
                    HelpersCl.bug("Такого месяца не существует.");
                }
            } else {
                HelpersCl.bug("Вы не выбрали работника.");
            }
        } else {
            HelpersCl.bug("Все поля должны быть заполнены!!!");
        }
    }
}
