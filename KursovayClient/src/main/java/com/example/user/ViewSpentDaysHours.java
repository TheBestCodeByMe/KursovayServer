package com.example.user;

import java.io.IOException;
import java.util.ArrayList;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Employee;
import com.example.entity.property.DescriptionProperty;
import com.example.entity.property.EmployeeProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewSpentDaysHours {


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
    private TableView<DescriptionProperty> tableViewDescription;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnHours;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnDays;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnKol;

    InteractionsWithServer interactionsWithServer;
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<DescriptionProperty> descriptionPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        HelpersCl.viewTableEmployee(columnId, columnName, columnFam, columnPatronymic);
        HelpersCl.viewTableDescription(columnDays, columnHours, columnKol);
        HelpersCl.updateDescriptions(descriptionPropertyObservableList, interactionsWithServer, tableViewDescription);

        employeePropertyObservableList.clear();

        ArrayList<Employee> workers = interactionsWithServer.showAllEmployes();
        for (Employee worker : workers) {
            EmployeeProperty e = new EmployeeProperty(worker);
            employeePropertyObservableList.add(e);
        }

        tableViewEmployee.setItems(employeePropertyObservableList);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuUser(buttonBack);
    }
}
