package offlineGame.controller.game.objectsController.enemies;

import model.entity.enemy.AllEnemies;
import offlineGame.controller.game.GameController;
import offlineGame.view.gameLoop.phase2.normalAndMiniBossEnemies.GamePanel2;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static offlineGame.controller.game.GameController.ball;
import static offlineGame.controller.game.GameController.necropickEnemies;

public class NecropickController {


    public static void update() {
        if (!necropickEnemies.isEmpty()) {
            for (int i = 0; i < necropickEnemies.size(); i++) {
                if (necropickEnemies.get(i).enemyHealth > 0) {
                    if (necropickEnemies.get(i).hidingTime <= 4) {
                        necropickEnemies.get(i).hide = true;
                    }
                    else if (necropickEnemies.get(i).hidingTime <= 12) {
                        necropickEnemies.get(i).hide = false;

                    }
                    if (necropickEnemies.get(i).hidingTime >= 2 && necropickEnemies.get(i).hidingTime <= 4) {
                        necropickEnemies.get(i).necropickAlert = true;
                    }
                    else {
                        necropickEnemies.get(i).necropickAlert = false;
                    }
                }
            }
        }
    }

    public static void setNecropickHidingTime() {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!GamePanel2.phase2Over) {
                    if (!necropickEnemies.isEmpty()) {
                        for (int i = 0; i < necropickEnemies.size(); i++) {
                            if (necropickEnemies.get(i).enemyHealth > 0 && !GameController.pause) {
                                necropickEnemies.get(i).hidingTime++;
                                if (necropickEnemies.get(i).hidingTime == 6) {
                                    shotNecropickBullets(necropickEnemies.get(i));
                                }
                                if (necropickEnemies.get(i).hidingTime == 12) {
                                    necropickEnemies.get(i).x = ball.x - 200;
                                    necropickEnemies.get(i).y = ball.y;
                                    necropickEnemies.get(i).hidingTime = 0;
                                }
                            }
                        }
                    }
                }
//                if (stopWave) {
//                    timer.cancel();
//                }
            }

        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


    public static void shotNecropickBullets(AllEnemies.NecropickModel necropick) {
        for (int i = 0; i < 8; i++) {
            Point point = new Point();
            point.setLocation(necropick.x + ((double) AllEnemies.NecropickModel.necropickSize / 2), necropick.y + ((double) AllEnemies.NecropickModel.necropickSize / 2));
            Point goal = new Point();
            goal.setLocation(ball.x, ball.y + 30 + ((Math.pow(-1,i) * i * 100)));
            GameController.newNecropickBullet(point, goal);
        }
    }


}
