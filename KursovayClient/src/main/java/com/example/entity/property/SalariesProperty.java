package com.example.entity.property;

import com.example.entity.Salaries;
import com.example.entity.Users;
import javafx.beans.property.*;

public class SalariesProperty {
    private final IntegerProperty id;
    private final IntegerProperty employeeid;
    private final DoubleProperty december;
    private final DoubleProperty january;
    private final DoubleProperty february;
    private final DoubleProperty march;
    private final DoubleProperty april;
    private final DoubleProperty may;
    private final DoubleProperty june;
    private final DoubleProperty july;
    private final DoubleProperty august;
    private final DoubleProperty september;
    private final DoubleProperty october;
    private final DoubleProperty november;

    public SalariesProperty(Salaries salaries) {
        id = new SimpleIntegerProperty(salaries.getId());
        employeeid = new SimpleIntegerProperty(salaries.getEmployeeid());
        december = new SimpleDoubleProperty(salaries.getDecember());
        january = new SimpleDoubleProperty(salaries.getJanuary());
        february = new SimpleDoubleProperty(salaries.getFebruary());
        march = new SimpleDoubleProperty(salaries.getMarch());
        april = new SimpleDoubleProperty(salaries.getApril());
        may = new SimpleDoubleProperty(salaries.getMay());
        june = new SimpleDoubleProperty(salaries.getJune());
        july = new SimpleDoubleProperty(salaries.getJuly());
        august = new SimpleDoubleProperty(salaries.getAugust());
        september = new SimpleDoubleProperty(salaries.getSeptember());
        october = new SimpleDoubleProperty(salaries.getOctober());
        november = new SimpleDoubleProperty(salaries.getNovember());
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

    public DoubleProperty decemberProperty() {
        return december;
    }

    public double getJanuary() {
        return january.get();
    }

    public DoubleProperty januaryProperty() {
        return january;
    }

    public void setJanuary(double january) {
        this.january.set(january);
    }

    public DoubleProperty februaryProperty() {
        return february;
    }

    public double getMarch() {
        return march.get();
    }

    public DoubleProperty marchProperty() {
        return march;
    }

    public void setMarch(double march) {
        this.march.set(march);
    }

    public DoubleProperty aprilProperty() {
        return april;
    }

    public DoubleProperty mayProperty() {
        return may;
    }

    public DoubleProperty juneProperty() {
        return june;
    }

    public DoubleProperty julyProperty() {
        return july;
    }

    public DoubleProperty augustProperty() {
        return august;
    }

    public DoubleProperty septemberProperty() {
        return september;
    }

    public DoubleProperty octoberProperty() {
        return october;
    }

    public DoubleProperty novemberProperty() {
        return november;
    }
}
