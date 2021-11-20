package com.example.connection;

import com.example.constants.Constants;
import com.example.entity.*;
import helpers.HelpersCl;
import javafx.scene.control.Alert;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class InteractionsWithServer extends Constants {
    private ObjectInputStream sois;
    private ObjectOutputStream soos;
    private Socket clientSocket;
    ArrayList<String[]> result;

    public InteractionsWithServer() {
        try {
            clientSocket = new Socket(Constants.HOST, Constants.PORT);
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
            sois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject() {
        Object object = new Object();
        try {
            object = sois.readObject();
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
        }
        return object;
    }

    private void sendMSG(String message) {
        try {
            soos.writeObject(message);
            soos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> showAllEmployes() {
        sendMSG("showEmpl");
        result = (ArrayList<String[]>) readObject();

        ArrayList<Employee> listWorkers = new ArrayList<>();

        for (String[] items : result) {
            Employee employee = new Employee(Integer.parseInt(items[0]), items[2], items[3], items[4]);
            listWorkers.add(employee);
        }

        return listWorkers;
    }

    public ArrayList<Users> showAllUsers() {
        sendMSG("showUsers");

        result = (ArrayList<String[]>) readObject();

        ArrayList<Users> listUsers = new ArrayList<>();

        for (String[] items : result) {
            Users user = new Users(Integer.parseInt(items[0]), items[1], items[2], items[3]);
            listUsers.add(user);
        }

        return listUsers;
    }

    public ArrayList<Company> showAllCompany() {
        sendMSG("showCompany");

        result = (ArrayList<String[]>) readObject();
        ArrayList<Company> listCompany = new ArrayList<>();

        for (String[] items : result) {
            Company company = new Company(Integer.parseInt(items[0]), items[1], Integer.parseInt(items[2]));
            listCompany.add(company);
        }

        return listCompany;
    }

    public void addCompany(String name, int numberEmpl) {
        if (showAllCompany().size() == 0) {
            sendMSG("addCompany");
            sendMSG(name + " " + numberEmpl);
        } else {
            HelpersCl.bug("Компания уже существует. Удалите предыдущую для создания новой.");
        }
    }

    public void changeNameCompany(String name, int id) {
        sendMSG("changeNameCompany");
        sendMSG(name + " " + id);
    }

    public void changeHours(int hours, int id) {
        sendMSG("updateHours");
        sendMSG(hours + " " + id);
    }

    public void changeDays(String days, int id) {
        sendMSG("updateDays");
        sendMSG(days + " " + id);
    }

    public void changeNumbProduct(String amount, int id) {
        sendMSG("updateNumbProduct");
        sendMSG(amount + " " + id);
    }

    public void deleteCompany(int id) {
        sendMSG("deleteCompany");
        sendMSG(String.valueOf(id));
        sendMSG("deleteAllEmployee");
    }

    public void updateCompany() {
        sendMSG("updateCompany");
    }

    public void updateDelCompany() {
        sendMSG("updateDelCompany");
    }

    public void editUserLogin(String login, String newLogin, String password) {
        sendMSG("editUserLogin");
        sendMSG(login + " " + password + " " + newLogin);
    }

    public void editUserPassword(String login, String newPassword, String password) {
        sendMSG("editUserPassword");
        sendMSG(login + " " + password + " " + newPassword);
    }

    public void exit() {
        sendMSG("exit");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(readObject().toString());
        alert.showAndWait();
    }

    public ArrayList<Description> showAllDescription() {
        sendMSG("showDescription");

        result = (ArrayList<String[]>) readObject();
        ArrayList<Description> listDesc = new ArrayList<>();

        for (String[] items : result) {
            Description description = new Description(Integer.parseInt(items[0]), Integer.parseInt(items[2]), Integer.parseInt(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[1]));
            listDesc.add(description);
        }
        return listDesc;
    }

    public boolean checkAccount(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("authorization");
        sendMSG(login + " " + password);
        return sois.readObject().toString().equals("true");
    }

    public void deleteWorker(int id) {
        sendMSG("deleteEmpl");
        sendMSG(String.valueOf(id));
    }

    public void deleteUsers(int id) {
        sendMSG("deleteUser");
        sendMSG(String.valueOf(id));
    }

    public void blockUsers(int id) {
        sendMSG("blockUser");
        sendMSG(String.valueOf(id));
    }

    public void unblockUsers(int id) {
        sendMSG("unblockUser");
        sendMSG(String.valueOf(id));
    }

    public String addWorker(String name, String firstNameTextFieldText, String patronymicTextFieldText) throws IOException, ClassNotFoundException {
        sendMSG("addEmpl");
        sendMSG(name + " " + firstNameTextFieldText + " " + patronymicTextFieldText);
        return sois.readObject().toString();
    }

    public void addDescription(String days, String hours, String products, String name, String firstNameTextFieldText, String patronymicTextFieldText) throws IOException, ClassNotFoundException {
        sendMSG("addDescription");
        sendMSG(hours + " " + days + " " + products + " " + name + " " + firstNameTextFieldText + " " + patronymicTextFieldText);
    }

    public boolean registerUser(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("registerUser");
        sendMSG(login + " " + password);

        return sois.readObject().toString().equals("true");
    }

    public void addSalaries(String name, String lastname, String patronymic) {
        sendMSG("addNullSalaries");
        sendMSG(name + " " + lastname + " " + patronymic);
    }

    public ArrayList<Salaries> viewSalaries() {
        sendMSG("viewSalaries");
        result = (ArrayList<String[]>) readObject();
        ArrayList<Salaries> listSalary = new ArrayList<>();

        for (String[] items : result) {
            Salaries salary = new Salaries(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Double.parseDouble(items[2]), Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5]), Double.parseDouble(items[6]), Double.parseDouble(items[7]), Double.parseDouble(items[8]), Double.parseDouble(items[9]), Double.parseDouble(items[10]), Double.parseDouble(items[11]), Double.parseDouble(items[12]), Double.parseDouble(items[13]));
            listSalary.add(salary);
        }
        return listSalary;
    }

    public void calculateCommPerc(int idSelectedEmployee, String month, double profitability) {
        sendMSG("расчет зарплаты по комиссионной системе");
        sendMSG(idSelectedEmployee + " " + month + " " + profitability);
    }

    public void calculateCommPercLeast(int idSelectedEmployee, String month, double profitability) {
        sendMSG("расчет зарплаты по комиссионной системе не менее фикс оклада");
        sendMSG(idSelectedEmployee + " " + month + " " + profitability);
    }

    public void calculateCommPercFixes(int idSelectedEmployee, String month, double profitability) {
        sendMSG("расчет зарплаты по комиссионной системе по фикс окладу");
        sendMSG(idSelectedEmployee + " " + month + " " + profitability);
    }

    public void calculateDirect(int idSelectedEml, int numberProductsEmpl, String month) {
        sendMSG("расчет зарплаты по прямой сдельной");
        sendMSG(idSelectedEml + " " + month + " " + numberProductsEmpl);
    }

    public void calculateIndirectly(int idSelectedEml, int numberProductsCompany, String month) {
        sendMSG("расчет зарплаты по косвенной сдельной");
        sendMSG(idSelectedEml + " " + numberProductsCompany + " " + month);
    }

    public void calculateTimebasedDaily(int idSelectedEml, int days, String month) {
        sendMSG("расчет зарплаты по повременной дневной");
        sendMSG(idSelectedEml + " " + month + " " + days);
    }

    public void calculateTimebasedHourlySalary(int idSelectedEml, int hours, String month) {
        sendMSG("расчет зарплаты по повременной часовой");
        sendMSG(idSelectedEml + " " + month + " " + hours);
    }
}