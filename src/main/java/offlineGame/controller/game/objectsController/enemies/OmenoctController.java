package offlineGame.controller.game.objectsController.enemies;

import model.entity.enemy.AllEnemies;
import offlineGame.controller.game.FrameOfObject;
import offlineGame.controller.game.GameController;
import offlineGame.controller.game.Rotation;
import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GamePanel2;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static offlineGame.controller.game.GameController.*;
import static offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GameInternalFrame.createdFrames;

public class OmenoctController {


    public static void setDirectionForOmenoct() {
        if (!omenoctEnemies.isEmpty()) {
            for (int i = 0; i < omenoctEnemies.size(); i++) {
                if (omenoctEnemies.get(i).enemyHealth > 0) {
                    if (FrameOfObject.getFrameOfBall() != -1) {
                        int x = createdFrames[FrameOfObject.getFrameOfBall()].x + createdFrames[FrameOfObject.getFrameOfBall()].width - (AllEnemies.OmenoctModel.omenoctSize / 2);
//                        int y = createdFrames[FrameOfObject.getFrameOfBall()].y + createdFrames[FrameOfObject.getFrameOfBall()].height / 2;
                        int y = (int) ball.y;
                        omenoctEnemies.get(i).dx = -((omenoctEnemies.get(i).x - x) / Math.sqrt(Math.pow((omenoctEnemies.get(i).x - x), 2) + Math.pow((omenoctEnemies.get(i).y - y), 2))) * AllEnemies.OmenoctModel.enemySpeed;
                        if (y < omenoctEnemies.get(i).y) {
                            omenoctEnemies.get(i).dy = -Math.sqrt(Math.pow(AllEnemies.OmenoctModel.enemySpeed, 2) - Math.pow(omenoctEnemies.get(i).dx, 2));
                        } else {
                            omenoctEnemies.get(i).dy = Math.sqrt(Math.pow(AllEnemies.OmenoctModel.enemySpeed, 2) - Math.pow(omenoctEnemies.get(i).dx, 2));
                        }
                    }
                }
            }
        }
    }

    public static void setDirectionWhileDismay() {
        if (!omenoctEnemies.isEmpty()) {
            for (int i = 0; i < omenoctEnemies.size(); i++) {
                if (omenoctEnemies.get(i).enemyHealth > 0) {
                    omenoctEnemies.get(i).dx = -((omenoctEnemies.get(i).x - ball.x) / Math.sqrt(Math.pow((omenoctEnemies.get(i).x - ball.x), 2) + Math.pow((omenoctEnemies.get(i).y - ball.y), 2))) * AllEnemies.EnemyModel1.enemySpeed;
                    if (ball.y < omenoctEnemies.get(i).y) {
                        omenoctEnemies.get(i).dy = -Math.sqrt(Math.pow(AllEnemies.EnemyModel1.enemySpeed, 2) - Math.pow(omenoctEnemies.get(i).dx, 2));
                    } else {
                        omenoctEnemies.get(i).dy = Math.sqrt(Math.pow(AllEnemies.EnemyModel1.enemySpeed, 2) - Math.pow(omenoctEnemies.get(i).dx, 2));
                    }
                    if (ball.ballDismay) {
                        omenoctEnemies.get(i).dx = -omenoctEnemies.get(i).dx;
                        omenoctEnemies.get(i).dy = -omenoctEnemies.get(i).dy;
                    }
                }
            }
        }
    }


    public static void updateOmenoct() {
        if (ball.ballDismay) {
            setDirectionWhileDismay();
        }
        setDirectionForOmenoct();
        if (!omenoctEnemies.isEmpty()) {
            for (int i = 0; i < omenoctEnemies.size(); i++) {
                if (omenoctEnemies.get(i).enemyHealth > 0) {
                    omenoctEnemies.get(i).x += omenoctEnemies.get(i).dx + omenoctEnemies.get(i).ax;
                    omenoctEnemies.get(i).y += omenoctEnemies.get(i).dy + omenoctEnemies.get(i).ay;

                    if (omenoctEnemies.get(i).ax != 0) {
                        if (omenoctEnemies.get(i).ax > 0) {
                            omenoctEnemies.get(i).ax -= 0.05;
                        } else {
                            omenoctEnemies.get(i).ax += 0.05;
                        }
                    }
                    if (omenoctEnemies.get(i).ay != 0) {
                        if (omenoctEnemies.get(i).ay > 0) {
                            omenoctEnemies.get(i).ay -= 0.05;
                        } else {
                            omenoctEnemies.get(i).ay += 0.05;
                        }
                    }
                    Rotation.enemy2Rotation();
                }
            }
        }

    }


    public static void shotBullet() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!GamePanel2.phase2Over) {
                    for (int i = 0; i < omenoctEnemies.size(); i++) {
                        if (omenoctEnemies.get(i).enemyHealth > 0 && !GameController.pause) {
                            Point point = new Point();
                            point.setLocation(omenoctEnemies.get(i).x + AllEnemies.OmenoctModel.distanceToCenter,
                                    omenoctEnemies.get(i).y + AllEnemies.OmenoctModel.distanceToCenter);
                            newOmenoctBullet(point);
                        }
                    }
                }
            }

        };
        timer.scheduleAtFixedRate(task, 5000, 5000);
    }

}
