package com.example.admin;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;

public class AddWorkingDay {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnFam;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPatronymic;

    @FXML
    private TableColumn<?, ?> columnDays;

    @FXML
    private Button buttonUpdate;

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert columnFam != null : "fx:id=\"columnFam\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert columnPatronymic != null : "fx:id=\"columnPatronymic\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert columnDays != null : "fx:id=\"columnDays\" was not injected: check your FXML file 'add-working-day.fxml'.";
        assert buttonUpdate != null : "fx:id=\"buttonUpdate\" was not injected: check your FXML file 'add-working-day.fxml'.";

    }
}
