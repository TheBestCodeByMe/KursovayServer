package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Users;
import com.example.entity.property.UsersProperty;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditingUsers {
    InteractionsWithServer interactionsWithServer;
    ActionEvent event;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonEnter;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPassword1;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonUpdate;

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

    private final ObservableList<UsersProperty> usersObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnLogin.setCellValueFactory(cellValue -> cellValue.getValue().loginProperty());
        columnPassword.setCellValueFactory(cellValue -> cellValue.getValue().passwordProperty());
        columnBlock.setCellValueFactory(cellValue -> cellValue.getValue().statusProperty());

        clickUpdate(event);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickUpdate(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.updateUsers(usersObservableList, interactionsWithServer, tableUsers);
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.registration(txtLogin.getText(), txtPassword.getText(), txtPassword1.getText());
        clickUpdate(event);
    }

    @FXML
    void clickDelete(ActionEvent event) throws IOException, ClassNotFoundException {
        if (tableUsers.getSelectionModel().getSelectedItem() != null) {
            int id = tableUsers.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.deleteUsers(id);
            clickUpdate(event);
        } else {
            HelpersCl.bug("Вы не выбрали пользователя для удаления!");
        }
    }
}
