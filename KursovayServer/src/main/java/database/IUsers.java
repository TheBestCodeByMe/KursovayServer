package database;

import entity.Users;

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
    void editLogin(Users object, String newLogin);
    void editPassword(Users object, String newPassword);
    int selectIdUser(Users object);
}
