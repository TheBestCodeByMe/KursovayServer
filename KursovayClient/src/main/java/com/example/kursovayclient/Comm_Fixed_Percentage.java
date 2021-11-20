package com.example.kursovayclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Comm_Fixed_Percentage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commission-system-percentage-fixed-salary.fxml")));
        stage.setTitle("Комиссионная система расчёта по проценту от выручки с фиксированным окладом");
        stage.setScene(new Scene(root, 975, 385));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
