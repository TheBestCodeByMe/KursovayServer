package com.example.user;

import java.io.IOException;

import com.example.connection.InteractionsWithServer;
import com.example.constants.Constants;
import com.example.helpers.HelpersCl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ChangePassword {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField txtRepeatNewPassword;

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
    void clickPassword(ActionEvent event) throws IOException, ClassNotFoundException {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        String newPassword = txtNewPassword.getText();
        String repeatPassword = txtRepeatNewPassword.getText();

        if (HelpersCl.validateTextFields(login, password, newPassword)) {
            if (newPassword.equals(repeatPassword)) {
                if (interactionsWithServer.checkAccount(txtLogin.getText(), txtPassword.getText())) {
                    if(newPassword.matches(Constants.REGULAR_FOR_PASSWORD)) {
                        interactionsWithServer.editUserPassword(login, newPassword, password);
                        HelpersCl.notBug("Смена пароля прошла успешно.");
                        txtLogin.setText("");
                        txtNewPassword.setText("");
                        txtPassword.setText("");
                        txtRepeatNewPassword.setText("");
                    } else{
                        HelpersCl.bug("Новый пароль некорректен. Разрешённые символы:\nбуквенно-цифровой символ и знак подчёркивания.");
                    }
                } else {
                    HelpersCl.bug("Данные некорректны.");
                }
            } else {
                HelpersCl.bug("Пароли не совпадают.");
            }
        } else {
            HelpersCl.bug("Все поля должны быть заполнены!!!");
        }
    }
}
