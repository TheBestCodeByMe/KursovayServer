package com.example.entity.property;

import com.example.entity.Salaries;
import com.example.entity.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SalariesProperty {
    private IntegerProperty id;
    private IntegerProperty december;
    private IntegerProperty january;
    private IntegerProperty february;
    private IntegerProperty march;
    private IntegerProperty april;
    private IntegerProperty may;
    private IntegerProperty june;
    private IntegerProperty july;
    private IntegerProperty august;
    private IntegerProperty september;
    private IntegerProperty october;
    private IntegerProperty november;

    public SalariesProperty(Salaries salaries) {
        id = new SimpleIntegerProperty(salaries.getId());
        december = new SimpleIntegerProperty(salaries.getDecember());
        january = new SimpleIntegerProperty(salaries.getJanuary());
        february = new SimpleIntegerProperty(salaries.getFebruary());
        march = new SimpleIntegerProperty(salaries.getMarch());
        april = new SimpleIntegerProperty(salaries.getApril());
        may = new SimpleIntegerProperty(salaries.getMay());
        june = new SimpleIntegerProperty(salaries.getJune());
        july = new SimpleIntegerProperty(salaries.getJuly());
        august = new SimpleIntegerProperty(salaries.getAugust());
        september = new SimpleIntegerProperty(salaries.getSeptember());
        october = new SimpleIntegerProperty(salaries.getOctober());
        november = new SimpleIntegerProperty(salaries.getNovember());
    }

    public Salaries toSalaries() {
        return new Salaries(id.intValue(),
                december.intValue(),
                january.intValue(),
                february.intValue(),
                march.intValue(),
                april.intValue(),
                may.intValue(),
                june.intValue(),
                july.intValue(),
                august.intValue(),
                september.intValue(),
                october.intValue(),
                november.intValue());
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

    public int getDecember() {
        return december.get();
    }

    public IntegerProperty decemberProperty() {
        return december;
    }

    public void setDecember(int december) {
        this.december.set(december);
    }

    public int getJanuary() {
        return january.get();
    }

    public IntegerProperty januaryProperty() {
        return january;
    }

    public void setJanuary(int january) {
        this.january.set(january);
    }

    public int getFebruary() {
        return february.get();
    }

    public IntegerProperty februaryProperty() {
        return february;
    }

    public void setFebruary(int february) {
        this.february.set(february);
    }

    public int getMarch() {
        return march.get();
    }

    public IntegerProperty marchProperty() {
        return march;
    }

    public void setMarch(int march) {
        this.march.set(march);
    }

    public int getApril() {
        return april.get();
    }

    public IntegerProperty aprilProperty() {
        return april;
    }

    public void setApril(int april) {
        this.april.set(april);
    }

    public int getMay() {
        return may.get();
    }

    public IntegerProperty mayProperty() {
        return may;
    }

    public void setMay(int may) {
        this.may.set(may);
    }

    public int getJune() {
        return june.get();
    }

    public IntegerProperty juneProperty() {
        return june;
    }

    public void setJune(int june) {
        this.june.set(june);
    }

    public int getJuly() {
        return july.get();
    }

    public IntegerProperty julyProperty() {
        return july;
    }

    public void setJuly(int july) {
        this.july.set(july);
    }

    public int getAugust() {
        return august.get();
    }

    public IntegerProperty augustProperty() {
        return august;
    }

    public void setAugust(int august) {
        this.august.set(august);
    }

    public int getSeptember() {
        return september.get();
    }

    public IntegerProperty septemberProperty() {
        return september;
    }

    public void setSeptember(int september) {
        this.september.set(september);
    }

    public int getOctober() {
        return october.get();
    }

    public IntegerProperty octoberProperty() {
        return october;
    }

    public void setOctober(int october) {
        this.october.set(october);
    }

    public int getNovember() {
        return november.get();
    }

    public IntegerProperty novemberProperty() {
        return november;
    }

    public void setNovember(int november) {
        this.november.set(november);
    }
}
