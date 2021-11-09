package database;

import entity.Company;

import java.util.LinkedList;

public class SQLCompany implements ICompany{
    private static SQLCompany instance;
    private ConnectionDatabase dbConnection;

    private SQLCompany() {
        dbConnection = ConnectionDatabase.getInstance();
    }

    public static synchronized SQLCompany getInstance() {
        if (instance == null) {
            instance = new SQLCompany();
        }
        return instance;
    }

    @Override
    public boolean isFind(Company object) {
        return false;
    }

    @Override
    public LinkedList<Company> selectAllCompany() {
        return null;
    }

    @Override
    public void update(Company object, int id) {

    }

    @Override
    public void insert(Company object) {

    }

    @Override
    public void delete(int id) {

    }
}
