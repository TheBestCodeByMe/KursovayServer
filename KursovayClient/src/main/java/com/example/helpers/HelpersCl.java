package com.example.helpers;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.*;
import com.example.entity.property.DescriptionProperty;
import com.example.entity.property.EmployeeProperty;
import com.example.entity.property.SalariesProperty;
import com.example.entity.property.UsersProperty;
import com.example.kursovayclient.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HelpersCl {

    public static void backToMenuAdmin(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_Admin menuAdmin = new Menu_Admin();
            menuAdmin.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open admin menu.\nWith exception " + e.getLocalizedMessage());
        }
    }

    public static void backToCommSystem(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Commision_System commisionSystem = new Commision_System();
            commisionSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open commission system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    public static void backToPieceworkSystem(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Piecework_System pieceworkSystem = new Piecework_System();
            pieceworkSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open piecework system.\nWith exception " + e.getLocalizedMessage());
        }

    }

    public static void backToVariebleSystem(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Varieble_System variebleSystem = new Varieble_System();
            variebleSystem.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open varieble system.\nWith exception " + e.getLocalizedMessage());
        }
    }

    public static void backToMain(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Main main = new Main();
            main.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open main.\nWith exception " + e.getLocalizedMessage());
        }
    }

    public static void backToMenuUser(Button buttonBack) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_User menuUser = new Menu_User();
            menuUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open menu user.\nWith exception " + e.getLocalizedMessage());
        }
    }

    public static void registration(String login, String password, String repeatPassword) throws IOException, ClassNotFoundException {
        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        if (validateTextFields(login, password, repeatPassword)) {
            if (login.matches(Constants.REGULAR_FOR_LOGIN) && password.matches(Constants.REGULAR_FOR_PASSWORD)) {
                if (password.equals(repeatPassword)) {
                    if (!login.equals("admin")) {
                        if (interactionsWithServer.registerUser(login, password)) {
                            notBug("?????????????????????? ???????????? ??????????????.");
                        } else {
                            bug("???????????????????????? ?? ?????????? ?????????????? ?????? ????????????????????.");
                        }
                    } else {
                        bug("?????????????????? ???????? ?????????? ???????????????????????? ????????????.");
                    }
                } else {
                    bug("???????????? ???? ??????????????????.");
                }
            } else {
                HelpersCl.bug("?????????? ?? ???????????? ???? ???????????? ?????????????????? 20 ????????????????.\n?????????????????????? ??????????????:\n????????????????-???????????????? ???????????? ?? ?????????? ??????????????????????????");
            }
        } else {
            bug("?????? ???????? ???????????? ???????? ??????????????????!!!");
        }
    }

    public static boolean validateTextFields(String login, String password, String repeatPassword) {
        return !Objects.equals(login, "") && !Objects.equals(password, "") && !Objects.equals(repeatPassword, "");
    }

    public static void viewTableEmployee(TableColumn<EmployeeProperty, Integer> columnId, TableColumn<EmployeeProperty, String> columnName, TableColumn<EmployeeProperty, String> columnFam, TableColumn<EmployeeProperty, String> columnPatronymic) {
        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnName.setCellValueFactory(cellValue -> cellValue.getValue().nameProperty());
        columnFam.setCellValueFactory(cellValue -> cellValue.getValue().lastNameProperty());
        columnPatronymic.setCellValueFactory(cellValue -> cellValue.getValue().patronymicProperty());
    }

    public static void viewTableSalary(TableColumn<SalariesProperty, Double> columnApril, TableColumn<SalariesProperty, Double> columnAugust, TableColumn<SalariesProperty, Double> columnDecember, TableColumn<SalariesProperty, Double> columnFebruary, TableColumn<SalariesProperty, Double> columnJanuary, TableColumn<SalariesProperty, Double> columnJuly, TableColumn<SalariesProperty, Double> columnJune, TableColumn<SalariesProperty, Double> columnMarch, TableColumn<SalariesProperty, Double> columnMay, TableColumn<SalariesProperty, Double> columnNovember, TableColumn<SalariesProperty, Double> columnOctober, TableColumn<SalariesProperty, Double> columnSeptember) {
        columnApril.setCellValueFactory(cellValue -> cellValue.getValue().aprilProperty().asObject());
        columnAugust.setCellValueFactory(cellValue -> cellValue.getValue().augustProperty().asObject());
        columnDecember.setCellValueFactory(cellValue -> cellValue.getValue().decemberProperty().asObject());
        columnFebruary.setCellValueFactory(cellValue -> cellValue.getValue().februaryProperty().asObject());
        columnJanuary.setCellValueFactory(cellValue -> cellValue.getValue().januaryProperty().asObject());
        columnJuly.setCellValueFactory(cellValue -> cellValue.getValue().julyProperty().asObject());
        columnJune.setCellValueFactory(cellValue -> cellValue.getValue().juneProperty().asObject());
        columnMarch.setCellValueFactory(cellValue -> cellValue.getValue().marchProperty().asObject());
        columnMay.setCellValueFactory(cellValue -> cellValue.getValue().mayProperty().asObject());
        columnNovember.setCellValueFactory(cellValue -> cellValue.getValue().novemberProperty().asObject());
        columnOctober.setCellValueFactory(cellValue -> cellValue.getValue().octoberProperty().asObject());
        columnSeptember.setCellValueFactory(cellValue -> cellValue.getValue().septemberProperty().asObject());
    }

    public static void viewTableDescription(TableColumn<DescriptionProperty, Integer> columnDays, TableColumn<DescriptionProperty, Integer> columnHours, TableColumn<DescriptionProperty, Integer> columnAmount) {
        columnDays.setCellValueFactory(cellValue -> cellValue.getValue().daysProperty().asObject());
        columnHours.setCellValueFactory(cellValue -> cellValue.getValue().hoursProperty().asObject());
        columnAmount.setCellValueFactory(cellValue -> cellValue.getValue().numbOfProdProperty().asObject());
    }

    public static void viewTableDescriptionInEditWorkers(TableColumn<DescriptionProperty, Integer> columnDays, TableColumn<DescriptionProperty, Integer> columnHours, TableColumn<DescriptionProperty, Integer> columnAmount, TableColumn<DescriptionProperty, Double> columnAmount1) {
        columnDays.setCellValueFactory(cellValue -> cellValue.getValue().daysProperty().asObject());
        columnHours.setCellValueFactory(cellValue -> cellValue.getValue().hoursProperty().asObject());
        columnAmount.setCellValueFactory(cellValue -> cellValue.getValue().numbOfProdProperty().asObject());
        columnAmount1.setCellValueFactory(cellValue -> cellValue.getValue().ficsSalaryProperty().asObject());
    }

    public static void updateEmployeeSalaries(ObservableList<EmployeeProperty> employeePropertyObservableList, ObservableList<SalariesProperty> salariesPropertyObservableList, InteractionsWithServer interactionsWithServer, TableView<EmployeeProperty> tableViewEmployee, TableView<SalariesProperty> tableViewMonth) throws IOException, ClassNotFoundException {
        employeePropertyObservableList.clear();
        salariesPropertyObservableList.clear();

        ArrayList<Employee> workers = interactionsWithServer.showAllEmployes();
        ArrayList<Salaries> salaries = interactionsWithServer.viewSalaries();
        for (Employee worker : workers) {
            EmployeeProperty e = new EmployeeProperty(worker);
            employeePropertyObservableList.add(e);
        }
        for (Salaries salary : salaries) {
            SalariesProperty e = new SalariesProperty(salary);
            salariesPropertyObservableList.add(e);
        }

        tableViewEmployee.setItems(employeePropertyObservableList);
        tableViewMonth.setItems(salariesPropertyObservableList);
    }

    public static void updateDescriptions(ObservableList<DescriptionProperty> descriptionPropertyObservableList, InteractionsWithServer interactionsWithServer, TableView<DescriptionProperty> tableDescription) throws IOException, ClassNotFoundException {
        descriptionPropertyObservableList.clear();

        ArrayList<Description> descriptions = interactionsWithServer.showAllDescription();

        for (Description description : descriptions) {
            DescriptionProperty e = new DescriptionProperty(description);
            descriptionPropertyObservableList.add(e);
        }

        tableDescription.setItems(descriptionPropertyObservableList);
    }

    public static void updateUsers(ObservableList<UsersProperty> usersObservableList, InteractionsWithServer interactionsWithServer, TableView<UsersProperty> tableUsers) throws IOException, ClassNotFoundException {
        usersObservableList.clear();

        ArrayList<Users> users = interactionsWithServer.showAllUsers();
        for (Users user : users) {
            UsersProperty e = new UsersProperty(user);
            usersObservableList.add(e);
        }

        tableUsers.setItems(usersObservableList);
    }

    public static boolean validateTextFields(String month) {
        return month.equalsIgnoreCase("??????????????") || month.equalsIgnoreCase("????????????") || month.equalsIgnoreCase("??????????????") || month.equalsIgnoreCase("????????") || month.equalsIgnoreCase("????????????") || month.equalsIgnoreCase("??????") || month.equalsIgnoreCase("????????") || month.equalsIgnoreCase("????????") || month.equalsIgnoreCase("????????????") || month.equalsIgnoreCase("????????????????") || month.equalsIgnoreCase("??????????????") || month.equalsIgnoreCase("????????????");
    }

    public static String replacementMonth(String month) {
        if (month.equalsIgnoreCase("??????????????")) {
            return "december";
        }
        if (month.equalsIgnoreCase("????????????")) {
            return "january";
        }
        if (month.equalsIgnoreCase("??????????????")) {
            return "february";
        }
        if (month.equalsIgnoreCase("????????????")) {
            return "april";
        }
        if (month.equalsIgnoreCase("??????")) {
            return "may";
        }
        if (month.equalsIgnoreCase("????????")) {
            return "june";
        }
        if (month.equalsIgnoreCase("????????")) {
            return "july";
        }
        if (month.equalsIgnoreCase("????????????")) {
            return "august";
        }
        if (month.equalsIgnoreCase("????????????????")) {
            return "september";
        }
        if (month.equalsIgnoreCase("??????????????")) {
            return "october";
        }
        if (month.equalsIgnoreCase("????????????")) {
            return "november";
        }
        if (month.equalsIgnoreCase("????????")) {
            return "march";
        }
        return "";
    }

    public static boolean validateTextFields(String profitability, String month) {
        return !Objects.equals(profitability, "") && !Objects.equals(month, "");
    }

    public static void bug(String str) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("????????????");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }

    public static void notBug(String str) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("??????????????????????");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
}
