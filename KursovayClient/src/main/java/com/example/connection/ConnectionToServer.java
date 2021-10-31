package com.example.connection;

import com.example.constants.Constants;

import java.io.IOException;
import java.net.Socket;

public class ConnectionToServer {
    public static InteractionsWithServer interactionsWithServer;
    public void connectToServer() {
        try {
            Socket clientSocket = new Socket(Constants.HOST, Constants.PORT);
            interactionsWithServer = new InteractionsWithServer(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
