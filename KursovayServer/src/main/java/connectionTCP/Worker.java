package connectionTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
                    case "все рабочие": {

                    }
                    break;
                    case "все пользователи": {

                    }
                    break;
                    case "просмотр компании": {

                    }
                    break;
                    case "просмотр описания": {

                    }
                    break;
                    case "авторизация": {

                    }
                    break;
                    case "удалить рабочего": {

                    }
                    break;
                    case "удалить пользователя": {

                    }
                    break;
                    case "добавить рабочего": {

                    }
                    break;
                    case "регистрация пользователя": {

                    }
                    break;
                    case "расчет зарплаты по комиссионной системе": {

                    }
                    break;
                    case "расчет зарплаты по комиссионной системе не менее фикс оклада": {

                    }
                    break;
                    case "расчет зарплаты по комиссионной системе по фикс окладу": {

                    }
                    break;
                    case "расчет зарплаты по прямой сдельной": {

                    }
                    break;
                    case "расчет зарплаты по косвенное сдельной": {

                    }
                    break;
                    case "расчет зарплаты по повременной дневной": {

                    }
                    break;
                    case "расчет зарплаты по повременной часовой": {

                    }
                    break;
                    case "exit": {

                    }
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
}
