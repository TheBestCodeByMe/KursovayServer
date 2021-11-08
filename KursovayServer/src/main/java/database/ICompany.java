package database;

import entity.Company;

import java.util.LinkedList;

public interface ICompany {
    // переделать
    void selectCompany(Company object);
    void deleteId(int id);
    boolean isFind(Company object, int id);
    void insert(Company object);
    LinkedList<Company> select();
}
