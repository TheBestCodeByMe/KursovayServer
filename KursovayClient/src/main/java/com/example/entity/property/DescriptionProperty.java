package com.example.entity.property;

import com.example.entity.Description;
import com.example.entity.Users;
import javafx.beans.property.*;

public class DescriptionProperty {
    private final IntegerProperty id;
    private final IntegerProperty employeeid;
    private final IntegerProperty hours;
    private final IntegerProperty days;
    private final IntegerProperty numbOfProd;
    private final DoubleProperty ficsSalary;

    public DescriptionProperty(Description description)
    {
        id = new SimpleIntegerProperty(description.getId());
        employeeid = new SimpleIntegerProperty(description.getEmployeeid());
        hours = new SimpleIntegerProperty(description.getHours());
        days = new SimpleIntegerProperty(description.getDays());
        numbOfProd = new SimpleIntegerProperty(description.getNumbOfProd());
        ficsSalary = new SimpleDoubleProperty(description.getFicsSalary());
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

    public IntegerProperty hoursProperty() {
        return hours;
    }

    public IntegerProperty daysProperty() {
        return days;
    }

    public IntegerProperty numbOfProdProperty() {
        return numbOfProd;
    }

    public DoubleProperty ficsSalaryProperty() {
        return ficsSalary;
    }
}
