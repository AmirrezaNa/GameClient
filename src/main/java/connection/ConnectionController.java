package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionController {

    public static Socket socket;
    public static PrintWriter output;
    public static BufferedReader input;
    public static boolean connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 9000);
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            DataTransfer.socket = socket;
            DataTransfer.output = output;
            DataTransfer.input = input;

        } catch (IOException e) {
            return false;
        }
        if (socket.isConnected()) {
            ConnectionPage.connected = true;
            checkConnection();
            return true;
        }
        else {
            ConnectionPage.connected = false;
            return false;
        }

    }

    public static void checkConnection() {
        Thread connectionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (ConnectionPage.connected) {
                    try {
                        socket.sendUrgentData(0);
                        Thread.sleep(5000);
                    } catch (IOException e) {
                        ConnectionPage.connected = false;
                        break;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        connectionThread.start();

    }


}
