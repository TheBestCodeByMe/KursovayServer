package database;

import com.example.entity.Salaries;

import java.util.ArrayList;

public interface ISalaries {
    boolean isFind(Salaries object);
    ArrayList<String[]> selectAllSalaries();
    void updateSalary(String month, double monthSalary, int id);
    void insert(Salaries object);
}
