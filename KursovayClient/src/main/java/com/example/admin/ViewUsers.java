package com.example.admin;

import com.example.connection.InteractionsWithServer;
import com.example.entity.property.UsersProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ViewUsers {

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<UsersProperty> tableUsers;

    @FXML
    private TableColumn<UsersProperty, Integer> columnId;

    @FXML
    private TableColumn<UsersProperty, String> columnLogin;

    @FXML
    private TableColumn<UsersProperty, String> columnPassword;

    @FXML
    private TableColumn<UsersProperty, String> columnBlock;

    InteractionsWithServer interactionsWithServer;
    private final ObservableList<UsersProperty> usersObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnLogin.setCellValueFactory(cellValue -> cellValue.getValue().loginProperty());
        columnPassword.setCellValueFactory(cellValue -> cellValue.getValue().passwordProperty());
        columnBlock.setCellValueFactory(cellValue -> cellValue.getValue().statusProperty());

        HelpersCl.updateUsers(usersObservableList, interactionsWithServer, tableUsers);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }
}
