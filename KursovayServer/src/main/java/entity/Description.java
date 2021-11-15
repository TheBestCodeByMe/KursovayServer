package entity;

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

    public Description(int hours, int days, int numbOfProd) {
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
    }

    public Description(int hours, int days, int numbOfProd, int employeeid) {
        this.employeeid = employeeid;
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
    }
}
