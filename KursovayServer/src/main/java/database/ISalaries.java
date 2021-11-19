package database;

import entity.Description;
import entity.Salaries;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ISalaries {
    boolean isFind(Salaries object);
    ArrayList<String[]> selectAllSalaries();
    void updateSalary(String month, double monthSalary, int id);
    void insert(Salaries object);
}
