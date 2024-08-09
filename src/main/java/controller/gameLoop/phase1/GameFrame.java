package controller.gameLoop.phase1;

import controller.gameController.GameController;
import model.ClientModel;

import javax.swing.*;
import java.awt.*;

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
    }


}
