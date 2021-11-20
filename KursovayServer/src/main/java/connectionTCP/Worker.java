package connectionTCP;

import calculation_salaries.CalculationSalaries;
import com.mysql.cj.result.SqlDateValueFactory;
import database.SQLFactory;
import entity.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;

// может нужно создать только 1 SQLFactory вместо инициализации в каждом методе
public class Worker implements Runnable {
    protected Socket clientSocket = null;
    ObjectInputStream sois;
    ObjectOutputStream soos;
    SQLFactory sqlFactory = new SQLFactory();
    String[] messageFromClient;
    int id;

    public Worker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            sois = new ObjectInputStream(clientSocket.getInputStream());
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
            while (true) {
                String choice = sois.readObject().toString();
                System.out.println(choice);
                switch (choice) {
                    case "showUsers":
                        viewUsers();
                        break;
                    case "showDescription":
                        viewDescription();
                        break;
                    case "addDescription":
                        addDescription();
                        break;
                    case "updateHours":
                        updateHours();
                        break;
                    case "updateDays":
                        updateDays();
                        break;
                    case "updateNumbProduct":
                        updateNumbProduct();
                        break;
                    case "authorization":
                        authorization();
                        break;
                    case "showCompany":
                        viewCompany();
                        break;
                    case "deleteCompany":
                        deleteCompany();
                        break;
                    case "addCompany":
                        addCompany();
                        break;
                    case "updateCompany":
                        updateCompany();
                        break;
                    case "updateDelCompany":
                        updateDelCompany();
                        break;
                    case "changeNameCompany":
                        updateNameCompany();
                        break;
                    case "deleteUser":
                        deleteUsers();
                        break;
                    case "editUserLogin":
                        editLogin();
                        break;
                    case "editUserPassword":
                        editPassword();
                        break;
                    case "showEmpl":
                        showEmployee();
                        break;
                    case "deleteAllEmployee":
                        deleteAllEmployee();
                        break;/*
                    case "editNameEmpl":
                        editNameEmployee();
                        break;
                    case "editLastnameEmpl":
                        editLastnameEmployee();
                        break;
                    case "editPatronymicEmpl":
                        editPatronymicEmployee();
                        break;*/
                    case "addEmpl":
                        addEmployee();
                        break;
                    case "deleteEmpl":
                        deleteEmloyee();
                        break;
                    case "registerUser":
                        registration();
                        break;
                    case "blockUser":
                        block();
                        break;
                    case "unblockUser":
                        unblock();
                        break;
                    case "addNullSalaries":
                        addNullSalaries();
                        break;
                    case "viewSalaries":
                        viewSalaries();
                        break;
                    case "расчет зарплаты по комиссионной системе":
                        commissionSystemPercentage();
                        break;
                    case "расчет зарплаты по комиссионной системе не менее фикс оклада":
                        commissionSystemPercentageLeastFixed();
                        break;
                    case "расчет зарплаты по комиссионной системе по фикс окладу":
                        commissionSystemPercentageFixed();
                        break;
                    case "расчет зарплаты по прямой сдельной":
                        systemDirectPiecework();
                        break;
                    case "расчет зарплаты по косвенной сдельной":
                        systemIndirectlyPiecework();
                        break;
                    case "расчет зарплаты по повременной дневной":
                        systemTimeBasedDaily();
                        break;
                    case "расчет зарплаты по повременной часовой":
                        systemTimeBasedHourly();
                        break;
                    case "exit":
                        soos.writeObject("OK");
                        soos.close();
                        sois.close();
                        System.out.println("Client " + clientSocket.getInetAddress().toString() + "disconnected.");
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client disconnected.");
        }
    }

