package com.example.kursovayclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Add_Users extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-users.fxml")));
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root, 251, 260));
        stage.setResizable(false);
        stage.show();

        //new ConnectionToServer().connectToServer();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
