package com.example.entity.property;

import com.example.entity.Description;
import com.example.entity.Users;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DescriptionProperty {
    private IntegerProperty id;
    private IntegerProperty hours;
    private IntegerProperty days;
    private IntegerProperty numbOfProd;

    public DescriptionProperty(Description description)
    {
        id = new SimpleIntegerProperty(description.getId());
        hours = new SimpleIntegerProperty(description.getHours());
        days = new SimpleIntegerProperty(description.getDays());
        numbOfProd = new SimpleIntegerProperty(description.getNumbOfProd());
    }

    public Description toDescription(){
        return new Description(id.intValue(),
                hours.intValue(),
                days.intValue(),
                numbOfProd.intValue());
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
}
