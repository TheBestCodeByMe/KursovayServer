package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Users implements Serializable {
    private int id;
    private String login;
    private String newLogin;
    private String password;
    private String status;

    public Users(int id, String login, String password, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public Users(String login, String password, String newLogin) {
        this.login = login;
        this.newLogin = newLogin;
        this.password = password;
    }

    public Users(int id, String login, String newLogin, String password, String status) {
        this.id = id;
        this.login = login;
        this.newLogin = newLogin;
        this.password = password;
        this.status = status;
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", newLogin='" + newLogin + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
