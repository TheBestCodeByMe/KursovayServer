package connectionTCP;

import com.mysql.cj.result.SqlDateValueFactory;
import database.SQLFactory;
import entity.Company;
import entity.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
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
                    case "changeNameCompany":
                        break;
                    case "deleteUser":
                        deleteUsers();
                        break;
                    case "editUser":
                        break;
                    case "showEmpl":
                        showEmployee();
                        break;
                    case "deleteAllEmployee":
                        deleteAllEmployee();
                        break;
                    case "editNameEmpl":
                        editNameEmployee();
                        break;
                    case "editLastnameEmpl":
                        editLastnameEmployee();
                        break;
                    case "editPatronymicEmpl":
                        editPatronymicEmployee();
                        break;
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
                    case "расчет зарплаты по комиссионной системе":
                        break;
                    case "расчет зарплаты по комиссионной системе не менее фикс оклада":
                        break;
                    case "расчет зарплаты по комиссионной системе по фикс окладу":
                        break;
                    case "расчет зарплаты по прямой сдельной":
                        break;
                    case "расчет зарплаты по косвенное сдельной":
                        break;
                    case "расчет зарплаты по повременной дневной":
                        break;
                    case "расчет зарплаты по повременной часовой":
                        break;
                    case "exit":
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

    public void viewCompany() throws IOException {
        System.out.println("Просмотр компании");
        SQLFactory sqlFactory = new SQLFactory();
        ArrayList<String[]> company = sqlFactory.getCompany().selectAllCompany();
        soos.writeObject(company);
    }

    public void addCompany() {
        System.out.println("Добавление компании");
        try {
            messageFromClient = sois.readObject().toString().split(" ");
            Company company = new Company(messageFromClient[0], Integer.parseInt(messageFromClient[1]));
            sqlFactory.getCompany().insert(company);
            soos.writeObject("true");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(){
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

    private void deleteEmloyee() {
    }

    private void addEmployee() {
    }

    private void editPatronymicEmployee() {
    }

    private void editLastnameEmployee() {
    }

    private void editNameEmployee() {
    }

    private void deleteAllEmployee() {
    }

    private void showEmployee() {
    }
}
