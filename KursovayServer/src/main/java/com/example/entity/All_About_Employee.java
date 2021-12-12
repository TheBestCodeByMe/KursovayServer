package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class All_About_Employee implements Serializable {
    private String nameCompany;
    private String name;
    private String lastName;
    private String patronymic;
    private int hours;
    private int days;
    private int numbOfProd;
    private double december;
    private double january;
    private double february;
    private double march;
    private double april;
    private double may;
    private double june;
    private double july;
    private double august;
    private double september;
    private double october;
    private double november;

    public All_About_Employee(String nameCompany, String name, String lastName, String patronymic, int hours, int days, int numbOfProd, double december, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november) {
        this.nameCompany = nameCompany;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
        this.december = december;
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october = october;
        this.november = november;
    }
}
