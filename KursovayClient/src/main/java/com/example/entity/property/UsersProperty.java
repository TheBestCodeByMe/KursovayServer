package com.example.entity.property;

import com.example.entity.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsersProperty {
    private IntegerProperty id;
    private StringProperty login;
    private StringProperty password;
    private StringProperty status;

    public UsersProperty(Users users)
    {
        id = new SimpleIntegerProperty(users.getId());
        login = new SimpleStringProperty(users.getLogin());
        password = new SimpleStringProperty(users.getPassword());
        status = new SimpleStringProperty(users.getStatus());
    }

    public Users toUsers(){
        return new Users(id.intValue(),
                login.getValue(),
                password.getValue(),
                status.getValue());
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
