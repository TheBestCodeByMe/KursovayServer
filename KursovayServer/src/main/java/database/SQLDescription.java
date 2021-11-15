package database;

import entity.Description;

import java.util.ArrayList;

public class SQLDescription implements IDescription {
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
        String str = "SELECT * FROM description WHERE employeeid = '" + object.getEmployeeid() + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() == 0;
    }

    @Override
    public ArrayList<String[]> selectAllDescription() {
        String str = "SELECT * FROM description";
        return dbConnection.getArrayResult(str);
    }

    @Override
    public void updateHours(int hours, int id) {
        String str = "UPDATE description SET hours = '" +hours +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateDays(int days, int id) {
        String str = "UPDATE description SET days = '" + days +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateProducts(int amount, int id) {
        String str = "UPDATE description SET numbOfProd = '" + amount +
                "' WHERE idempl = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void insert(Description object) {
        String str = "INSERT INTO description(employeeid, hours, days, numbOfProd) VALUES('" +
                object.getEmployeeid() + "', '" + object.getHours() + "', '" +
                object.getDays() + "', '" +
                object.getNumbOfProd() + "')";
        dbConnection.execute(str);
    }
}
