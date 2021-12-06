package com.example.constants;

public class Constants {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8080;
    public static boolean FLAG_TRANSITION;
    public static final String REGULAR_FOR_SALARY = "([0-9]{1,10})?(\\.)?([0-9]{0,2})?";
    public static final String REGULAR_FOR_INTEGER = "([1-9][0-9]*)?";
    public static final String REGULAR_FOR_LOGIN = "(\\w){0,20}";
    public static final String REGULAR_FOR_PASSWORD = "(\\w){0,20}";
    public static final String REGULAR_FOR_COMPANY = "(.){1,20}";
    public static final String REGULAR_FOR_EMPLOYEE = "([a-zA-Zа-яёА-ЯЁ]){1,20}";
}
