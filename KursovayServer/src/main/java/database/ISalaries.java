package database;

import entity.Description;
import entity.Salaries;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ISalaries {
    boolean isFind(Salaries object);
    ArrayList<String[]> selectAllSalaries();
    void updateDecember(Salaries object, int id);
    void updateJanuary(Salaries object, int id);
    void updateFebruary(Salaries object, int id);
    void updateMarch(Salaries object, int id);
    void updateApril(Salaries object, int id);
    void updateMay(Salaries object, int id);
    void updateJune(Salaries object, int id);
    void updateJuly(Salaries object, int id);
    void updateAugust(Salaries object, int id);
    void updateSeptember(Salaries object, int id);
    void updateOctober(Salaries object, int id);
    void updateNovember(Salaries object, int id);
    void insert(Salaries object);
}
