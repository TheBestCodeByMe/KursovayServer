package com.example.kursovayclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage.setTitle("Клиент");
        stage.setScene(new Scene(root, 495, 292));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        // new ConnectionToServer().connectToServer();
        launch();
    }
}