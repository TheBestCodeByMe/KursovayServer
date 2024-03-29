package connectionTCP;

import calculation_salaries.CalculationSalaries;
import com.example.entity.*;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import constants.Constants;
import database.SQLFactory;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Worker implements Runnable {
    protected Socket clientSocket;
    private ObjectInputStream sois;
    private ObjectOutputStream soos;
    private final SQLFactory sqlFactory = new SQLFactory();
    private String[] messageFromClient;
    private int id;

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
                    case "showUsers" -> viewUsers();
                    case "showDescription" -> viewDescription();
                    case "addDescription" -> addDescription();
                    case "updateHours" -> updateHours();
                    case "updateDays" -> updateDays();
                    case "updateNumbProduct" -> updateNumbProduct();
                    case "authorization" -> authorization();
                    case "showCompany" -> viewCompany();
                    case "deleteCompany" -> deleteCompany();
                    case "addCompany" -> addCompany();
                    case "updateCompany" -> updateCompany();
                    case "updateDelCompany" -> updateDelCompany();
                    case "changeNameCompany" -> updateNameCompany();
                    case "deleteUser" -> deleteUsers();
                    case "editUserLogin" -> editLogin();
                    case "editUserPassword" -> editPassword();
                    case "showEmpl" -> showEmployee();
                    case "deleteAllEmployee" -> deleteAllEmployee();
                    case "saveFile" -> saveFile();
                    case "addEmpl" -> addEmployee();
                    case "deleteEmpl" -> deleteEmloyee();
                    case "registerUser" -> registration();
                    case "blockUser" -> block();
                    case "unblockUser" -> unblock();
                    case "addNullSalaries" -> addNullSalaries();
                    case "viewSalaries" -> viewSalaries();
                    case "расчет зарплаты по комиссионной системе" -> commissionSystemPercentage();
                    case "расчет зарплаты по комиссионной системе не менее фикс оклада" -> commissionSystemPercentageLeastFixed();
                    case "расчет зарплаты по комиссионной системе по фикс окладу" -> commissionSystemPercentageFixed();
                    case "расчет зарплаты по прямой сдельной" -> systemDirectPiecework();
                    case "расчет зарплаты по косвенной сдельной" -> systemIndirectlyPiecework();
                    case "расчет зарплаты по повременной дневной" -> systemTimeBasedDaily();
                    case "расчет зарплаты по повременной часовой" -> systemTimeBasedHourly();
                    case "exit" -> {
                        soos.writeObject("OK");
                        soos.close();
                        sois.close();
                        System.out.println("Client " + clientSocket.getInetAddress().toString() + "disconnected.");
                        // System.exit(0);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client disconnected.");
        }
    }

    private void authorization() {
        System.out.println("Авторизация");
        try {
            Users user = (Users) sois.readObject();

            if (sqlFactory.getUsers().checkUser(user)) {
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
            Users users = (Users) sois.readObject();

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
        ArrayList<String[]> users = sqlFactory.getUsers().selectAllUsersV();
        ArrayList<Users> listUsers = new ArrayList<>();

        for (String[] items : users) {
            Users user = new Users(Integer.parseInt(items[0]), items[1], items[2], items[3]);
            listUsers.add(user);
        }
        soos.writeObject(listUsers);
    }

    private void block() throws IOException, ClassNotFoundException {
        System.out.println("Блокировка пользователей");
        sqlFactory.getUsers().block(Integer.parseInt(sois.readObject().toString()));
    }

    private void unblock() throws IOException, ClassNotFoundException {
        System.out.println("Разблокировка пользователей");
        sqlFactory.getUsers().unblock(Integer.parseInt(sois.readObject().toString()));
    }

    private void editPassword() throws IOException, ClassNotFoundException {
        System.out.println("Изменение пароля пользователя");
        Users user = (Users) sois.readObject();
        sqlFactory.getUsers().editPassword(user);
    }

    private void editLogin() throws IOException, ClassNotFoundException {
        System.out.println("Изменение логина пользователя");
        Users user = (Users) sois.readObject();
        sqlFactory.getUsers().editLogin(user);
    }

    private void viewCompany() throws IOException {
        System.out.println("Просмотр компании");
        ArrayList<String[]> companies = sqlFactory.getCompany().selectAllCompany();
        ArrayList<Company> listCompany = new ArrayList<>();

        for (String[] items : companies) {
            Company company = new Company(Integer.parseInt(items[0]), items[1], Integer.parseInt(items[2]));
            listCompany.add(company);
        }
        soos.writeObject(listCompany);
    }

    private void addCompany() {
        System.out.println("Добавление компании");
        try {
            Company company = (Company) sois.readObject();
            sqlFactory.getCompany().insert(company);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteCompany() {
        System.out.println("Удаление компании");
        try {
            id = Integer.parseInt(sois.readObject().toString());
            sqlFactory.getCompany().delete(id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление компании");
        sqlFactory.getCompany().updateNumbEmpl();
    }

    private void updateDelCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление компании");
        sqlFactory.getCompany().updateDelNumbEmpl();
    }

    private void updateNameCompany() throws IOException, ClassNotFoundException {
        System.out.println("Обновление названия компании");
        try {
            Company company = (Company) sois.readObject();
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
            Employee employee = (Employee) sois.readObject();

            if (sqlFactory.getCompany().selectAllCompany().size() != 0) {
                if (sqlFactory.getEmployee().isFind(employee)) {
                    sqlFactory.getEmployee().insert(employee, sqlFactory.getCompany().selectIdCompany());
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
        ArrayList<Employee> listWorkers = new ArrayList<>();

        for (String[] items : fioEmployee) {
            Employee employee = new Employee(Integer.parseInt(items[0]), items[2], items[3], items[4]);
            listWorkers.add(employee);
        }
        soos.writeObject(listWorkers);
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
            Employee employee = (Employee) sois.readObject();
            Description description = (Description) sois.readObject();

            if (sqlFactory.getDescription().isFind(description)) {
                sqlFactory.getDescription().insert(description, sqlFactory.getEmployee().selectIdEmpl(employee));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewDescription() throws IOException {
        System.out.println("Просмотр описания работников");
        ArrayList<String[]> descEmployee = sqlFactory.getDescription().selectAllDescription();
        ArrayList<Description> listDesc = new ArrayList<>();

        for (String[] items : descEmployee) {
            Description description = new Description(Integer.parseInt(items[0]), Integer.parseInt(items[2]), Integer.parseInt(items[3]), Integer.parseInt(items[4]), Double.parseDouble(items[5]), Integer.parseInt(items[1]));
            listDesc.add(description);
        }
        soos.writeObject(listDesc);
    }

    private void addNullSalaries() {
        System.out.println("Добавление зарплат");

        try {
            Employee employee = (Employee) sois.readObject();
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
                Constants.FIXED_SALARY = sqlFactory.getDescription().getFixedSalary(Integer.parseInt(messageFromClient[0]));
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
        ArrayList<Salaries> listSalary = new ArrayList<>();

        for (String[] items : salaries) {
            Salaries salary = new Salaries(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Double.parseDouble(items[2]), Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5]), Double.parseDouble(items[6]), Double.parseDouble(items[7]), Double.parseDouble(items[8]), Double.parseDouble(items[9]), Double.parseDouble(items[10]), Double.parseDouble(items[11]), Double.parseDouble(items[12]), Double.parseDouble(items[13]));
            listSalary.add(salary);
        }

        soos.writeObject(listSalary);
    }

    private void saveFile() {
        System.out.println("Сохранение данных в файл");

        try {
            Reader reader = Files.newBufferedReader(Paths.get("D:\\Универ\\5 семестр\\Курсовая по ПрогСП\\KursovayServer\\src\\main\\resources\\salaries.json"));

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

            ArrayList<String[]> salaries = sqlFactory.getSalaries().selectAllSalaries();
            ArrayList<String[]> descEmployee = sqlFactory.getDescription().selectAllDescription();
            ArrayList<String[]> fioEmployee = sqlFactory.getEmployee().selectAllEmployee();
            ArrayList<String[]> companyEmployee = sqlFactory.getCompany().selectAllCompany();
            ArrayList<All_About_Employee> list = new ArrayList<>();

            for (int i = 0; i < fioEmployee.size(); i++) {
                Salaries salary = new Salaries(Double.parseDouble(salaries.get(i)[2]), Double.parseDouble(salaries.get(i)[3]), Double.parseDouble(salaries.get(i)[4]), Double.parseDouble(salaries.get(i)[5]), Double.parseDouble(salaries.get(i)[6]), Double.parseDouble(salaries.get(i)[7]), Double.parseDouble(salaries.get(i)[8]), Double.parseDouble(salaries.get(i)[9]), Double.parseDouble(salaries.get(i)[10]), Double.parseDouble(salaries.get(i)[11]), Double.parseDouble(salaries.get(i)[12]), Double.parseDouble(salaries.get(i)[13]));
                Description description = new Description(Integer.parseInt(descEmployee.get(i)[2]), Integer.parseInt(descEmployee.get(i)[3]), Integer.parseInt(descEmployee.get(i)[4]));
                Employee employee = new Employee(fioEmployee.get(i)[2], fioEmployee.get(i)[3], fioEmployee.get(i)[4]);

                All_About_Employee all_about_employee = new All_About_Employee(companyEmployee.get(0)[1], employee.getName(), employee.getLastName(), employee.getPatronymic(), description.getHours(), description.getDays(), description.getNumbOfProd(), salary.getDecember(), salary.getJanuary(), salary.getFebruary(), salary.getMarch(), salary.getApril(), salary.getMay(), salary.getJune(), salary.getJuly(), salary.getAugust(), salary.getSeptember(), salary.getOctober(), salary.getNovember());
                list.add(all_about_employee);
            }

            objectWriter.writeValue(new File("D:\\Универ\\5 семестр\\Курсовая по ПрогСП\\KursovayServer\\src\\main\\resources\\salaries.json"), list);
            soos.writeObject("Данные записаны в файл.");
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
