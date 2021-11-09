package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectionDatabase {
    private static ConnectionDatabase instance;
    private static final String url = "jdbc:mysql://localhost:3306/kurswork";
    private static final String user = "root";
    private static final String password = "root";
    private Statement statement;
    private Connection  connect;
    private ResultSet resultSet;
    ArrayList<String[]> masResult;

    public ConnectionDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("can't provide connection", e);
        }
    }

    public void setResultSet(String str) {//устанавливает модель выборки
        try {
            String select = str;
            resultSet = statement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionDatabase getInstance() {
        if (instance == null) {
            instance = new ConnectionDatabase();
        }
        return instance;
    }

    public ArrayList<String[]> getArrayResult(String str){//возвращает модель выборки в виде массива
        masResult = new ArrayList<String[]>();
        try {
            resultSet = statement.executeQuery(str);
            int count = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                String[] arrayString = new String[count];
                for (int i = 1;  i <= count; i++)
                    arrayString[i - 1] = resultSet.getString(i);

                masResult.add(arrayString);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return masResult;
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
