package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Users implements Serializable {
    private int id;
    private String login;
    private String password;
    private String status;

    public Users(int id, String login, String password, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public Users(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }
}
