package database;

import entity.Salaries;

import java.util.LinkedList;

public class SQLSalaries implements ISalaries{
    private static SQLSalaries instance;
    private ConnectionDatabase dbConnection;

    private SQLSalaries() {
        dbConnection = ConnectionDatabase.getInstance();
    }

    public static synchronized SQLSalaries getInstance() {
        if (instance == null) {
            instance = new SQLSalaries();
        }
        return instance;
    }

    @Override
    public boolean isFind(Salaries object) {
        return false;
    }

    @Override
    public LinkedList<Salaries> selectAllSalaries() {
        return null;
    }

    @Override
    public void update(Salaries object, int id) {

    }

    @Override
    public void insert(Salaries object) {

    }

    @Override
    public void delete(int id) {

    }
}
