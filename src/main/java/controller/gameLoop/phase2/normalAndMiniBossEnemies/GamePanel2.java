package controller.gameLoop.phase2.normalAndMiniBossEnemies;

import model.entity.BallAngle;
import model.entity.BallModel;
import model.entity.BulletModel;
import model.entity.Collectible;
import model.entity.enemy.AllEnemies;
import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2;
import controller.gameController.listener.KeyInputListenerOnline;
import controller.gameController.listener.MouseInputListenerOnline;

import javax.swing.*;
import java.awt.*;

import static view.EnterNamePageOnline.client;

public class GamePanel2 extends JPanel implements Runnable {
    KeyInputListenerOnline keyInputListener;
    MouseInputListenerOnline mouseInputListener;


    public GamePanel2() {
        this.setBounds(0, 0, offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2.width, GameFrame2.height);
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

        while (client.gameController.phase1over && !client.gameController.phase2Over) {


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
        super.paintComponent(g);

        drawFrames(g);

        drawArchmireTrace(g);
        client.gameFrame.gamePanel.drawBallCerberus(g);
        drawCollectible(g);

        drawBall(g);
        drawBallAngle(g);
        drawBallDirection(g);

        drawBullet(g);
        drawEnemyBullet(g);

        drawOmenoct(g);
        drawNecropick(g);
        drawArchmire(g);
        drawWyrm(g);
        drawBarricados1(g);
        drawBarricados2(g);
        drawBlackOrb(g);


        revalidate();
        repaint();

    }


    public static void drawCollectible(Graphics g) {
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


    public void drawFrames(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < 4; i++) {
            int x = client.gameController.createdFrames[i].x;
            int y = client.gameController.createdFrames[i].y;
            int width = client.gameController.createdFrames[i].width;
            int height = client.gameController.createdFrames[i].height;
            g.fillRect(x, y, width, height);
        }
        revalidate();
        repaint();

    }

    public void drawBall(Graphics g) {
        if (client.gameController.ball != null) {
            g.setColor(new Color(0x1C8F09));
            g.fillOval((int) client.gameController.ball.x - BallModel.ballRadius, (int) client.gameController.ball.y - BallModel.ballRadius,
                    2 * BallModel.ballRadius, 2 * BallModel.ballRadius);
        }
        revalidate();
        repaint();
    }

    public void drawBallDirection(Graphics g) {
        if (client.gameController.ballDirection != null) {
            g.setColor(new Color(0x132F46));
            g.fillOval((int) (client.gameController.ballDirection.x - 5), (int) (client.gameController.ballDirection.y - 5), 10, 10);
        }
        revalidate();
        repaint();
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
        revalidate();
        repaint();
    }

    public void drawBullet(Graphics g) {
        if (!client.gameController.bullets.isEmpty()) {
            int size;
            if (client.gameController.bullets.size() > 15) {
                size = 15;
            } else {
                size = client.gameController.bullets.size();
            }
            for (int i = 0; i < size; i++) {
                if (client.gameController.bullets.get(i).bulletHealth > 0) {
                    g.setColor(new Color(0xEF8506));
                    g.fillOval((int) client.gameController.bullets.get(i).x,
                            (int) client.gameController.bullets.get(i).y,
                            BulletModel.bulletSize,
                            BulletModel.bulletSize);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawEnemyBullet(Graphics g) {
        if (!client.gameController.enemyBullets.isEmpty()) {
            int size = Math.min(client.gameController.enemyBullets.size(), 10);
            for (int i = 0; i < size; i++) {
                if (client.gameController.enemyBullets.get(i).bulletHealth > 0) {
                    g.setColor(new Color(0x8C0101));
                    g.fillOval((int) client.gameController.enemyBullets.get(i).x,
                            (int) client.gameController.enemyBullets.get(i).y,
                            BulletModel.bulletSize,
                            BulletModel.bulletSize);
                }
            }
        }
        repaint();
        repaint();
    }


    public void drawOmenoct(Graphics g) {
        if (!client.gameController.omenoctEnemies.isEmpty()) {
            for (int i = 0; i < client.gameController.omenoctEnemies.size(); i++) {
                if (client.gameController.omenoctEnemies.get(i).enemyHealth > 0) {
                    super.paintComponent(g);
                    g.drawImage(AllEnemies.OmenoctModel.image,
                            (int) client.gameController.omenoctEnemies.get(i).x - AllEnemies.OmenoctModel.distanceToCenter,
                            (int) client.gameController.omenoctEnemies.get(i).y,
                            2 * AllEnemies.OmenoctModel.distanceToCenter,
                            2 * AllEnemies.OmenoctModel.distanceToCenter,
                            null);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawNecropick(Graphics g) {
        super.paintComponent(g);
        if (!client.gameController.necropickEnemies.isEmpty()) {
            for (int i = 0; i < client.gameController.necropickEnemies.size(); i++) {
                if (client.gameController.necropickEnemies.get(i).enemyHealth > 0 &&
                        !client.gameController.necropickEnemies.get(i).hide) {
                    g.drawImage(AllEnemies.NecropickModel.image,
                            (int) client.gameController.necropickEnemies.get(i).x,
                            (int) client.gameController.necropickEnemies.get(i).y,
                            AllEnemies.NecropickModel.necropickSize,
                            AllEnemies.NecropickModel.necropickSize,
                            null);
                } else if (client.gameController.necropickEnemies.get(i).enemyHealth > 0 &&
                        client.gameController.necropickEnemies.get(i).hide) {
                    g.setColor(new Color(0x464642));
                    g.fillOval((int) client.gameController.necropickEnemies.get(i).x,
                            (int) client.gameController.necropickEnemies.get(i).y,
                            AllEnemies.NecropickModel.necropickSize,
                            AllEnemies.NecropickModel.necropickSize);
                }

            }
        }
        repaint();
        repaint();
    }


    public void drawArchmire(Graphics g) {
        if (!client.gameController.archmireEnemies.isEmpty()) {
            for (int i = 0; i < client.gameController.archmireEnemies.size(); i++) {
                if (client.gameController.archmireEnemies.get(i).enemyHealth > 0) {
                    super.paintComponent(g);
                    g.drawImage(AllEnemies.ArchmireModel.image,
                            (int) client.gameController.archmireEnemies.get(i).x,
                            (int) client.gameController.archmireEnemies.get(i).y,
                            AllEnemies.ArchmireModel.archmireSize,
                            AllEnemies.ArchmireModel.archmireSize,
                            null);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawArchmireTrace(Graphics g) {
        int size = Math.min(30, client.gameController.archmirePoints.size());
        if (!client.gameController.archmirePoints.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (client.gameController.archmirePoints.get(i).archmirePointTimer > 0) {
                    super.paintComponent(g);
                    g.setColor(new Color(0x4B2828));
                    g.fillOval((int) client.gameController.archmirePoints.get(i).x - (AllEnemies.ArchmireModel.archmireSize / 2),
                            (int) client.gameController.archmirePoints.get(i).y - (AllEnemies.ArchmireModel.archmireSize / 2),
                            AllEnemies.ArchmireModel.archmireSize,
                            AllEnemies.ArchmireModel.archmireSize);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawWyrm(Graphics g) {
        if (!client.gameController.wyrmEnemies.isEmpty()) {
            for (int i = 0; i < client.gameController.wyrmEnemies.size(); i++) {
                if (client.gameController.wyrmEnemies.get(i).enemyHealth > 0) {
                    super.paintComponent(g);
                    g.drawImage(AllEnemies.WyrmModel.image,
                            (int) client.gameController.wyrmEnemies.get(i).x,
                            (int) client.gameController.wyrmEnemies.get(i).y,
                            AllEnemies.WyrmModel.wyrmSize,
                            AllEnemies.WyrmModel.wyrmSize,
                            null);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawBarricados1(Graphics g) {
        if (!client.gameController.barricadosEnemies1.isEmpty()) {
            for (int i = 0; i < client.gameController.barricadosEnemies1.size(); i++) {
                if (client.gameController.barricadosEnemies1.get(i).enemyTimer > 0) {
                    super.paintComponent(g);
                    g.drawImage(AllEnemies.BarricadosModel1.image,
                            (int) client.gameController.barricadosEnemies1.get(i).x,
                            (int) client.gameController.barricadosEnemies1.get(i).y,
                            AllEnemies.BarricadosModel1.barricadosSize,
                            AllEnemies.BarricadosModel1.barricadosSize,
                            null);
                }
            }
        }
        repaint();
        repaint();
    }


    public void drawBarricados2(Graphics g) {
        if (!client.gameController.barricadosEnemies2.isEmpty()) {
            for (int i = 0; i < client.gameController.barricadosEnemies2.size(); i++) {
                if (client.gameController.barricadosEnemies2.get(i).enemyTimer > 0) {
                    super.paintComponent(g);
                    g.drawImage(AllEnemies.BarricadosModel2.image,
                            (int) client.gameController.barricadosEnemies2.get(i).x,
                            (int) client.gameController.barricadosEnemies2.get(i).y,
                            AllEnemies.BarricadosModel2.barricadosSize,
                            AllEnemies.BarricadosModel2.barricadosSize,
                            null);
                }
            }
        }
        repaint();
        repaint();
    }


    public void drawBlackOrb(Graphics g) {
        if (!client.gameController.blackOrbEnemies.isEmpty()) {
            for (int i = 0; i < client.gameController.blackOrbEnemies.size(); i++) {
                if (client.gameController.blackOrbEnemies.get(i).enemyHealth > 0) {
                    int x = (int) client.gameController.blackOrbEnemies.get(i).x;
                    int y = (int) client.gameController.blackOrbEnemies.get(i).y;
                    int x1 = x;
                    int x2 = (int) (x + (AllEnemies.BlackOrbModel.blackOrbSize * Math.cos(Math.PI / 10)));
                    int x3 = (int) (x + (AllEnemies.BlackOrbModel.blackOrbSize * Math.sin(Math.PI / 10)));
                    int x4 = (int) (x - (AllEnemies.BlackOrbModel.blackOrbSize * Math.sin(Math.PI / 10)));
                    int x5 = (int) (x - (AllEnemies.BlackOrbModel.blackOrbSize * Math.cos(Math.PI / 10)));
                    int y1 = (int) y - AllEnemies.BlackOrbModel.blackOrbSize;
                    int y2 = (int) (y - (AllEnemies.BlackOrbModel.blackOrbSize * Math.sin(Math.PI / 10)));
                    int y3 = (int) (y + (AllEnemies.BlackOrbModel.blackOrbSize * Math.cos(Math.PI / 10)));
                    int y4 = (int) (y + (AllEnemies.BlackOrbModel.blackOrbSize * Math.cos(Math.PI / 10)));
                    int y5 = (int) (y - (AllEnemies.BlackOrbModel.blackOrbSize * Math.sin(Math.PI / 10)));
                    super.paintComponent(g);
                    g.setColor(new Color(0x575555));
                    Graphics2D g2d = (Graphics2D) g;
                    if (client.gameController.blackOrbEnemies.get(i).draw1) {
                        g2d.fillOval(x1 - 5, y1 - 5, 10, 10);
                    }
                    if (client.gameController.blackOrbEnemies.get(i).draw2) {
                        g2d.fillOval(x2 - 5, y2 - 5, 10, 10);
                    }
                    if (client.gameController.blackOrbEnemies.get(i).draw3) {
                        g2d.fillOval(x3 - 5, y3 - 5, 10, 10);
                    }
                    if (client.gameController.blackOrbEnemies.get(i).draw4) {
                        g2d.fillOval(x4 - 5, y4 - 5, 10, 10);
                    }
                    if (client.gameController.blackOrbEnemies.get(i).draw5) {
                        g2d.fillOval(x5 - 5, y5 - 5, 10, 10);

                        g2d.setColor(new Color(0x9D15DC));
                        g2d.setStroke(new BasicStroke(2));
                        Polygon polygon = new Polygon(new int[]{x1, x2, x3, x4, x5},
                                new int[]{y1, y2, y3, y4, y5}, 5);
                        g2d.drawPolygon(polygon);

                        Polygon polygon1 = new Polygon(new int[]{x4, x1, x3, x5, x2, x4},
                                new int[]{y4, y1, y3, y5, y2, y4}, 6);
                        g2d.drawPolygon(polygon1);

                    }

                }
            }
        }
        repaint();
        repaint();
    }
}
