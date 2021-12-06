package com.example.entity.property;

import com.example.entity.Employee;
import com.example.entity.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeProperty {
    private final IntegerProperty id;
    private final IntegerProperty idCompany;
    private final StringProperty name;
    private final StringProperty lastName;
    private final StringProperty patronymic;

    public EmployeeProperty(Employee employee) {
        id = new SimpleIntegerProperty(employee.getId());
        idCompany = new SimpleIntegerProperty(employee.getIdCompany());
        name = new SimpleStringProperty(employee.getName());
        lastName = new SimpleStringProperty(employee.getLastName());
        patronymic = new SimpleStringProperty(employee.getPatronymic());
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

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty patronymicProperty() {
        return patronymic;
    }
}
