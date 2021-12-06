package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Company implements Serializable {
    private int id;
    private String name;
    private int numberEmpl;

    public Company(int id, String name, int numberEmpl) {
        this.id = id;
        this.name = name;
        this.numberEmpl = numberEmpl;
    }
}
