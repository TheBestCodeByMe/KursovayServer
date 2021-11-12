package com.example.adminuser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.entity.Company;
import com.example.entity.Users;
import com.example.entity.property.CompanyProperty;
import com.example.entity.property.UsersProperty;
import com.example.kursovayclient.Menu_User;
import helpers.HelpersCl;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewCompany {

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
