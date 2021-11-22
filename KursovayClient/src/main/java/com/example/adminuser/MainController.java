package com.example.adminuser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.connection.ConnectionToServer;
import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Add_Users;
import com.example.kursovayclient.Menu_User;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.kursovayclient.Menu_Admin;

public class MainController {
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonRegistration;

    @FXML
    private Button buttonEnter;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button buttonOutput;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        if (txtLogin.getText().equals("admin") && txtPassword.getText().equals("admin")) {
            HelpersCl.backToMenuAdmin(buttonEnter);
        } else {
            if (interactionsWithServer.checkAccount(txtLogin.getText(), txtPassword.getText())) {
                HelpersCl.backToMenuUser(buttonEnter);
            } else {
                HelpersCl.bug("У вас нет прав доступа. Введите другие данные.");
            }
        }
    }

    @FXML
    void clickRegistration(ActionEvent event) throws IOException {
        try {
            buttonRegistration.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Add_Users userMenu = new Add_Users();
            userMenu.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open registration.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickOutput(ActionEvent event) throws IOException {
        interactionsWithServer.exit();
    }
}
