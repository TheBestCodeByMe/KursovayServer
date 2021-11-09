package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Users;
import com.example.entity.property.UsersProperty;
import com.example.kursovayclient.Menu_Admin;
import helpers.HelpersCl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BlockUsers {
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBlock;

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

    @FXML
    private Button buttonUnblock;

    private final ObservableList<UsersProperty> usersObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        interactionsWithServer = new InteractionsWithServer();

        columnId.setCellValueFactory(cellValue -> cellValue.getValue().idProperty().asObject());
        columnLogin.setCellValueFactory(cellValue -> cellValue.getValue().loginProperty());
        columnPassword.setCellValueFactory(cellValue -> cellValue.getValue().passwordProperty());
        columnBlock.setCellValueFactory(cellValue -> cellValue.getValue().statusProperty());

        update();
    }

    public void update() throws IOException, ClassNotFoundException {
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

    // обновление в отдельный метод занести
    @FXML
    void clickBlock(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            int id = tableUser.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.blockUsers(id);
        } catch (NullPointerException e) {// если 0

        }

        update();
    }

    @FXML
    void clickUnblock(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            int id = tableUser.getSelectionModel().getSelectedItem().getId();
            interactionsWithServer.unblockUsers(id);
        } catch (NullPointerException e) {// если 0

        }

        update();
    }
}
