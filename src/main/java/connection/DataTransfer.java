package connection;

import controller.gameController.GameController;
import model.ClientModel;
import controller.gameLoop.phase1.GameFrame;

import java.io.*;
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
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        while (!client.gameController.gameOver) {
            out.writeObject(client.inputs);
            out.reset();
            out.flush();
            client.inputs.mousePoint.x = 0;
            client.inputs.mousePoint.y = 0;

            try {
                client.gameController = (GameController) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
