package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Description implements Serializable {
    private int id;
    private int hours;
    private int days;
    private int numbOfProd;

    public Description(int id, int hours, int days, int numbOfProd) {
        this.id = id;
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
    }

    public Description(int hours, int days, int numbOfProd) {
        this.hours = hours;
        this.days = days;
        this.numbOfProd = numbOfProd;
    }
}
