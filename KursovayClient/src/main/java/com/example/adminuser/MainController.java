package com.example.adminuser;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.kursovayclient.Add_Users;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    InteractionsWithServer interactionsWithServer;

    @FXML
    private Button buttonRegistration;

    @FXML
    private Button buttonEnter;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException, ClassNotFoundException {
        if (!txtLogin.getText().isEmpty() &&
                !txtPassword.getText().isEmpty() &&
                txtLogin.getText().matches(Constants.REGULAR_FOR_LOGIN) &&
                txtPassword.getText().matches(Constants.REGULAR_FOR_PASSWORD)) {
            if (txtLogin.getText().equals("admin") && txtPassword.getText().equals("admin")) {
                HelpersCl.backToMenuAdmin(buttonEnter);
            } else {
                if (interactionsWithServer.checkAccount(txtLogin.getText(), txtPassword.getText())) {
                    HelpersCl.backToMenuUser(buttonEnter);
                } else {
                    HelpersCl.bug("У вас нет прав доступа. Введите другие данные.");
                }
            }
        } else {
            HelpersCl.bug("Вы не ввели данные.");
        }
    }

    @FXML
    void clickRegistration(ActionEvent event) {
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
