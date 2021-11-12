package com.example.admin;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.Company;
import com.example.entity.property.CompanyProperty;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditCompany {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<CompanyProperty> tableCompany;

    @FXML
    private TableColumn<CompanyProperty, Integer> columnId;

    @FXML
    private TableColumn<CompanyProperty, String> columnName;

    @FXML
    private TableColumn<CompanyProperty, Integer> columnNumbEmpl;

    @FXML
    private Button butttonAdd;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonEditName;

    @FXML
    private TextField txtName;

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final ObservableList<CompanyProperty> companyPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnName.setCellValueFactory(cellValue -> cellValue.getValue().nameProperty());
        columnNumbEmpl.setCellValueFactory(cellValue -> cellValue.getValue().numberEmplProperty().asObject());

        clickUpdate(event1);
    }

    @FXML
    void clickBack(ActionEvent event) {
            HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickEditName(ActionEvent event) throws IOException {
        if (!txtName.getText().equals("") && tableCompany.getSelectionModel().getSelectedItem() != null) {
            interactionsWithServer.changeNameCompany(txtName.getText(), tableCompany.getSelectionModel().getSelectedItem().getId());
            clickUpdate(event1);
        } else {
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Название компании должно быть заполнено!!! А также выбрана компания, у которой изменяется имя.");
            alert.showAndWait();
        }
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        companyPropertyObservableList.clear();

        ArrayList<Company> companies = interactionsWithServer.showAllCompany();
        for (Company company : companies) {
            CompanyProperty e = new CompanyProperty(company);
            companyPropertyObservableList.add(e);
        }

        tableCompany.setItems(companyPropertyObservableList);
    }

    @FXML
    void clickAdd(ActionEvent event) throws IOException, ClassNotFoundException {
        if (!txtName.getText().equals("")) {
            interactionsWithServer.addCompany(txtName.getText(), 0);
        } else {
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Название компании должно быть заполнено!!!");
            alert.showAndWait();
        }
    }

    @FXML
    void clickDelete(ActionEvent event) {
        if (tableCompany.getSelectionModel().getSelectedItem() != null) {
            int id = tableCompany.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.deleteCompany(id);
            clickUpdate(event1);
        } else {
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не выбрали пользователя для удаления!");
            alert.showAndWait();
        }
    }
}
