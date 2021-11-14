package database;

import entity.Company;

import java.util.ArrayList;

public class SQLCompany implements ICompany {
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
    public ArrayList<String[]> selectAllCompany() {
        String str = "SELECT * FROM company";
        return getSelCompanyV(str);
    }

    @Override
    public int selectIdCompany() {
        String str = "SELECT idcompany FROM company";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return Integer.parseInt(result.get(0)[0]);
    }

    private ArrayList<String[]> getSelCompanyV(String str) {
        return dbConnection.getArrayResult(str);
    }

    @Override
    public int selectNumberEmpl(int id) {
        String str = "SELECT idcompany FROM company WHERE idcompany = '" + id + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        return Integer.parseInt(result.get(0)[0]);
    }

    @Override
    public void updateNumbEmpl() {
        String str = "UPDATE company SET numberEmpl = '" + (selectNumberEmpl(selectIdCompany()) + 1) +
                "' WHERE idcompany = '" + selectIdCompany() + "'";
        dbConnection.execute(str);
    }

    @Override
    public void updateNameCompany(Company company) {
        String str = "UPDATE company SET name = '" + company.getName() +
                "' WHERE idcompany = '" + company.getId() + "'";
        dbConnection.execute(str);
    }

    @Override
    public void insert(Company object) {
        String str = "INSERT INTO company(name, numberEmpl) VALUES('" +
                object.getName() + "', '" +
                object.getNumberEmpl() + "')";
        dbConnection.execute(str);
    }

    @Override
    public void delete(int id) {
        String str = "DELETE FROM company WHERE idcompany = '" + id + "'";
        dbConnection.execute(str);
    }
}
