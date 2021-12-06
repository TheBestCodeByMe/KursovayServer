package com.example.entity.property;

import com.example.entity.Company;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class  CompanyProperty {
    private final IntegerProperty id;
    private final StringProperty name;
    private final IntegerProperty numberEmpl;

    public CompanyProperty(Company company) {
        id = new SimpleIntegerProperty(company.getId());
        name = new SimpleStringProperty(company.getName());
        numberEmpl = new SimpleIntegerProperty(company.getNumberEmpl());
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

    public IntegerProperty numberEmplProperty() {
        return numberEmpl;
    }
}
