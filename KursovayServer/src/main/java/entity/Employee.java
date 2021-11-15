package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Employee implements Serializable {
    private int id;
    private int companyId;
    private String name;
    private String lastName;
    private String patronymic;

    public Employee(int id, String name, String lastName, String patronymic) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Employee(String name, String lastName, String patronymic) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Employee(String name, String lastName, String patronymic, int companyId) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.companyId = companyId;
    }
}
