package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Users;
import com.example.entity.property.UsersProperty;
import com.example.kursovayclient.Menu_Admin;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

        usersObservableList.clear();

        ArrayList<Users> users = interactionsWithServer.showAllUsers();
        for (Users user : users) {
            UsersProperty e = new UsersProperty(user);
            usersObservableList.add(e);
        }

        tableUsers.setItems(usersObservableList);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }
}
