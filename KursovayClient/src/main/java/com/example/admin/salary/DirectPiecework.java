package com.example.admin.salary;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.property.DescriptionProperty;
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

public class DirectPiecework {

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

    @FXML
    private TableView<DescriptionProperty> tableViewDescription;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnHours;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnDays;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnKol;

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<SalariesProperty> salariesPropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<DescriptionProperty> descriptionPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        HelpersCl.viewTableEmployee(columnId, columnName, columnFam, columnPatronymic);
        HelpersCl.viewTableSalary(columnApril, columnAugust, columnDecember, columnFebruary, columnJanuary, columnJuly, columnJune, columnMarch, columnMay, columnNovember, columnOctober, columnSeptember);
        HelpersCl.viewTableDescription(columnDays, columnHours, columnKol);

        clickUpdate(event1);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToPieceworkSystem(buttonBack);
    }

    @FXML
    void clickUpdate(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.updateEmployeeSalaries(employeePropertyObservableList, salariesPropertyObservableList, interactionsWithServer, tableViewEmployee, tableViewMonth);
        HelpersCl.updateDescriptions(descriptionPropertyObservableList, interactionsWithServer, tableViewDescription);
    }

    @FXML
    void clickPayment(ActionEvent event) throws IOException, ClassNotFoundException {
        String numberProducts = txtIncome.getText();
        String month = txtMonth.getText();

        if (HelpersCl.validateTextFields(numberProducts, month)) {
            if (tableViewEmployee.getSelectionModel().getSelectedItem() != null) {
                if (HelpersCl.validateTextFields(month)) {
                    if (numberProducts.matches(Constants.REGULAR_FOR_INTEGER)) {
                        int id = tableViewEmployee.getSelectionModel().getSelectedItem().getId();
                        interactionsWithServer.calculateDirect(id, Integer.parseInt(numberProducts), HelpersCl.replacementMonth(month));
                        interactionsWithServer.changeNumbProduct(numberProducts, id);
                        txtMonth.setText("");
                        txtIncome.setText("");
                    } else {
                        HelpersCl.bug("Вы ввели некорректное число продукции.");
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
