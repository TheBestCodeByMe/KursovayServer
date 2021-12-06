package database;

import entity.Description;

import java.util.ArrayList;

public interface IDescription {
    boolean isFind(Description object);
    ArrayList<String[]> selectAllDescription();
    void updateHours(int hours, int id);
    void updateDays(int days, int id);
    void updateProducts(int amount, int id);
    void insert(Description object);
    double getFixedSalary(int id);
}
