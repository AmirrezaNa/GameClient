package controller.gameLoop.phase1;

import connection.DataTransfer;
import model.ClientModel;
import model.entity.BallAngle;
import model.entity.BallModel;
import model.entity.BulletModel;
import model.entity.Collectible;
import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2;
import controller.gameController.GameController;
import controller.gameController.listener.KeyInputListenerOnline;
import controller.gameController.listener.MouseInputListenerOnline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static view.EnterNamePageOnline.client;


public class GamePanel extends JPanel implements Runnable {


    KeyInputListenerOnline keyInputListener;
    MouseInputListenerOnline mouseInputListener;


    public GamePanel() {
        this.setBounds(0, 0, GameFrame2.width, GameFrame2.height);
        //changeGamePanelSize();
        this.setBackground(new Color(0, 0, 0, 0));

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

        while (!client.gameController.phase1over) {




        }

    }




    // a method to close all windows at the start =====================================

    public static void closeAllWindows() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_WINDOWS);


            // after minimizing all windows it waits for 1 second to open the game frame
            Thread.sleep(1000);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawFrame(g);

        drawBallCerberus(g);
        drawBall(g);
        drawBallAngle(g);
        drawBallDirection(g);

        drawBullet(g);

        drawEnemy1(g);
        drawEnemy2(g);

        drawCollectible(g);

        repaint();
    }


    public void drawFrame(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
    }


    public void drawBall(Graphics g) {
        if (client.gameController.ball != null) {
            g.setColor(new Color(0x1C8F09));
            g.fillOval((int) client.gameController.ball.x - BallModel.ballRadius, (int) client.gameController.ball.y - BallModel.ballRadius,
                    2 * BallModel.ballRadius, 2 * BallModel.ballRadius);
        }
    }

    public void drawBallDirection(Graphics g) {
        if (client.gameController.ballDirection != null) {
            g.setColor(new Color(0x132F46));
            g.fillOval((int) (client.gameController.ballDirection.x - 5), (int) (client.gameController.ballDirection.y - 5), 10, 10);
        }
    }

    public void drawBallAngle(Graphics g) {
        if (client.gameController.ballAngle != null) {
            if (client.gameController.ballAngle.angleExists) {
                g.setColor(new Color(0xE5E5E5));
                g.fillOval((int) (client.gameController.ballAngle.x - BallAngle.ballAngleRadius),
                        (int) (client.gameController.ballAngle.y - BallAngle.ballAngleRadius),
                        2 * BallAngle.ballAngleRadius,
                        2 * BallAngle.ballAngleRadius);
            }
        }
    }

    public void drawBallCerberus(Graphics g) {
        if (client.gameController.ball != null) {
            if (client.gameController.ball.ballCerberus) {
                g.setColor(new Color(0x132F46));
                g.fillOval((int) client.gameController.ball.x - BallModel.ballRadius, (int) client.gameController.ball.y - (2* BallModel.ballRadius),
                        BallModel.ballRadius, BallModel.ballRadius);
                g.fillOval((int) client.gameController.ball.x + (BallModel.ballRadius), (int) client.gameController.ball.y - (BallModel.ballRadius),
                        BallModel.ballRadius, BallModel.ballRadius);
                g.fillOval((int) client.gameController.ball.x - BallModel.ballRadius, (int) client.gameController.ball.y + (BallModel.ballRadius),
                        BallModel.ballRadius, BallModel.ballRadius);
            }
        }
    }

    public void drawBullet(Graphics g) {
        if (!client.gameController.bullets.isEmpty()) {
            for (int i = 0; i < client.gameController.bullets.size(); i++) {
                if (client.gameController.bullets.get(i).bulletHealth > 0) {
                    g.setColor(new Color(0xEF8506));
                    g.fillOval((int) client.gameController.bullets.get(i).x,
                            (int) client.gameController.bullets.get(i).y,
                            BulletModel.bulletSize,
                            BulletModel.bulletSize);
                }
            }
        }
    }

    public void drawEnemy1(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (!client.gameController.enemies1.isEmpty()) {
            for (int i = 0; i < client.gameController.enemies1.size(); i++) {
                if (client.gameController.enemies1.get(i).enemyHealth > 0) {
                    Polygon polygon = new Polygon(
                            new int[]{(int) client.gameController.enemies1.get(i).xAngles[0],
                                    (int) client.gameController.enemies1.get(i).xAngles[1],
                                    (int) client.gameController.enemies1.get(i).xAngles[2],
                                    (int) client.gameController.enemies1.get(i).xAngles[3]},
                            new int[]{(int) client.gameController.enemies1.get(i).yAngles[0],
                                    (int) client.gameController.enemies1.get(i).yAngles[1],
                                    (int) client.gameController.enemies1.get(i).yAngles[2],
                                    (int) client.gameController.enemies1.get(i).yAngles[3]},
                            4);
                    g2d.setColor(new Color(0xD71111));
                    g2d.setStroke(new BasicStroke(2));
                    g2d.drawPolygon(polygon);

                }
            }
        }
    }

    public void drawEnemy2(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (!client.gameController.enemies2.isEmpty()) {
            for (int i = 0; i < client.gameController.enemies2.size(); i++) {
                if (client.gameController.enemies2.get(i).enemyHealth > 0) {
                    Polygon polygon = new Polygon(
                            new int[]{(int) client.gameController.enemies2.get(i).xAngles[0],
                                    (int) client.gameController.enemies2.get(i).xAngles[1],
                                    (int) client.gameController.enemies2.get(i).xAngles[2]},
                            new int[]{(int) client.gameController.enemies2.get(i).yAngles[0],
                                    (int) client.gameController.enemies2.get(i).yAngles[1],
                                    (int) client.gameController.enemies2.get(i).yAngles[2]},
                            3);
                    g2d.setColor(new Color(0x0271D7));
                    g2d.setStroke(new BasicStroke(2));
                    g2d.drawPolygon(polygon);

                }
            }
        }
    }

    public void drawCollectible(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (!client.gameController.collectibles.isEmpty()) {
            for (int i = 0; i < client.gameController.collectibles.size(); i++) {
                if (client.gameController.collectibles.get(i).collectibleHealth > 0) {
                    g2d.setColor(new Color(0xFFCF0F));
                    g2d.fillOval((int) client.gameController.collectibles.get(i).x,
                            (int) client.gameController.collectibles.get(i).y,
                            (int) Collectible.collectibleSize,
                            (int) Collectible.collectibleSize);
                }
            }
        }
    }

}
