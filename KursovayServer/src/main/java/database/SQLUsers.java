package database;

import entity.Users;

import java.util.LinkedList;

public class SQLUsers implements IUsers{
    @Override
    public boolean checkUser(Users object) {
        return false;
    }

    @Override
    public void insert(Users object) {

    }

    @Override
    public LinkedList<Users> selectUsers(Users object) {
        return null;
    }

    @Override
    public LinkedList<Users> selectIdUsers(Users object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
