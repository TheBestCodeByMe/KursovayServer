package com.example.adminuser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Add_Users;
import com.example.kursovayclient.Menu_User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.kursovayclient.Menu_Admin;
import work_with_table_user.UsersWorks;

public class MainController {

    private UsersWorks usersWorks;
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
    private TextField txtPassword;

    @FXML
    void initialize() {

    }

    @FXML
    void clickEnter(ActionEvent event) throws IOException {

        if(txtLogin.getText().equals("admin") && txtPassword.getText().equals("admin")) {
            try {
                buttonEnter.getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                Menu_Admin adminMenu = new Menu_Admin();
                adminMenu.start(stage);
            } catch (Exception e) {
                System.out.println("Cannot open admin menu.\nWith exception" + e.getLocalizedMessage());
            }
        } else {
            if(usersWorks.exists(txtLogin.getText(), txtPassword.getText())) { //СДЕЛАТЬ, поменять пусть к функции
                try {
                    buttonEnter.getScene().getWindow().hide();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    Menu_User userMenu = new Menu_User();
                    userMenu.start(stage);
                } catch (Exception e) {
                    System.out.println("Cannot open user menu.\nWith exception" + e.getLocalizedMessage());
                }
            } else
            {
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Введён неверный логин или пароль.");
                alert.showAndWait();
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
}
