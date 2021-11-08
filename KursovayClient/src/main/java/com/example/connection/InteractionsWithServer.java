package com.example.connection;

import com.example.constants.Constants;
import com.example.entity.*;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class InteractionsWithServer extends Constants {
    private BufferedReader in;
    private BufferedWriter out;

    public InteractionsWithServer(Socket clientSocket) {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Employee> showAllEmployes() throws IOException {
        sendMsg("все рабочие");
        LinkedList<Employee> workers = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInContributionAll(in.readLine(), workers);
        }
        return workers;
    }

    private void parseStringInContributionAll(String employee, LinkedList<Employee> list) {
        String[] subStr;
        subStr = employee.split(" ");
        list.add(new Employee(Integer.parseInt(subStr[0]), subStr[1], subStr[2], subStr[3]));
    }

    public LinkedList<Users> showAllUsers() throws IOException {
        sendMsg("все пользователи");
        LinkedList<Users> users = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInUsersAll(in.readLine(), users);
        }
        return users;
    }

    private void parseStringInUsersAll(String user, LinkedList<Users> list) {
        String[] subStr;
        subStr = user.split(" ");
        list.add(new Users(Integer.parseInt(subStr[0]), subStr[1], subStr[2], subStr[3]));
    }

    public LinkedList<Company> showAllCompany() throws IOException {
        sendMsg("просмотр компании");
        LinkedList<Company> company = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInCompanyAll(in.readLine(), company);
        }
        return company;
    }

// сделать удаление
    public LinkedList<Company> showAllCompany() throws IOException {
        sendMsg("просмотр компании");
        LinkedList<Company> company = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInCompanyAll(in.readLine(), company);
        }
        return company;
    }
// сделать редактирование
    public LinkedList<Company> showAllCompany() throws IOException {
        sendMsg("просмотр компании");
        LinkedList<Company> company = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInCompanyAll(in.readLine(), company);
        }
        return company;
    }
// сделать добавление
    public LinkedList<Company> showAllCompany() throws IOException {
        sendMsg("просмотр компании");
        LinkedList<Company> company = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInCompanyAll(in.readLine(), company);
        }
        return company;
    }

    private void parseStringInCompanyAll(String company, LinkedList<Company> list) {
        String[] subStr;
        subStr = company.split(" ");
        list.add(new Company(Integer.parseInt(subStr[0]), subStr[1], Integer.parseInt(subStr[2])));
    }

    public LinkedList<Description> showAllDescription() throws IOException {
        sendMsg("просмотр описания");
        LinkedList<Description> description = new LinkedList<>();

        int sizeList = Integer.parseInt(in.readLine());
        for (int i = 0; i < sizeList; i++) {
            parseStringInDescriptionAll(in.readLine(), description);
        }
        return description;
    }

    private void parseStringInDescriptionAll(String worker, LinkedList<Description> list) {
        String[] subStr;
        subStr = worker.split(" ");
        // может добавить
        /*
        if (subStr[1] == null) {
            subStr[1] = "0";
        }
        if (subStr[2] == null) {
            subStr[2] = "0";
        }
        if (subStr[3] == null) {
            subStr[3] = "0";
        }
        */
        list.add(new Description(Integer.parseInt(subStr[0]), Integer.parseInt(subStr[1]), Integer.parseInt(subStr[2]), Integer.parseInt(subStr[3])));
    }

    public boolean checkAccount(String login, String password) throws IOException {
        sendMsg("авторизация");
        sendMsg(login + " " + password);
        if (in.readLine().equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteWorker(int id) {
        sendMsg("удалить рабочего");
        sendMsg(String.valueOf(id));
    }

    public void deleteUsers(int id) {
        sendMsg("удалить пользователя");
        sendMsg(String.valueOf(id));
    }

    public void addWorker(String name, String firstNameTextFieldText, String patronymicTextFieldText, String salaryTextFieldText) {
        sendMsg("добавить рабочего");
        sendMsg(name + " " + firstNameTextFieldText + " " + patronymicTextFieldText + " " + salaryTextFieldText);
    }

    public boolean registerUser(String name, String password) throws IOException {
        sendMsg("регистрация пользователя");
        sendMsg(name + " " + password);

        return in.readLine().equals("true");
    }

    public Integer calculateCommPerc(int idSelectedEmployee, Salaries month, int profitability) {
        sendMsg("расчет зарплаты по комиссионной системе");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateCommPercLeast(int idSelectedEmployee, Salaries month, int profitability) {
        sendMsg("расчет зарплаты по комиссионной системе не менее фикс оклада");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateCommPercFixes(int idSelectedEmployee, Salaries month, int profitability) {
        sendMsg("расчет зарплаты по комиссионной системе по фикс окладу");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateDirect(int idSelectedEml, int numberProductsEmpl, String month) {
        sendMsg("расчет зарплаты по прямой сдельной");
        sendMsg(idSelectedEml + " " + numberProductsEmpl + " " + month);
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateIndirectly(int idSelectedEml, int numberProductsCompany, String month) {
        sendMsg("расчет зарплаты по косвенное сдельной");
        sendMsg(idSelectedEml + " " + numberProductsCompany + " " + month);
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateTimebasedDaily(Employee selectedEmployee) {
        sendMsg("расчет зарплаты по повременной дневной");
        //sendMsg(selectedEmployee.getHoursWorkedTextField().getText() + " " + selectedEmployee.getWorkRateTextField().getText() + " " + selectedEmployee.getSalaryByContract());
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateTimebasedHourlySalary(Employee selectedEmployee) {
        sendMsg("расчет зарплаты по повременной часовой");
        //sendMsg(selectedEmployee.getHoursWorkedTextField().getText() + " " + selectedEmployee.getWorkRateTextField().getText() + " " + selectedEmployee.getSalaryByContract());
        try {
            return Integer.valueOf(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}