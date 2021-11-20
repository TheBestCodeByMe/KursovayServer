package com.example.entity.property;

import com.example.entity.Salaries;
import com.example.entity.Users;
import javafx.beans.property.*;

public class SalariesProperty {
    private IntegerProperty id;
    private IntegerProperty employeeid;
    private DoubleProperty december;
    private DoubleProperty january;
    private DoubleProperty february;
    private DoubleProperty march;
    private DoubleProperty april;
    private DoubleProperty may;
    private DoubleProperty june;
    private DoubleProperty july;
    private DoubleProperty august;
    private DoubleProperty september;
    private DoubleProperty october;
    private DoubleProperty november;

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

    public int getEmployeeid() {
        return employeeid.get();
    }

    public IntegerProperty employeeidProperty() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid.set(employeeid);
    }

    public double getDecember() {
        return december.get();
    }

    public DoubleProperty decemberProperty() {
        return december;
    }

    public void setDecember(double december) {
        this.december.set(december);
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

    public double getFebruary() {
        return february.get();
    }

    public DoubleProperty februaryProperty() {
        return february;
    }

    public void setFebruary(double february) {
        this.february.set(february);
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

    public double getApril() {
        return april.get();
    }

    public DoubleProperty aprilProperty() {
        return april;
    }

    public void setApril(double april) {
        this.april.set(april);
    }

    public double getMay() {
        return may.get();
    }

    public DoubleProperty mayProperty() {
        return may;
    }

    public void setMay(double may) {
        this.may.set(may);
    }

    public double getJune() {
        return june.get();
    }

    public DoubleProperty juneProperty() {
        return june;
    }

    public void setJune(double june) {
        this.june.set(june);
    }

    public double getJuly() {
        return july.get();
    }

    public DoubleProperty julyProperty() {
        return july;
    }

    public void setJuly(double july) {
        this.july.set(july);
    }

    public double getAugust() {
        return august.get();
    }

    public DoubleProperty augustProperty() {
        return august;
    }

    public void setAugust(double august) {
        this.august.set(august);
    }

    public double getSeptember() {
        return september.get();
    }

    public DoubleProperty septemberProperty() {
        return september;
    }

    public void setSeptember(double september) {
        this.september.set(september);
    }

    public double getOctober() {
        return october.get();
    }

    public DoubleProperty octoberProperty() {
        return october;
    }

    public void setOctober(double october) {
        this.october.set(october);
    }

    public double getNovember() {
        return november.get();
    }

    public DoubleProperty novemberProperty() {
        return november;
    }

    public void setNovember(double november) {
        this.november.set(november);
    }
}
