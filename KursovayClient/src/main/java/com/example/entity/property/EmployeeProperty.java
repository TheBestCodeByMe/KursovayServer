package com.example.entity.property;

import com.example.entity.Employee;
import com.example.entity.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeProperty {
    private IntegerProperty id;
    private IntegerProperty idCompany;
    private StringProperty name;
    private StringProperty lastName;
    private StringProperty patronymic;

    public EmployeeProperty(Employee employee) {
        id = new SimpleIntegerProperty(employee.getId());
        idCompany = new SimpleIntegerProperty(employee.getIdCompany());
        name = new SimpleStringProperty(employee.getName());
        lastName = new SimpleStringProperty(employee.getLastName());
        patronymic = new SimpleStringProperty(employee.getPatronymic());
    }

    public Employee toEmployee() {
        return new Employee(id.intValue(),
                idCompany.intValue(),
                name.getValue(),
                lastName.getValue(),
                patronymic.getValue());
    }

    public int getIdCompany() {
        return idCompany.get();
    }

    public IntegerProperty idCompanyProperty() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany.set(idCompany);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public StringProperty patronymicProperty() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic.set(patronymic);
    }
}
