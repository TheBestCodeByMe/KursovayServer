package database;

public class SQLFactory extends AbstractFactory{
    @Override
    public SQLUsers getUsers() {
        return SQLUsers.getInstance();
    }

    @Override
    public SQLCompany getCompany() {
        return SQLCompany.getInstance();
    }

    @Override
    public SQLDescription getDescription() {
        return SQLDescription.getInstance();
    }

    @Override
    public SQLEmployee getEmployee() {
        return SQLEmployee.getInstance();
    }

    @Override
    public SQLSalaries getSalaries() {
        return SQLSalaries.getInstance();
    }
}
