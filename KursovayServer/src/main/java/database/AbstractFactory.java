package database;

public abstract class AbstractFactory {
    public abstract SQLUsers getUsers();
    public abstract SQLCompany getCompany();
    public abstract SQLDescription getDescription();
    public abstract SQLEmployee getEmployee();
    public abstract SQLSalaries getSalaries();
}
