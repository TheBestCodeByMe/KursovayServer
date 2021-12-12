package com.example.admin;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.Company;
import com.example.entity.property.CompanyProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class EditCompany {

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
    private TextField txtName;

    ActionEvent event1 = new ActionEvent();
    InteractionsWithServer interactionsWithServer;
    private final ObservableList<CompanyProperty> companyPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
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
    void clickEditName(ActionEvent event) {
        if (!txtName.getText().equals("") && tableCompany.getSelectionModel().getSelectedItem() != null) {
            if(txtName.getText().matches(Constants.REGULAR_FOR_COMPANY)) {
                interactionsWithServer.changeNameCompany(txtName.getText(), tableCompany.getSelectionModel().getSelectedItem().getId());
                clickUpdate(event1);
            } else {
                HelpersCl.bug("Название компании не должно превышать 20 символов.");
            }
        } else {
            HelpersCl.bug("Название компании должно быть заполнено. А также должно быть выбрано id компании.");
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
    void clickAdd(ActionEvent event) {
        if (!txtName.getText().equals("")) {
            interactionsWithServer.addCompany(txtName.getText(), 0);
            clickUpdate(event1);
        } else {
            HelpersCl.bug("Название компании должно быть заполнено!!!");
        }
    }

    @FXML
    void clickDelete(ActionEvent event) {
        if (tableCompany.getSelectionModel().getSelectedItem() != null) {
            int id = tableCompany.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.deleteCompany(id);
            clickUpdate(event1);
        } else {
            HelpersCl.bug("Вы не выбрали компанию для удаления!");
        }
    }
}
