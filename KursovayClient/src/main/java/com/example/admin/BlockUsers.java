package com.example.admin;

import java.util.*;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Users;
import com.example.entity.property.UsersProperty;
import com.example.helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BlockUsers {
    InteractionsWithServer interactionsWithServer;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<UsersProperty> tableUser;

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
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnLogin.setCellValueFactory(cellValue -> cellValue.getValue().loginProperty());
        columnPassword.setCellValueFactory(cellValue -> cellValue.getValue().passwordProperty());
        columnBlock.setCellValueFactory(cellValue -> cellValue.getValue().statusProperty());

        update();
    }

    public void update() {
        usersObservableList.clear();

        ArrayList<Users> users = interactionsWithServer.showAllUsers();
        for (Users user : users) {
            UsersProperty e = new UsersProperty(user);
            usersObservableList.add(e);
        }

        tableUser.setItems(usersObservableList);
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickBlock(ActionEvent event) {
        int id = tableUser.getSelectionModel().getSelectedItem().getId();

        if (tableUser.getSelectionModel().getSelectedItem() != null) {
            interactionsWithServer.blockUsers(id);
        } else {
            HelpersCl.bug("Вы не выбрали пользователя.");
        }

        update();
    }

    @FXML
    void clickUnblock(ActionEvent event) {
        int id = tableUser.getSelectionModel().getSelectedItem().getId();

        if (tableUser.getSelectionModel().getSelectedItem() != null) {
            interactionsWithServer.unblockUsers(id);
        } else {
            HelpersCl.bug("Вы не выбрали пользователя.");
        }

        update();
    }
}
