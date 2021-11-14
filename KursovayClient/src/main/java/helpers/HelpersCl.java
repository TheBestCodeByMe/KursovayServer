package helpers;

import com.example.connection.InteractionsWithServer;
import com.example.kursovayclient.Menu_Admin;
import com.example.kursovayclient.Menu_User;
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

    public static void backToMenuUser(Button buttonBack) {
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

    public static void registration(String login, String password, String repeatPassword) throws IOException, ClassNotFoundException {
        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        if (validateTextFields(login, password, repeatPassword)) {
            if (password.equals(repeatPassword)) {
                if (!login.equals("admin")) {
                    if (interactionsWithServer.registerUser(login, password)) {
                        bug("Регистрация прошла успешно.");
                    } else {
                        bug("Пользователи с таким логином уже существуют.");
                    }
                } else {
                    bug("Введённый вами логин использовать нельзя.");
                }
            } else {
                bug("Пароли не совпадают.");
            }
        } else {
            bug("Все поля должны быть заполнены!!!");
        }
    }

    private static boolean validateTextFields(String login, String password, String repeatPassword) {
        return !Objects.equals(login, "") && !Objects.equals(password, "") && !Objects.equals(repeatPassword, "");
    }

    public static void bug(String str) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
}
