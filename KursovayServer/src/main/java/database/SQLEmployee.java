package database;

import entity.Employee;

import java.util.ArrayList;

public class SQLEmployee implements IEmployee {
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
        String str = "SELECT * FROM employes WHERE name = '" + object.getName() +
                "', lastname = '" + object.getLastName() + "', patronymic = '" +
                object.getPatronymic() + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() != 0;
    }

    @Override
    public ArrayList<String[]> selectAllEmployee() {
        String str = "SELECT * FROM employes";
        return getSelEmployee(str);
    }

    private ArrayList<String[]> getSelEmployee(String str) {
        return dbConnection.getArrayResult(str);
    }

    @Override
    public void updateName(Employee object, int id) {
        String str = "UPDATE employes SET name = '" + object.getName() +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateLastName(Employee object, int id) {
        String str = "UPDATE employes SET lastname = '" + object.getLastName() +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updatePatronymic(Employee object, int id) {
        String str = "UPDATE employes SET patronymic = '" + object.getPatronymic() +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void insert(Employee object) {
        String str = "INSERT INTO employes(name, lastname, patronymic) VALUES('" +
                object.getName() + "', '" +
                object.getLastName() + "', '" +
                object.getPatronymic() + "')";
        dbConnection.execute(str);
    }

    @Override
    public void delete(int id) {
        String str = "DELETE FROM employes WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void deleteAllEmployee() {
        String str = "DELETE * FROM employes"; // скорее всего неправильно
        dbConnection.execute(str);
    }
}
