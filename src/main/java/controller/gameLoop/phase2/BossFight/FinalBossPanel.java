package controller.gameLoop.phase2.BossFight;

import controller.gameController.listener.KeyInputListenerOnline;
import controller.gameController.listener.MouseInputListenerOnline;
import model.entity.BallAngle;
import model.entity.BallDirection;
import model.entity.BallModel;
import model.entity.BulletModel;
import model.entity.enemy.AllEnemies;
import model.entity.enemy.boss.LeftHandModel;
import model.entity.enemy.boss.PunchModel;
import model.entity.enemy.boss.RightHandModel;
import model.entity.enemy.boss.SmileyModel;
import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameFrame2;

import javax.swing.*;
import java.awt.*;

import static view.EnterNamePageOnline.client;

public class FinalBossPanel extends JPanel implements Runnable {



    KeyInputListenerOnline keyInputListener;
    MouseInputListenerOnline mouseInputListener;
    public static boolean finalBossOver;
    EpsilonFrame epsilonFrame;


    public FinalBossPanel() {
        client.gameController.phase2Over = true;
        finalBossOver = false;
        this.setBounds(0, 0, GameFrame2.width, GameFrame2.height);

        this.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
        this.setOpaque(false);
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

        while (!client.gameController.finalBossOver) {



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

        drawEpsilonFrame(g);
        drawArchmireTrace(g);

        client.gameFrame.gamePanel.drawBallCerberus(g);
        drawBall(g);
        drawBallDirection(g);
        drawBallAngle(g);

        drawSmiley(g);
        drawRightHand(g);
        drawLeftHand(g);
        drawPunch(g);


        drawBullet(g);
        drawEnemyBullet(g);

        revalidate();
        repaint();
    }


    public void drawEpsilonFrame(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
//        int x = client.gameController.epsilonFrame.x;
//        int y = client.gameController.epsilonFrame.y;
//        int width = client.gameController.epsilonFrame.width;
//        int height = client.gameController.epsilonFrame.height;
        g.fillRect(client.gameController.xEpsilonFrame,
                client.gameController.yEpsilonFrame,
                client.gameController.widthEpsilonFrame,
                client.gameController.heightEpsilonFrame);
        revalidate();
        repaint();

    }

    public void drawBall(Graphics g) {
        super.paintComponent(g);
        if (client.gameController.ball != null) {
            g.setColor(new Color(0x1C8F09));
            g.fillOval((int) client.gameController.ball.x - BallModel.ballRadius, (int) client.gameController.ball.y - BallModel.ballRadius,
                    2 * BallModel.ballRadius, 2 * BallModel.ballRadius);
        }
        revalidate();
        repaint();
    }

    public void drawBallDirection(Graphics g) {
        super.paintComponent(g);
        if (client.gameController.ballDirection != null) {
            g.setColor(new Color(0x132F46));
            g.fillOval((int) (client.gameController.ballDirection.x - 5), (int) (client.gameController.ballDirection.y - 5), 10, 10);
        }
        revalidate();
        repaint();
    }

    public void drawBallAngle(Graphics g) {
        super.paintComponent(g);
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
            }
            else {
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
            int size = Math.min(client.gameController.enemyBullets.size(), 20);
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


    public void drawArchmireTrace(Graphics g) {
        int size = Math.min(30, client.gameController.archmirePoints.size());
        if (!client.gameController.archmirePoints.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (client.gameController.archmirePoints.get(i).archmirePointTimer > 0) {
                    super.paintComponent(g);
                    g.setColor(new Color(0x4B2828));
                    g.fillOval((int)client.gameController.archmirePoints.get(i).x - (AllEnemies.ArchmireModel.archmireSize/2),
                            (int)client.gameController.archmirePoints.get(i).y - (AllEnemies.ArchmireModel.archmireSize/2),
                            AllEnemies.ArchmireModel.archmireSize,
                            AllEnemies.ArchmireModel.archmireSize);
                }
            }
        }
        repaint();
        repaint();
    }

    public void drawSmiley(Graphics g) {
        if (client.gameController.smiley != null) {
            g.drawImage(SmileyModel.image,
                    (int) (client.gameController.smiley.x - (SmileyModel.smileySize/2)),
                    (int) (client.gameController.smiley.y - (SmileyModel.smileySize/2)),
                    SmileyModel.smileySize,
                    SmileyModel.smileySize, null);
        }
        revalidate();
        repaint();
    }

    public void drawRightHand(Graphics g) {
        if (client.gameController.rightHand != null) {
            g.drawImage(RightHandModel.image,
                    (int) client.gameController.rightHand.x,
                    (int) (client.gameController.rightHand.y - (RightHandModel.rightHandSize/2)),
                    RightHandModel.rightHandSize,
                    RightHandModel.rightHandSize, null);
        }
        revalidate();
        repaint();
    }

    public void drawLeftHand(Graphics g) {
        if (client.gameController.leftHand != null) {
            g.drawImage(LeftHandModel.image,
                    (int) client.gameController.leftHand.x - LeftHandModel.leftHandSize,
                    (int) (client.gameController.leftHand.y - (LeftHandModel.leftHandSize/2)),
                    LeftHandModel.leftHandSize,
                    LeftHandModel.leftHandSize, null);
        }
        revalidate();
        repaint();
    }


    public void drawPunch(Graphics g) {
        if (client.gameController.smiley.punchExists && client.gameController.punch != null) {
            g.drawImage(PunchModel.image,
                    (int) (client.gameController.punch.x - (PunchModel.punchSize / 2)),
                    (int) (client.gameController.punch.y - PunchModel.punchSize),
                    PunchModel.punchSize,
                    PunchModel.punchSize, null);
        }
        revalidate();
        repaint();
    }





}
