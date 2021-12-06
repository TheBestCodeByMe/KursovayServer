package database;

import entity.Employee;

import java.util.ArrayList;

public interface IEmployee {
    boolean isFind(Employee object);
    ArrayList<String[]> selectAllEmployee();
    int selectIdEmpl(Employee object);
    void insert(Employee object);
    void delete(int id);
    void deleteAllEmployee();
}