    public void writeObject(Object object) {
        try {
            soos.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object readObject() {
        try {
            return sois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);// не требует обработки
        }
    }

    private void authorization() {
        System.out.println("Авторизация");
        String[] messageFromClient;
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Users users = new Users(messageFromClient[0], messageFromClient[1]);

            if (sqlFactory.getUsers().checkUser(users)) {
                soos.writeObject("true");
            } else {
                soos.writeObject("У вас нет прав доступа. Введите другие данные.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void registration() throws IOException, ClassNotFoundException {
        System.out.println("Регистрация");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Users users = new Users(messageFromClient[0], messageFromClient[1]);

            if (sqlFactory.getUsers().selectLoginUsers(users.getLogin())) {
                soos.writeObject("true");
                sqlFactory.getUsers().insert(users);
            } else {
                soos.writeObject("Пользователь с таким логином уже существует.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUsers() {
        System.out.println("Удаление пользователя");
        try {
            id = Integer.parseInt(sois.readObject().toString());

            sqlFactory.getUsers().delete(id);
            // soos.writeObject("Пользователь удалён.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewUsers() throws IOException {
        System.out.println("Просмотр пользователей");
        //ArrayList<Users> users = sqlFactory.getUsers().selectAllUsers();
        ArrayList<String[]> users = sqlFactory.getUsers().selectAllUsersV();
        //soos.writeObject(users.size());
        soos.writeObject(users);
    }

    public void block() throws IOException, ClassNotFoundException {
        System.out.println("Блокировка пользователей");
        sqlFactory.getUsers().block(Integer.parseInt(sois.readObject().toString()));
    }

    public void unblock() throws IOException, ClassNotFoundException {
        System.out.println("Разблокировка пользователей");
        sqlFactory.getUsers().unblock(Integer.parseInt(sois.readObject().toString()));
    }

    private void editPassword() throws IOException, ClassNotFoundException {
        System.out.println("Изменение пароля пользователя");
        messageFromClient = sois.readObject().toString().split(" ");
        Users user = new Users(messageFromClient[0], messageFromClient[1]);
        sqlFactory.getUsers().editPassword(user, messageFromClient[2]);
    }

    private void editLogin() throws IOException, ClassNotFoundException {
        System.out.println("Изменение логина пользователя");
        messageFromClient = sois.readObject().toString().split(" ");
        Users user = new Users(messageFromClient[0], messageFromClient[1]);
        sqlFactory.getUsers().editLogin(user, messageFromClient[2]);
    }

    public void viewCompany() throws IOException {
        System.out.println("Просмотр компании");
        ArrayList<String[]> company = sqlFactory.getCompany().selectAllCompany();
        soos.writeObject(company);
    }

    public void addCompany() {
        System.out.println("Добавление компании");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Company company = new Company(messageFromClient[0], Integer.parseInt(messageFromClient[1]));
            sqlFactory.getCompany().insert(company);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany() {
        System.out.println("Удаление компании");
        try {
            id = Integer.parseInt(sois.readObject().toString());
            sqlFactory.getCompany().delete(id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление компании");
        sqlFactory.getCompany().updateNumbEmpl();
    }

    public void updateDelCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление компании");
        sqlFactory.getCompany().updateDelNumbEmpl();
    }

    public void updateNameCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление названия компании");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Company company = new Company(Integer.parseInt(messageFromClient[1]), messageFromClient[0]);

            sqlFactory.getCompany().updateNameCompany(company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmloyee() {
        System.out.println("Удаление работника");
        try {
            id = Integer.parseInt(sois.readObject().toString());
            sqlFactory.getEmployee().delete(id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee() {
        System.out.println("Добавление работника");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Employee employee = new Employee(messageFromClient[0], messageFromClient[1], messageFromClient[2], sqlFactory.getCompany().selectIdCompany());
            if (sqlFactory.getCompany().selectAllCompany().size() != 0) {
                if (sqlFactory.getEmployee().isFind(employee)) {
                    sqlFactory.getEmployee().insert(employee);
                    soos.writeObject("true");
                } else {
                    soos.writeObject("Работник с таким ФИО уже существует.");
                }
            } else {
                soos.writeObject("Компании не существует.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteAllEmployee() {
        System.out.println("Удаление всех работников");
        sqlFactory.getEmployee().deleteAllEmployee();
    }

    private void showEmployee() throws IOException {
        System.out.println("Просмотр ФИО работников");
        ArrayList<String[]> fioEmployee = sqlFactory.getEmployee().selectAllEmployee();
        soos.writeObject(fioEmployee);
    }

    private void updateNumbProduct() {
        System.out.println("Обновление количества сделанной работником продукции");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            sqlFactory.getDescription().updateProducts(Integer.parseInt(messageFromClient[0]), Integer.parseInt(messageFromClient[1]));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateDays() {
        System.out.println("Обновление количества отработанных дней");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            sqlFactory.getDescription().updateDays(Integer.parseInt(messageFromClient[0]), Integer.parseInt(messageFromClient[1]));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateHours() {
        System.out.println("Обновление количества отработанных часов");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            sqlFactory.getDescription().updateHours(Integer.parseInt(messageFromClient[0]), Integer.parseInt(messageFromClient[1]));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addDescription() {
        System.out.println("Добавление описания");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Employee employee = new Employee(messageFromClient[3], messageFromClient[4], messageFromClient[5]);
            Description description = new Description(Integer.parseInt(messageFromClient[0]), Integer.parseInt(messageFromClient[1]), Integer.parseInt(messageFromClient[2]), sqlFactory.getEmployee().selectIdEmpl(employee));
            if (sqlFactory.getDescription().isFind(description)) {
                sqlFactory.getDescription().insert(description);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewDescription() throws IOException {
        System.out.println("Просмотр описания работников");
        ArrayList<String[]> descEmployee = sqlFactory.getDescription().selectAllDescription();
        soos.writeObject(descEmployee);
    }

    private void addNullSalaries() {
        System.out.println("Добавление зарплат");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Employee employee = new Employee(messageFromClient[0], messageFromClient[1], messageFromClient[2]);
            Salaries salaries = new Salaries(sqlFactory.getEmployee().selectIdEmpl(employee), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            if (sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().insert(salaries);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void systemTimeBasedHourly() {
        System.out.println("Добавление зарплаты по повременной часовой системе");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.timeBasedHourly(Integer.parseInt(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void systemTimeBasedDaily() {
        System.out.println("Добавление зарплаты по повременной дневной системе");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.timeBasedDaily(Integer.parseInt(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void systemIndirectlyPiecework() {
        System.out.println("Добавление зарплаты по косвенной сдельной системе расчёта");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            int employeeId = Integer.parseInt(messageFromClient[0]);
            Salaries salaries = new Salaries(employeeId);
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[2], CalculationSalaries.indirectlyPiecework(Integer.parseInt(messageFromClient[1])), employeeId);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void systemDirectPiecework() {
        System.out.println("Добавление зарплаты по прямой сдельной системе расчёта");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.directPiecework(Integer.parseInt(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void commissionSystemPercentageFixed() {
        System.out.println("Добавление зарплаты по комиссионной системе по проценту по фиксированному окладу");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.commSystemPercentageFixed(Double.parseDouble(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void commissionSystemPercentageLeastFixed() {
        System.out.println("Добавление зарплаты по комиссионной системе по проценту не менее фиксированного оклада");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.commSystemPercentageLeastFixed(Double.parseDouble(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void commissionSystemPercentage() {
        System.out.println("Добавление зарплаты по комиссионной системе по проценту");

        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Salaries salaries = new Salaries(Integer.parseInt(messageFromClient[0]));
            if (!sqlFactory.getSalaries().isFind(salaries)) {
                sqlFactory.getSalaries().updateSalary(messageFromClient[1], CalculationSalaries.commSystemPercentage(Double.parseDouble(messageFromClient[2])), Integer.parseInt(messageFromClient[0]));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewSalaries() throws IOException {
        System.out.println("Просмотр зарплат работников");
        ArrayList<String[]> salaries = sqlFactory.getSalaries().selectAllSalaries();
        soos.writeObject(salaries);
    }
}
