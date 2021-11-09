package database;

import entity.Salaries;

import java.util.LinkedList;

public interface ISalaries {
    boolean isFind(Salaries object);
    LinkedList<Salaries> selectAllSalaries();
    void update(Salaries object, int id);
    void insert(Salaries object);
    void delete(int id);
}
