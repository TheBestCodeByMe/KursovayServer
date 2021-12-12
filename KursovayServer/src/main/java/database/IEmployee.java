package database;;

import com.example.entity.Employee;

import java.util.ArrayList;

public interface IEmployee {
    boolean isFind(Employee object);
    ArrayList<String[]> selectAllEmployee();
    int selectIdEmpl(Employee object);
    void insert(Employee object, int id);
    void delete(int id);
    void deleteAllEmployee();
}
