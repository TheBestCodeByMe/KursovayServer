package helpers;

import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Menu_Admin;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelpersCl {

    public static void backToMenuAdmin(Button buttonBack) {
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

    public static void registration(String login, String password, String repeatPassword) throws IOException, ClassNotFoundException {
        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(validateTextFields(login, password, repeatPassword)) {
            if (password.equals(repeatPassword)) {
                if (!login.equals("admin")) {
                    if (interactionsWithServer.registerUser(login, password)) {
                        alert.setHeaderText(null);
                        alert.setContentText("Регистрация прошла успешно.");
                    } else {
                        alert.setTitle("Ошибка");
                        alert.setHeaderText(null);
                        alert.setContentText("Пользователи с таким логином уже существуют");
                    }
                    alert.showAndWait();
                } else {
                    alert.setTitle("Ошибка");
                    alert.setHeaderText(null);
                    alert.setContentText("Введённый вами логин использовать нельзя.");
                    alert.showAndWait();
                }
            } else {
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Пароли не совпадают.");
                alert.showAndWait();
            }
        } else {
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Все поля должны быть заполнены!!!");
            alert.showAndWait();
        }
    }

    private static boolean validateTextFields(String login, String password, String repeatPassword) {
        return !Objects.equals(login, "") && !Objects.equals(password, "") && !Objects.equals(repeatPassword, "");
    }
}
