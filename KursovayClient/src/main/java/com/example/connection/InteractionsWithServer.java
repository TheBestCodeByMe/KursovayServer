package com.example.connection;

import com.example.constants.Constants;
import com.example.entity.*;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class InteractionsWithServer extends Constants {
    // private BufferedReader in;
    // private BufferedWriter out;
    private ObjectInputStream sois;
    private ObjectOutputStream soos;
    private Socket clientSocket;

    public InteractionsWithServer() {
        try {
            clientSocket = new Socket(Constants.HOST, Constants.PORT);
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
            sois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public InteractionsWithServer(Socket clientSocket) {
        try {
           // in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           // out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            sois = new ObjectInputStream(clientSocket.getInputStream());
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    private void sendMsg(String message) {
        try {
            //out.write(message + "\n");
            //out.flush();
            soos.writeObject(message + "\n");
            soos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMSG(String message) {
        try {
            //out.write(message + "\n");
            //out.flush();
            soos.writeObject(message);
            soos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Employee> showAllEmployes() throws IOException, ClassNotFoundException {
        sendMSG("все рабочие");
        LinkedList<Employee> workers = new LinkedList<>();

        int sizeList = Integer.parseInt(sois.readObject().toString());
        for (int i = 0; i < sizeList; i++) {
            parseStringInContributionAll(sois.readObject().toString(), workers);
        }
        return workers;
    }

    private void parseStringInContributionAll(String employee, LinkedList<Employee> list) {
        String[] subStr;
        subStr = employee.split(" ");
        list.add(new Employee(Integer.parseInt(subStr[0]), subStr[1], subStr[2], subStr[3]));
    }

    public LinkedList<Users> showAllUsers() throws IOException, ClassNotFoundException {
        sendMSG("все пользователи");
        LinkedList<Users> users = new LinkedList<>();

        int sizeList = Integer.parseInt(sois.readObject().toString());
        for (int i = 0; i < sizeList; i++) {
            parseStringInUsersAll(sois.readObject().toString(), users);
        }
        return users;
    }

    private void parseStringInUsersAll(String user, LinkedList<Users> list) {
        String[] subStr;
        subStr = user.split(" ");
        list.add(new Users(Integer.parseInt(subStr[0]), subStr[1], subStr[2], subStr[3]));
    }

    public LinkedList<Company> showAllCompany() throws IOException, ClassNotFoundException {
        sendMSG("просмотр компании");
        LinkedList<Company> company = new LinkedList<>();

        int sizeList = Integer.parseInt(sois.readObject().toString());
        for (int i = 0; i < sizeList; i++) {
            parseStringInCompanyAll(sois.readObject().toString(), company);
        }
        return company;
    }

    public void deleteCompany(int id) {
        sendMSG("удаление компании");
        sendMsg(String.valueOf(id));
    }

    public void editCompany(int id, String name, int numberEmpl) throws IOException {
        sendMSG("редактирование компании");
        sendMsg(id + " " + name + " " + numberEmpl);
    }

    public void editUser(int id, String name, String firstNameTextFieldText, String patronymicTextFieldText, String salaryTextFieldText) {
        sendMSG("изменить пользователя");
        sendMsg(id + " " + name + " " + firstNameTextFieldText + " " + patronymicTextFieldText + " " + salaryTextFieldText);
    }

    public void editEmployee(int id, String name, String firstNameTextFieldText, String patronymicTextFieldText, String salaryTextFieldText) {
        sendMSG("изменить рабочего");
        sendMsg(id + " " + name + " " + firstNameTextFieldText + " " + patronymicTextFieldText + " " + salaryTextFieldText);
    }

    public void addCompany(String name, int numberEmpl) throws IOException {
        sendMSG("добавление компании");
        sendMsg(name + " " + numberEmpl);
    }

    private void parseStringInCompanyAll(String company, LinkedList<Company> list) {
        String[] subStr;
        subStr = company.split(" ");
        list.add(new Company(Integer.parseInt(subStr[0]), subStr[1], Integer.parseInt(subStr[2])));
    }

    public LinkedList<Description> showAllDescription() throws IOException, ClassNotFoundException {
        sendMSG("просмотр описания");
        LinkedList<Description> description = new LinkedList<>();

        int sizeList = Integer.parseInt(sois.readObject().toString());
        for (int i = 0; i < sizeList; i++) {
            parseStringInDescriptionAll(sois.readObject().toString(), description);
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

    public boolean checkAccount(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("авторизация");
        sendMSG(login + " " + password);
        if (sois.readObject().toString().equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteWorker(int id) {
        sendMSG("удалить рабочего");
        sendMsg(String.valueOf(id));
    }

    public void deleteUsers(int id) {
        sendMSG("удалить пользователя");
        sendMsg(String.valueOf(id));
    }

    public void addWorker(String name, String firstNameTextFieldText, String patronymicTextFieldText, String salaryTextFieldText) {
        sendMSG("добавить рабочего");
        sendMsg(name + " " + firstNameTextFieldText + " " + patronymicTextFieldText + " " + salaryTextFieldText);
    }

    public boolean registerUser(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("registerUser");
        sendMSG(login + " " + password);

        return sois.readObject().toString().equals("true");
    }

    public Integer calculateCommPerc(int idSelectedEmployee, Salaries month, int profitability) {
        sendMSG("расчет зарплаты по комиссионной системе");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateCommPercLeast(int idSelectedEmployee, Salaries month, int profitability) {
        sendMSG("расчет зарплаты по комиссионной системе не менее фикс оклада");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateCommPercFixes(int idSelectedEmployee, Salaries month, int profitability) {
        sendMSG("расчет зарплаты по комиссионной системе по фикс окладу");
        sendMsg(idSelectedEmployee + " " + month + " " + profitability);
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateDirect(int idSelectedEml, int numberProductsEmpl, String month) {
        sendMSG("расчет зарплаты по прямой сдельной");
        sendMsg(idSelectedEml + " " + numberProductsEmpl + " " + month);
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateIndirectly(int idSelectedEml, int numberProductsCompany, String month) {
        sendMSG("расчет зарплаты по косвенное сдельной");
        sendMsg(idSelectedEml + " " + numberProductsCompany + " " + month);
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateTimebasedDaily(Employee selectedEmployee) {
        sendMSG("расчет зарплаты по повременной дневной");
        //sendMsg(selectedEmployee.getHoursWorkedTextField().getText() + " " + selectedEmployee.getWorkRateTextField().getText() + " " + selectedEmployee.getSalaryByContract());
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer calculateTimebasedHourlySalary(Employee selectedEmployee) {
        sendMSG("расчет зарплаты по повременной часовой");
        //sendMsg(selectedEmployee.getHoursWorkedTextField().getText() + " " + selectedEmployee.getWorkRateTextField().getText() + " " + selectedEmployee.getSalaryByContract());
        try {
            return Integer.valueOf(sois.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}