package com.example.adminuser;

import java.io.IOException;
import java.util.ArrayList;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.Company;
import com.example.entity.property.CompanyProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewCompany {

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

    InteractionsWithServer interactionsWithServer;
    private final ObservableList<CompanyProperty> companyPropertyObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnName.setCellValueFactory(cellValue -> cellValue.getValue().nameProperty());
        columnNumbEmpl.setCellValueFactory(cellValue -> cellValue.getValue().numberEmplProperty().asObject());

        companyPropertyObservableList.clear();

        ArrayList<Company> companies = interactionsWithServer.showAllCompany();
        for (Company company : companies) {
            CompanyProperty e = new CompanyProperty(company);
            companyPropertyObservableList.add(e);
        }

        tableCompany.setItems(companyPropertyObservableList);
    }

    @FXML
    void clickBack(ActionEvent event){
        if(Constants.FLAG_TRANSITION)
        {
            HelpersCl.backToMenuUser(buttonBack);
        } else{
            HelpersCl.backToMenuAdmin(buttonBack);
        }
    }
}
