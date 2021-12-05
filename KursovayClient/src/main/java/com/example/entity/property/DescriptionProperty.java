package com.example.entity.property;

import com.example.entity.Description;
import com.example.entity.Users;
import javafx.beans.property.*;

public class DescriptionProperty {
    private IntegerProperty id;
    private IntegerProperty employeeid;
    private IntegerProperty hours;
    private IntegerProperty days;
    private IntegerProperty numbOfProd;
    private DoubleProperty ficsSalary;

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

    public int getEmployeeid() {
        return employeeid.get();
    }

    public IntegerProperty employeeidProperty() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid.set(employeeid);
    }

    public int getHours() {
        return hours.get();
    }

    public IntegerProperty hoursProperty() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours.set(hours);
    }

    public int getDays() {
        return days.get();
    }

    public IntegerProperty daysProperty() {
        return days;
    }

    public void setDays(int days) {
        this.days.set(days);
    }

    public int getNumbOfProd() {
        return numbOfProd.get();
    }

    public IntegerProperty numbOfProdProperty() {
        return numbOfProd;
    }

    public void setNumbOfProd(int numbOfProd) {
        this.numbOfProd.set(numbOfProd);
    }

    public double getFicsSalary() {
        return ficsSalary.get();
    }

    public DoubleProperty ficsSalaryProperty() {
        return ficsSalary;
    }

    public void setFicsSalary(double ficsSalary) {
        this.ficsSalary.set(ficsSalary);
    }
}
