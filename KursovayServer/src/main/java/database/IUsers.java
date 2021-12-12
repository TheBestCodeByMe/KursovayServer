package database;

import com.example.entity.Users;

import java.util.ArrayList;

public interface IUsers {
    boolean checkUser(Users object);
    boolean isFind(Users object);
    ArrayList<String[]> selectAllUsersV();
    boolean selectLoginUsers(String login);
    void insert(Users object);
    void delete(int id);
    void block(int id);
    void unblock(int id);
    void editLogin(Users object);
    int selectIdUser(Users object);
    void editPassword(Users user);
}
