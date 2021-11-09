package database;

import entity.Company;
import entity.Users;

import java.util.LinkedList;

public interface IUsers {
    boolean checkUser(Users object);
    boolean isFind(Users object);
    LinkedList<Users> selectAllUsers();
    boolean selectLoginUsers(String login);
    void insert(Users object);
    void delete(int id);
    void block(int id);
}
