package database;

import entity.Company;

import java.util.ArrayList;

public interface ICompany {
    ArrayList<String[]> selectAllCompany();
    int selectIdCompany();
    int selectNumberEmpl(int id);
    void updateNumbEmpl();
    void insert(Company object);
    void delete(int id);
    void updateNameCompany(Company company);
    void updateDelNumbEmpl();
}
