package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Description implements Serializable {
    private int id;
    private int employeeid;
    private int hours;
    private int days;
    private int numbOfProd;
    private double ficsSalary;

    public Description(int id, int hours, int days, int numbOfProd, double ficsSalary, int employeeid) {
        this.id = id;
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
        this.ficsSalary = ficsSalary;
        this.employeeid = employeeid;
    }

    public Description(int hours, int days, int numbOfPro) {
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
    }

    public Description(int hours, int days, int numbOfProd, double ficsSalary, int employeeid) {
        this.employeeid = employeeid;
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
        this.ficsSalary = ficsSalary;
    }

    public Description(int hours, int days, int numbOfProd, double ficsSalary) {
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
        this.ficsSalary = ficsSalary;
    }
}
