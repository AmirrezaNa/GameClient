package controller.gameLoop.phase1;

import controller.gameController.GameController;
import controller.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2;
import model.ClientModel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static view.EnterNamePageOnline.client;

public class GameFrame extends JFrame {
    public int width;
    public int height;
    public int x;
    public int y;
    public GamePanel gamePanel;

    public Thread thread;
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Dimension screenSize = toolkit.getScreenSize();


    public GameFrame() {
        this.x = 0;
        this.y = 0;
        this.width = screenSize.width;
        this.height = screenSize.height;

        GamePanel.closeAllWindows();
        // after minimizing all windows setting the state to normal prevents minimizing the game frame
        this.setState(JFrame.NORMAL);
        this.gamePanel = new GamePanel();
//        gameFrameStuff = new GameFrameStuff();


        this.thread = new Thread(gamePanel);
        this.thread.start();


        this.setUndecorated(true);
//        this.setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        this.add(gamePanel);
        setBounds(x, y, width, height);
        this.setVisible(true);
        checkPhase1Over();
    }


    public static void changeFrameSize(GameFrame gameFrame) {
        int x = client.gameController.xFrame1;
        int y = client.gameController.yFrame1;
        int width = client.gameController.widthFrame1;
        int height = client.gameController.heightFrame1;
        if (gameFrame != null) {
            gameFrame.setBounds(x, y, width, height);
        }

    }

    public void checkPhase1Over() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!client.gameController.gameOver && client.gameController.phase1over) {
                    client.gameFrame.dispose();
                    client.gameFrame2 = new GameFrame2();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


}
