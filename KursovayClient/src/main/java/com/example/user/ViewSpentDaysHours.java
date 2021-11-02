package com.example.user;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kursovayclient.Menu_User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewSpentDaysHours {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnFam;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnOtchestvo;

    @FXML
    private TableColumn<?, ?> columnDays;

    @FXML
    private TableColumn<?, ?> columnHours;

    @FXML
    void initialize() {
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnOtchestvo != null : "fx:id=\"columnOtchestvo\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnDays != null : "fx:id=\"columnDays\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";
        assert columnHours != null : "fx:id=\"columnHours\" was not injected: check your FXML file 'view-spent-days-hours.fxml'.";

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_User menuUser = new Menu_User();
            menuUser.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open menu user.\nWith exception " + e.getLocalizedMessage());
        }
    }
}
