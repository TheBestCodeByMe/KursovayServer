package database;

import entity.Company;
import entity.Users;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public interface ICompany {
    ArrayList<String[]> selectAllCompany();
    int selectIdCompany();
    int selectNumberEmpl(int id);
    void updateNumbEmpl();
    void insert(Company object);
    void delete(int id);
    void updateNameCompany(String name, int id);
}
