package com.example.entity.property;

import com.example.entity.Company;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CompanyProperty {
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty numberEmpl;

    public CompanyProperty(Company company) {
        id = new SimpleIntegerProperty(company.getId());
        name = new SimpleStringProperty(company.getName());
        numberEmpl = new SimpleIntegerProperty(company.getNumberEmpl());
    }

    public Company toCompany(){
        return new Company(id.intValue(),
                name.getValue(),
                numberEmpl.intValue());
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

    public int getNumberEmpl() {
        return numberEmpl.get();
    }

    public IntegerProperty numberEmplProperty() {
        return numberEmpl;
    }

    public void setNumberEmpl(int numberEmpl) {
        this.numberEmpl.set(numberEmpl);
    }
}
