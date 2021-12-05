package com.example.kursovayclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root, 610, 536));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        // new ConnectionToServer().connectToServer();
        launch();
    }
}