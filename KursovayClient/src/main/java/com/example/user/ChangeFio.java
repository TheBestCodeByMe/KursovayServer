package com.example.user;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ChangeFio {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtNewLogin;

    @FXML
    private Button buttonBack;
    InteractionsWithServer interactionsWithServer;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickBack(ActionEvent event) {
        HelpersCl.backToMenuUser(buttonBack);
    }

    @FXML
    void clickLogin(ActionEvent event) throws IOException, ClassNotFoundException {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        String newLogin = txtNewLogin.getText();

        if (HelpersCl.validateTextFields(login, password, newLogin)) {
            if (interactionsWithServer.checkAccount(login, password)) {
                if (!newLogin.equals("admin")) {
                    if (newLogin.matches(Constants.REGULAR_FOR_LOGIN)) {
                        interactionsWithServer.editUserLogin(login, newLogin, password);
                        HelpersCl.notBug("Смена логина прошла успешно.");
                        txtLogin.setText("");
                        txtNewLogin.setText("");
                        txtPassword.setText("");
                    } else {
                        HelpersCl.bug("Такой логин недопустим. Разрешённые символы:\nбуквенно-цифровой символ и знак подчёркивания.");
                    }
                } else {
                    HelpersCl.bug("Введённый вами логин использовать нельзя.");
                }
            } else {
                HelpersCl.bug("Такого пользователя не существует.");
            }
        } else {
            HelpersCl.bug("Все поля должны быть заполнены!!!");
        }
    }
}
