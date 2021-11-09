package database;

import entity.Employee;

import java.util.LinkedList;

public interface IEmployee {
    boolean isFind(Employee object);
    LinkedList<Employee> selectAllCompany();
    void update(Employee object, int id);
    void insert(Employee object);
    void delete(int id);
}
