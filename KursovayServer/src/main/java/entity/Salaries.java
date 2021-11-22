package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Salaries implements Serializable {
    private int id;
    private int employeeid;
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

    public Salaries(int employeeid) {
        this.employeeid = employeeid;
    }

    public Salaries(int employeeid, double december, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november) {
        this.employeeid = employeeid;
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

    public Salaries(double december, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november) {
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

    public Salaries(int id, int employeeid, double december, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november) {
        this.id = id;
        this.employeeid = employeeid;
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

