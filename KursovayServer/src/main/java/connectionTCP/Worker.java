package connectionTCP;

import database.SQLFactory;
import entity.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

// может нужно создать только 1 SQLFactory вместо инициализации в каждом методе
public class Worker implements Runnable {
    protected Socket clientSocket = null;
    ObjectInputStream sois;
    ObjectOutputStream soos;

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
                    case ("все рабочие"):
                        break;
                    case ("все пользователи"):
                        viewUsers();
                        break;
                    case ("просмотр компании"):
                        break;
                    case ("просмотр описания"):
                        break;
                    case ("авторизация"):
                        authorization();
                        break;
                    case ("удалить рабочего"):
                        break;
                    case ("удалить пользователя"):
                        deleteUsers();
                        break;
                    case "добавить рабочего":
// сделать проверку, если такой есть
                        break;
                    case "registerUser":
                        registration();
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
        SQLFactory sqlFactory = new SQLFactory();
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
        SQLFactory sqlFactory = new SQLFactory();
        String[] messageFromClient;
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
        SQLFactory sqlFactory = new SQLFactory();
        int id;
        try {
            id = Integer.parseInt(sois.readObject().toString());

            sqlFactory.getUsers().delete(id);
            soos.writeObject("Пользователь удалён.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewUsers() throws IOException {
        System.out.println("Просмотр пользователей");
        SQLFactory sqlFactory = new SQLFactory();

        LinkedList<Users> users = sqlFactory.getUsers().selectAllUsers();
        soos.writeObject(users);
    }
}
