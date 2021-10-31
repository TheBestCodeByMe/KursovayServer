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
                switch (choice) {
                    case "enter": {

                    }
                    break;
                    case "saveSchedule": {

                    }
                    break;
                    case "createAdminMenu": {

                    }
                    break;
                    case "showSchedule": {

                    }
                    break;
                    case "editSchedule": {

                    }
                    break;
                    case "saveEdit": {

                    }
                    break;
                    case "deleteSchedule": {

                    }
                    break;
                    case "registrationUser": {

                    }
                    break;
                    case "getFlights": {

                    }
                    break;
                    case "getInfAboutPassenger": {

                    }
                    break;
                    case "orderTicket": {

                    }
                    break;
                    case "orderTicketCasher": {

                    }
                    break;
                    case "getListTicket": {

                    }
                    break;
                    case "getNumberOfTicket": {

                    }
                    break;
                    case "getInfTicketByNum": {

                    }
                    break;
                    case "returnTicket": {

                    }
                    break;
                    case "createListPassenger": {

                    }
                    break;
                    case "createListPlane": {

                    }
                    break;
                    case "addPlane": {

                    }
                    break;
                    case "deletePlane": {

                    }
                    break;
                    case "addFutureFlight": {

                    }
                    break;
                    case "grafic": {

                    }
                    break;
                    case "createFormCB": {

                    }
                    break;
                    case "createFlightScheduleMessage": {

                    }
                    break;
                    case "doText": {

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
}
