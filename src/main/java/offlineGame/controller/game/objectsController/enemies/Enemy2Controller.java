package offlineGame.controller.game.objectsController.enemies;

import model.entity.enemy.AllEnemies;
import offlineGame.controller.game.GameController;
import offlineGame.controller.game.Rotation;

import static offlineGame.controller.game.GameController.ball;
import static offlineGame.controller.game.GameController.enemies2;

public class Enemy2Controller {


    public static void setDirectionForEnemy2() {
        if (!GameController.enemies2.isEmpty()) {
            for (int i = 0; i < enemies2.size(); i++) {
                if (enemies2.get(i).enemyHealth > 0) {
                    enemies2.get(i).dx = -((enemies2.get(i).x - ball.x) / Math.sqrt(Math.pow((enemies2.get(i).x - ball.x), 2) + Math.pow((enemies2.get(i).y - ball.y), 2))) * AllEnemies.EnemyModel2.enemySpeed;
                    if (ball.y < enemies2.get(i).y) {
                        enemies2.get(i).dy = -Math.sqrt(Math.pow(AllEnemies.EnemyModel2.enemySpeed, 2) - Math.pow(enemies2.get(i).dx, 2));
                    } else {
                        enemies2.get(i).dy = Math.sqrt(Math.pow(AllEnemies.EnemyModel2.enemySpeed, 2) - Math.pow(enemies2.get(i).dx, 2));
                    }
                    if (ball.ballDismay) {
                        enemies2.get(i).dx = -enemies2.get(i).dx;
                        enemies2.get(i).dy = -enemies2.get(i).dy;
                    }
                }
            }
        }
    }

    public static void updateEnemy2() {
        setDirectionForEnemy2();
        if (!GameController.enemies2.isEmpty()) {
            for (int i = 0; i < enemies2.size(); i++) {
                if (enemies2.get(i).enemyHealth > 0) {
                    double epsilonDistance = Math.sqrt(Math.pow(Math.abs(enemies2.get(i).x - ball.x), 2) + Math.pow(Math.abs(enemies2.get(i).y - ball.y), 2));
                    if (epsilonDistance > 100) {
                        enemies2.get(i).x += 2 * (enemies2.get(i).dx + enemies2.get(i).ax);
                        enemies2.get(i).y += 2 * (enemies2.get(i).dy + enemies2.get(i).ay);
                    }
                    if (epsilonDistance <= 100) {
                        enemies2.get(i).x += enemies2.get(i).dx + enemies2.get(i).ax;
                        enemies2.get(i).y += enemies2.get(i).dy + enemies2.get(i).ay;
                    }

                    if (enemies2.get(i).ax != 0) {
                        if (enemies2.get(i).ax > 0) {
                            enemies2.get(i).ax -= 0.05;
                        } else {
                            enemies2.get(i).ax += 0.05;
                        }
                    }
                    if (enemies2.get(i).ay != 0) {
                        if (enemies2.get(i).ay > 0) {
                            enemies2.get(i).ay -= 0.05;
                        } else {
                            enemies2.get(i).ay += 0.05;
                        }
                    }
                    Rotation.enemy2Rotation();
                }
            }
        }

    }
}
