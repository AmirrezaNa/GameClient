package controller.gameLoop.phase2.BossFight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinalBossFrame extends JFrame {
    FinalBossPanel gamePanel;
    JButton storeButton;

    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Dimension screenSize = toolkit.getScreenSize();
    public static int x = 0;
    public static int y = 0;
    public static int width = screenSize.width;
    public static int height = screenSize.height;

    public FinalBossFrame() {
        this.setBounds(x, y, width, height);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen
        this.setUndecorated(true); // Remove window decorations
        this.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
        this.setOpacity(0.7f); // Set the opacity level (0.0f - 1.0f)
        this.setState(JFrame.NORMAL);


        gamePanel = new FinalBossPanel();
        Thread thread = new Thread(gamePanel);
        thread.start();




        this.add(storeButton);
        this.add(gamePanel);
        this.setVisible(true);
    }
}
