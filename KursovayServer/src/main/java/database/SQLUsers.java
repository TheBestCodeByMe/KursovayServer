package database;

import constants.Constants;
import entity.Users;

import java.util.ArrayList;
import java.util.LinkedList;

public class SQLUsers implements IUsers{
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
        String str = "SELECT * FROM users WHERE login = '"+object.getLogin()+
                "' and password = '" + object.getPassword() +"'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() != 0;
    }

    @Override
    public boolean checkUser(Users object) {
        if(isFind(object)) {
            String str = "SELECT status FROM users WHERE login = '"+object.getLogin()+
                    "' and password = '" + object.getPassword() +"'";
            ArrayList<String[]> result = dbConnection.getArrayResult(str);
            return !result.get(0)[0].equals("block");
        } else {
            return false;
        }
    }

    @Override
    public LinkedList<Users> selectAllUsers() {
        String str = "SELECT * FROM users";
        return getSelUsers(str);
    }

    @Override
    public boolean selectLoginUsers(String login) {
        String str = "SELECT * FROM users WHERE login = '" +
                login + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() == 0;
    }

    private LinkedList<Users> getSelUsers(String str) {
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Users> listUsers = new ArrayList<>();

        for (String[] items: result){
            Users user = new Users();
            user.setId(Integer.parseInt(items[0]));
            user.setLogin(items[1]);
            user.setPassword(items[2]);
            user.setStatus(items[3]);
            listUsers.add(user);
        }
        return new LinkedList<>(listUsers);
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
    public void delete(int id) {
        String str = "DELETE FROM users WHERE iduser = '"+id+"'";
        dbConnection.execute(str);
    }

    @Override
    public void block(int id) {
        String str = "UPDATE users SET status = '" + Constants.STATUS_BLOCK +
                "' WHERE iduser = '" + id + "'";
        dbConnection.execute(str);
    }
}
