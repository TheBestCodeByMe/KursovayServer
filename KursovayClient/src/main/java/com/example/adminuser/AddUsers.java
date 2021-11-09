package com.example.adminuser;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.connection.ConnectionToServer;
import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Main;
import com.example.kursovayclient.Time_Based_Daily;
import com.example.kursovayclient.Time_Based_Hourly_Salary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUsers {
    InteractionsWithServer interactionsWithServer;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonRegistration;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPassword1;

    @FXML
    private Button buttonBack;

    @FXML
    void initialize() {
        interactionsWithServer = new InteractionsWithServer();
    }

    @FXML
    void clickRegistration(ActionEvent event) throws IOException, ClassNotFoundException {
        if (validateTextFields()) {
            if (txtPassword.getText().equals(txtPassword1.getText())) {
                if(!txtLogin.getText().equals("admin")) {
                    if (interactionsWithServer.registerUser(txtLogin.getText(), txtPassword.getText())) {
                        alert.setHeaderText(null);
                        alert.setContentText("Регистрация прошла успешно.");
                    } else {
                        alert.setTitle("Ошибка");
                        alert.setHeaderText(null);
                        alert.setContentText("Пользователи с таким логином уже существуют");
                    }
                    alert.showAndWait();
                    txtLogin.setText("");
                    txtPassword.setText("");
                    txtPassword1.setText("");
                } else{
                    alert.setTitle("Ошибка");
                    alert.setHeaderText(null);
                    alert.setContentText("Введённый вами логин использовать нельзя.");
                    alert.showAndWait();
                    txtLogin.setText("");
                }
            } else {
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Пароли не совпадают.");
                alert.showAndWait();
                txtPassword.setText("");
                txtPassword1.setText("");
            }
        }
    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Main main = new Main();
            main.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open main.\nWith exception " + e.getLocalizedMessage());
        }
    }

    private boolean validateTextFields() {
        return !Objects.equals(txtLogin.getText(), "") && !Objects.equals(txtPassword.getText(), "") && !Objects.equals(txtPassword1.getText(), "");
    }
}
