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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty loginProperty() {
        return login;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty statusProperty() {
        return status;
    }
}
