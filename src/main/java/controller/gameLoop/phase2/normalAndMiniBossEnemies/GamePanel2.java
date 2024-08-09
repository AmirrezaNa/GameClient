package controller.gameLoop.phase2.normalAndMiniBossEnemies;

import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2;
import controller.gameController.GameController;
import controller.gameController.listener.KeyInputListenerOnline;
import controller.gameController.listener.MouseInputListenerOnline;

import javax.swing.*;
import java.awt.*;

public class GamePanel2 extends JPanel implements Runnable {
    KeyInputListenerOnline keyInputListener;
    MouseInputListenerOnline mouseInputListener;

    GameController gameController;

    public GamePanel2(GameController gameController) {
        this.setBounds(0, 0, offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2.width, GameFrame2.height);
        this.gameController = gameController;
        //changeGamePanelSize();
        this.setBackground(Color.BLACK);

        keyInputListener = new KeyInputListenerOnline();
        this.addKeyListener(keyInputListener);
        mouseInputListener = new MouseInputListenerOnline();
        this.addMouseListener(mouseInputListener);
        this.addMouseMotionListener(mouseInputListener);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
    }



    @Override
    public void run() {

        while (this.gameController.phase1over && !this.gameController.phase2Over) {


            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
}
