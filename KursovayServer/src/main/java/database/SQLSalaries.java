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
    public void updateDecember(Salaries object, int id) {
        String str = "UPDATE salaries SET december = '" + object.getDecember() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateJanuary(Salaries object, int id) {
        String str = "UPDATE salaries SET january = '" + object.getJanuary() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateFebruary(Salaries object, int id) {
        String str = "UPDATE salaries SET february = '" + object.getFebruary() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateMarch(Salaries object, int id) {
        String str = "UPDATE salaries SET march = '" + object.getMarch() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateApril(Salaries object, int id) {
        String str = "UPDATE salaries SET april = '" + object.getApril() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateMay(Salaries object, int id) {
        String str = "UPDATE salaries SET may = '" + object.getMay() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateJune(Salaries object, int id) {
        String str = "UPDATE salaries SET june = '" + object.getJune() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateJuly(Salaries object, int id) {
        String str = "UPDATE salaries SET july = '" + object.getJuly() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateAugust(Salaries object, int id) {
        String str = "UPDATE salaries SET august = '" + object.getAugust() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateSeptember(Salaries object, int id) {
        String str = "UPDATE salaries SET september = '" + object.getSeptember() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateOctober(Salaries object, int id) {
        String str = "UPDATE salaries SET october = '" + object.getOctober() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateNovember(Salaries object, int id) {
        String str = "UPDATE salaries SET november = '" + object.getNovember() +
                "' WHERE idsal = '" + id + "'";
        dbConnection.execute(str);
    }

    @Override
    public void insert(Salaries object) {
        String str = "INSERT INTO salaries(employeeid, december, january, february, march, april, may, june, july, august, september, october, november) VALUES('" +
                object.getEmployeeid() + "', '" + object.getDecember() + "', '" +
                object.getJanuary() + "', '" + object.getFebruary() + "', '" + object.getMarch() + "', '" +
                object.getApril() + "', '" + object.getMay() + "', '" + object.getJune() + "', '" +
                object.getJuly() + "', '" + object.getAugust() + "', '" + object.getSeptember()+ "', '" +
                object.getOctober() + "', '" +
                object.getNovember() + "')";
        dbConnection.execute(str);
    }
}
