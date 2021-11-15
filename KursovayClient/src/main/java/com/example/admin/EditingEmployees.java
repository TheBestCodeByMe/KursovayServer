package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Company;
import com.example.entity.Description;
import com.example.entity.Employee;
import com.example.entity.property.CompanyProperty;
import com.example.entity.property.DescriptionProperty;
import com.example.entity.property.EmployeeProperty;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditingEmployees {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonEnter;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatronymic;

    @FXML
    private TextField txtHours;

    @FXML
    private TextField txtDays;

    @FXML
    private TextField txtProducts;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<EmployeeProperty> tableFIO;

    @FXML
    private TableColumn<EmployeeProperty, Integer> columnId;

    @FXML
    private TableColumn<EmployeeProperty, String> columnFam;

    @FXML
    private TableColumn<EmployeeProperty, String> columnName;

    @FXML
    private TableColumn<EmployeeProperty, String> columnOtchestvo;

    @FXML
    private TableView<DescriptionProperty> tableDescription;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnHours;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnDays;

    @FXML
    private TableColumn<DescriptionProperty, Integer> columnAmount;

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<DescriptionProperty> descriptionPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnName.setCellValueFactory(cellValue -> cellValue.getValue().nameProperty());
        columnFam.setCellValueFactory(cellValue -> cellValue.getValue().lastNameProperty());
        columnOtchestvo.setCellValueFactory(cellValue -> cellValue.getValue().patronymicProperty());
        columnDays.setCellValueFactory(cellValue -> cellValue.getValue().daysProperty().asObject());
        columnHours.setCellValueFactory(cellValue -> cellValue.getValue().hoursProperty().asObject());
        columnAmount.setCellValueFactory(cellValue -> cellValue.getValue().numbOfProdProperty().asObject());

        clickUpdate(event1);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        if (validateTextFields(txtName.getText(), txtLastname.getText(), txtPatronymic.getText())) {
            String result = interactionsWithServer.addWorker(txtName.getText(), txtLastname.getText(), txtPatronymic.getText());
            if (result.equals("true")) {
                HelpersCl.bug("Добавление работника прошло успешно.");
                String days = txtDays.getText();
                String hours = txtHours.getText();
                String products = txtProducts.getText();
                if (days.equals("") || days.matches("-?([1-9][0-9]*)?") && hours.equals("") || hours.matches("-?([1-9][0-9]*)?") && products.equals("") || products.matches("-?([1-9][0-9]*)?")) {
                    if (days.equals("")) {
                        days = "0";
                    }
                    if (hours.equals("")) {
                        hours = "0";
                    }
                    if (products.equals("")) {
                        products = "0";
                    }
                    if (Integer.parseInt(days) < 0 || Integer.parseInt(hours) < 0 || Integer.parseInt(products) < 0) {
                        HelpersCl.bug("Число не должно быть меньше 0.");
                    } else {
                        interactionsWithServer.addDescription(days, hours, products, txtName.getText(), txtLastname.getText(), txtPatronymic.getText());
                        txtName.setText("");
                        txtLastname.setText("");
                        txtPatronymic.setText("");
                        txtDays.setText("");
                        txtHours.setText("");
                        txtProducts.setText("");
                    }
                } else {
                    HelpersCl.bug("Вы ввели не цифры.");
                }
                interactionsWithServer.updateCompany();
                clickUpdate(event1);
            } else if (result.equals("Работник с таким ФИО уже существует.")) {
                HelpersCl.bug("Такие работники уже существуют");
            } else {
                HelpersCl.bug("Работник не состоит в компании. Сначала добавьте компанию.");
            }
        } else {
            HelpersCl.bug("ФИО работника должно быть заполнено!!!");
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) throws IOException, ClassNotFoundException {
        employeePropertyObservableList.clear();
        descriptionPropertyObservableList.clear();

        ArrayList<Employee> workers = interactionsWithServer.showAllEmployes();
        ArrayList<Description> descriptions = interactionsWithServer.showAllDescription();
        for (Employee worker : workers) {
            EmployeeProperty e = new EmployeeProperty(worker);
            employeePropertyObservableList.add(e);
        }
        for (Description description : descriptions) {
            DescriptionProperty e = new DescriptionProperty(description);
            descriptionPropertyObservableList.add(e);
        }

        tableFIO.setItems(employeePropertyObservableList);
        tableDescription.setItems(descriptionPropertyObservableList);
    }

    @FXML
    void clickDelete(ActionEvent event) throws IOException, ClassNotFoundException {
        if (tableFIO.getSelectionModel().getSelectedItem() != null) {
            int id = tableFIO.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.deleteWorker(id);
            clickUpdate(event1);
        } else {
            HelpersCl.bug("Вы не выбрали работника для удаления!");
        }
        interactionsWithServer.updateDelCompany();
    }

    private static boolean validateTextFields(String name, String lastname, String patronymic) {
        return !Objects.equals(name, "") && !Objects.equals(lastname, "") && !Objects.equals(patronymic, "");
    }
}
