package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Salaries implements Serializable {
    private int id;
    private int december;
    private int january;
    private int february;
    private int march;
    private int april;
    private int may;
    private int june;
    private int july;
    private int august;
    private int september;
    private int october;
    private int november;

    public Salaries(int id, int december, int january, int february, int march, int april, int may, int june, int july, int august, int september, int october, int november) {
        this.id = id;
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

    public Salaries(int december, int january, int february, int march, int april, int may, int june, int july, int august, int september, int october, int november) {
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

