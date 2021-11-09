package database;

import entity.Company;

import java.util.LinkedList;

public interface ICompany {
    boolean isFind(Company object);
    LinkedList<Company> selectAllCompany();
    void update(Company object, int id);
    void insert(Company object);
    void delete(int id);
}
