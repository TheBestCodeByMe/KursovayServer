package com.example.admin;

        import java.net.URL;
        import java.util.ResourceBundle;

        import com.example.kursovayclient.Menu_Admin;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.stage.Modality;
        import javafx.stage.Stage;

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

    }

    @FXML
    void clickBack(ActionEvent event) {
        try {
            buttonBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Menu_Admin menuAdmin = new Menu_Admin();
            menuAdmin.start(stage);
        } catch (Exception e) {
            System.out.println("Cannot open admin menu.\nWith exception " + e.getLocalizedMessage());
        }
    }

    @FXML
    void clickUpdate(ActionEvent event){

    }

    @FXML
    void clickAdd(ActionEvent event){

    }
}
