package database;

import entity.Company;
import entity.Users;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface IUsers {
    boolean checkUser(Users object);
    boolean isFind(Users object);
    List<Users> selectAllUsers();
    ArrayList<String[]> selectAllUsersV();
    boolean selectLoginUsers(String login);
    void insert(Users object);
    void delete(int id);
    void block(int id);
    void unblock(int id);
}
