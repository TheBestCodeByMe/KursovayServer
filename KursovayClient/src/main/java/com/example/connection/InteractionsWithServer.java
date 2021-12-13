package com.example.connection;

import com.example.constants.Constants;
import com.example.entity.*;
import com.example.helpers.HelpersCl;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

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

    public Object writeObject(Object object) {
        try {
            soos.writeObject(object);
        } catch (IOException e) {
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

    public ArrayList<Employee> showAllEmployes() throws IOException, ClassNotFoundException {
        sendMSG("showEmpl");
        return (ArrayList<Employee>) sois.readObject();
    }

    public ArrayList<Users> showAllUsers() throws IOException, ClassNotFoundException {
        sendMSG("showUsers");
        return (ArrayList<Users>) sois.readObject();
    }

    public ArrayList<Company> showAllCompany() throws IOException, ClassNotFoundException {
        sendMSG("showCompany");
        return (ArrayList<Company>) sois.readObject();
    }

    public void addCompany(String name, int numberEmpl) throws IOException, ClassNotFoundException {
        if (showAllCompany().size() == 0) {
            sendMSG("addCompany");
            Company company = new Company(name, numberEmpl);
            writeObject(company);
        } else {
            HelpersCl.bug("Компания уже существует. Удалите предыдущую для создания новой.");
        }
    }

    public void changeNameCompany(String name, int id) {
        sendMSG("changeNameCompany");
        Company company = new Company(id, name);
        writeObject(company);
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
        Users user = new Users(login, password, newLogin);
        writeObject(user);
    }

    public void editUserPassword(String login, String newPassword, String password) {
        sendMSG("editUserPassword");
        Users user = new Users(login, password, newPassword);
        writeObject(user);
    }

    public void exit() throws IOException {
        sendMSG("exit");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(readObject().toString());
        alert.showAndWait();
        sois.close();
        soos.close();
        clientSocket.close();
        Platform.exit();
        System.exit(0);
    }

    public ArrayList<Description> showAllDescription() throws IOException, ClassNotFoundException {
        sendMSG("showDescription");
        return (ArrayList<Description>) sois.readObject();
    }

    public boolean checkAccount(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("authorization");
        Users user = new Users(login, password);
        writeObject(user);
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
        Employee employee = new Employee(name, firstNameTextFieldText, patronymicTextFieldText);
        writeObject(employee);
        return sois.readObject().toString();
    }

    public void addDescription(String days, String hours, String ficsSalary, String products, String name, String lastname, String patronymic) {
        sendMSG("addDescription");
        Description description = new Description(Integer.parseInt(hours), Integer.parseInt(days), Integer.parseInt(products), Double.parseDouble(ficsSalary));
        Employee employee = new Employee(name, lastname, patronymic);
        writeObject(employee);
        writeObject(description);
    }

    public boolean registerUser(String login, String password) throws IOException, ClassNotFoundException {
        sendMSG("registerUser");
        Users user = new Users(login, password);
        writeObject(user);
        return sois.readObject().toString().equals("true");
    }

    public void addSalaries(String name, String lastname, String patronymic) {
        sendMSG("addNullSalaries");
        Employee employee = new Employee(name, lastname, patronymic);
        writeObject(employee);
    }

    public ArrayList<Salaries> viewSalaries() throws IOException, ClassNotFoundException {
        sendMSG("viewSalaries");
        return (ArrayList<Salaries>) sois.readObject();
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

    public String saveFile() throws IOException, ClassNotFoundException {
        sendMSG("saveFile");
        return sois.readObject().toString();
    }
}