package connection;

import controller.gameController.GameController;
import model.ClientModel;
import controller.gameLoop.phase1.GameFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class DataTransfer {
    public static Socket socket;
    public static PrintWriter output;
    public static BufferedReader input;
//    public static ClientModel client;

    public static void createClient(ClientModel client) throws IOException, ClassNotFoundException {

        new Thread(() -> {
            client.gameFrame = new GameFrame();
            Thread renderThread = new Thread(client.gameFrame.gamePanel);
            renderThread.start();
        }).start();

        new Thread(() -> {
            try {
                getGameState(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public static void getGameState(ClientModel client) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        while (!client.gameController.gameOver) {
            client.gameController = (GameController) in.readObject();
//            System.out.println("Received game state");
//            System.out.println(client.gameController.ball.x);


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
