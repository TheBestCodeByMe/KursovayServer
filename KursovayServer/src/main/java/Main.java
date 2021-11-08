import connectionTCP.ConnectionTCP;
import constants.Constants;

public class Main {

    public static void main(String[] args) {
        ConnectionTCP server = new ConnectionTCP(Constants.PORT_WORK);
        new Thread(server).start();
    }
}

// Использовать DAO