package database;

import entity.Description;

import java.util.LinkedList;

public class SQLDescription implements IDescription{
    private static SQLDescription instance;
    private ConnectionDatabase dbConnection;

    private SQLDescription() {
        dbConnection = ConnectionDatabase.getInstance();
    }

    public static synchronized SQLDescription getInstance() {
        if (instance == null) {
            instance = new SQLDescription();
        }
        return instance;
    }

    @Override
    public boolean isFind(Description object) {
        return false;
    }

    @Override
    public LinkedList<Description> selectAllDescription() {
        return null;
    }

    @Override
    public void update(Description object, int id) {

    }

    @Override
    public void insert(Description object) {

    }

    @Override
    public void delete(int id) {

    }
}
