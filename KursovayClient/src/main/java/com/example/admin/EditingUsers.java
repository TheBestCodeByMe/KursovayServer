package com.example.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.connection.InteractionsWithServer;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EditingUsers {
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

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
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnLogin;

    @FXML
    private TableColumn<?, ?> columnPassword;

    @FXML
    private TableColumn<?, ?> columnBlock;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuAdmin(buttonBack);
    }

    @FXML
    void clickUpdate(ActionEvent event) {
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        HelpersCl.registration(txtLogin.getText(), txtPassword.getText(), txtPassword1.getText());
    }

    @FXML
    void clickDelete(ActionEvent event) {
    }
}
