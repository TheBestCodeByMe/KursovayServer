package database;

import constants.Constants;
import entity.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class SQLUsers implements IUsers {
    private static SQLUsers instance;
    private ConnectionDatabase dbConnection;

    private SQLUsers() {
        dbConnection = ConnectionDatabase.getInstance();
    }

    public static synchronized SQLUsers getInstance() {
        if (instance == null) {
            instance = new SQLUsers();
        }
        return instance;
    }

    @Override
    public boolean isFind(Users object) {
        String str = "SELECT * FROM users WHERE login = '" + object.getLogin() +
                "' and password = '" + object.getPassword() + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() != 0;
    }

    @Override
    public boolean checkUser(Users object) {
        if (isFind(object)) {
            String str = "SELECT status FROM users WHERE login = '" + object.getLogin() +
                    "' and password = '" + object.getPassword() + "'";
            ArrayList<String[]> result = dbConnection.getArrayResult(str);
            return !result.get(0)[0].equals("block");
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<String[]> selectAllUsersV() {
        String str = "SELECT * FROM users";
        return getSelUsersV(str);
    }

    @Override
    public boolean selectLoginUsers(String login) {
        String str = "SELECT * FROM users WHERE login = '" +
                login + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() == 0;
    }

    private ArrayList<String[]> getSelUsersV(String str) {
        return dbConnection.getArrayResult(str);
    }

    @Override
    public void insert(Users object) {
        String str = "INSERT INTO users(login, password, status) VALUES('" +
                object.getLogin() + "', '" +
                object.getPassword() + "', '" +
                Constants.STATUS_UNBLOCK + "')";
        dbConnection.execute(str);
    }

    @Override
    public void editLogin(Users object, String newLogin) {
        String str = "UPDATE users SET login = '" + newLogin +
                "' WHERE iduser = '" + selectIdUser(object) + "'";
        dbConnection.execute(str);
    }

    @Override
    public void editPassword(Users object, String newPassword) {
        String str = "UPDATE users SET password = '" + newPassword +
                "' WHERE iduser = '" + selectIdUser(object) + "'";
        dbConnection.execute(str);
    }

    @Override
    public int selectIdUser(Users object) {
        String str = "SELECT iduser FROM users WHERE login = '" +
                object.getLogin() + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return Integer.parseInt(Arrays.toString(result.get(0)));
    }

    @Override
    public void delete(int id) {
        String str = "DELETE FROM users WHERE iduser = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void block(int id) {
        String str = "UPDATE users SET status = '" + Constants.STATUS_BLOCK +
                "' WHERE iduser = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void unblock(int id) {
        String str = "UPDATE users SET status = '" + Constants.STATUS_UNBLOCK +
                "' WHERE iduser = '" + id + "'";
        dbConnection.execute(str);
    }
}
