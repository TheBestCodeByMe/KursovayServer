package database;

import entity.Users;

import java.util.LinkedList;

public interface IUsers {
    boolean checkUser(Users object);
    void insert(Users object);
    LinkedList<Users> selectUsers(Users object);
    LinkedList<Users> selectIdUsers(Users object);
    void delete(int id);
}
