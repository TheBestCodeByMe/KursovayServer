package com.example.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.Employee;
import com.example.entity.property.DescriptionProperty;
import com.example.entity.property.EmployeeProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditingEmployees {

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatronymic;

    @FXML
    private TextField txtDays;

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

    @FXML
    private TableColumn<DescriptionProperty, Double> columnAmount1;

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    private final ObservableList<EmployeeProperty> employeePropertyObservableList = FXCollections.observableArrayList();
    private final ObservableList<DescriptionProperty> descriptionPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        HelpersCl.viewTableEmployee(columnId, columnName, columnFam, columnOtchestvo);
        HelpersCl.viewTableDescriptionInEditWorkers(columnDays, columnHours, columnAmount, columnAmount1);

        clickUpdate(event1);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        String name = txtName.getText();
        String lastname = txtLastname.getText();
        String patronymic = txtPatronymic.getText();
        String ficsSalary = txtDays.getText();

        if (HelpersCl.validateTextFields(name, lastname, patronymic)) {
            if (ficsSalary.matches(Constants.REGULAR_FOR_SALARY) &&
                    name.matches(Constants.REGULAR_FOR_EMPLOYEE) &&
                    lastname.matches(Constants.REGULAR_FOR_EMPLOYEE) &&
                    patronymic.matches(Constants.REGULAR_FOR_EMPLOYEE)) {
                String result = interactionsWithServer.addWorker(name, lastname, patronymic);
                interactionsWithServer.addSalaries(name, lastname, patronymic);
                if (result.equals("true")) {
                    HelpersCl.notBug("Добавление работника прошло успешно.");
                    if (Integer.parseInt(ficsSalary) <= 0) {
                        HelpersCl.bug("Фиксированный оклад не может быть меньше 0 и 0.");
                    } else {
                        interactionsWithServer.addDescription("0", "0", ficsSalary, "0", name, lastname, patronymic);
                        txtName.setText("");
                        txtLastname.setText("");
                        txtPatronymic.setText("");
                        txtDays.setText("");
                    }
                    interactionsWithServer.updateCompany();
                    clickUpdate(event1);
                } else if (result.equals("Работник с таким ФИО уже существует.")) {
                    HelpersCl.bug("Такие работники уже существуют");
                } else {
                    HelpersCl.bug("Работник не состоит в компании. Сначала добавьте компанию.");
                }
            } else {
                HelpersCl.bug("Некорректный ввод.");
            }
        } else {
            HelpersCl.bug("ФИО работника должно быть заполнено!!!");
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.updateDescriptions(descriptionPropertyObservableList, interactionsWithServer, tableDescription);

        employeePropertyObservableList.clear();

        ArrayList<Employee> workers = interactionsWithServer.showAllEmployes();
        for (Employee worker : workers) {
            EmployeeProperty e = new EmployeeProperty(worker);
            employeePropertyObservableList.add(e);
        }

        tableFIO.setItems(employeePropertyObservableList);
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
}
