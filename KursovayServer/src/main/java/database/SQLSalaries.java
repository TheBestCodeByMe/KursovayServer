package database;

import entity.Salaries;

import java.util.ArrayList;

public class SQLSalaries implements ISalaries {
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
        String str = "SELECT * FROM salaries WHERE employeeid = '" + object.getEmployeeid() + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return result.size() == 0;
    }

    @Override
    public ArrayList<String[]> selectAllSalaries() {
        String str = "SELECT * FROM salaries";
        return dbConnection.getArrayResult(str);
    }

    @Override
    public void updateSalary(String month, double monthSalary, int id) {
        String str = "UPDATE salaries SET " + month + " = '" + monthSalary +
                "' WHERE employeeid = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void insert(Salaries object) {
        String str = "INSERT INTO salaries(employeeid, december, january, february, march, april, may, june, july, august, september, october, november) VALUES('" +
                object.getEmployeeid() + "', '" + object.getDecember() + "', '" +
                object.getJanuary() + "', '" + object.getFebruary() + "', '" + object.getMarch() + "', '" +
                object.getApril() + "', '" + object.getMay() + "', '" + object.getJune() + "', '" +
                object.getJuly() + "', '" + object.getAugust() + "', '" + object.getSeptember() + "', '" +
                object.getOctober() + "', '" +
                object.getNovember() + "')";
        dbConnection.execute(str);
    }
}
