package database;

import entity.Employee;

import java.util.LinkedList;

public class SQLEmployee implements IEmployee{
    private static SQLEmployee instance;
    private ConnectionDatabase dbConnection;

    private SQLEmployee() {
        dbConnection = ConnectionDatabase.getInstance();
    }

    public static synchronized SQLEmployee getInstance() {
        if (instance == null) {
            instance = new SQLEmployee();
        }
        return instance;
    }

    @Override
    public boolean isFind(Employee object) {
        return false;
    }

    @Override
    public LinkedList<Employee> selectAllCompany() {
        return null;
    }

    @Override
    public void update(Employee object, int id) {

    }

    @Override
    public void insert(Employee object) {

    }

    @Override
    public void delete(int id) {

    }
}
