package database;

import entity.Employee;
import entity.Users;

import java.util.ArrayList;
import java.util.LinkedList;

public interface IEmployee {
    boolean isFind(Employee object);
    ArrayList<String[]> selectAllEmployee();
    void updateName(Employee object, int id);
    void updateLastName(Employee object, int id);
    void updatePatronymic(Employee object, int id);
    void insert(Employee object);
    void delete(int id);
    void deleteAllEmployee();
}
