module com.example.kursovayclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kursovayclient to javafx.fxml;
    exports com.example.kursovayclient;
    exports com.example.admin;
    opens com.example.admin to javafx.fxml;
    exports com.example.user;
    opens com.example.user to javafx.fxml;
    exports com.example.adminuser;
    opens com.example.adminuser to javafx.fxml;
    exports com.example.admin.salary;
    opens com.example.admin.salary to javafx.fxml;
}