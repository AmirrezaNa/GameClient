package offlineGame.controller.game.objectsController.enemies;

import model.entity.enemy.AllEnemies;
import offlineGame.controller.game.GameController;

import java.util.Timer;
import java.util.TimerTask;

import static offlineGame.controller.game.GameController.*;

public class ArchmireController {

    public static void setDirectionForArchmire() {
        if (!archmireEnemies.isEmpty()) {
            for (int i = 0; i < archmireEnemies.size(); i++) {
                if (archmireEnemies.get(i).enemyHealth > 0) {
                    archmireEnemies.get(i).dx = -((archmireEnemies.get(i).x - ball.x) / Math.sqrt(Math.pow((archmireEnemies.get(i).x - ball.x), 2) + Math.pow((archmireEnemies.get(i).y - ball.y), 2))) * AllEnemies.ArchmireModel.enemySpeed;
                    if (ball.y < archmireEnemies.get(i).y) {
                        archmireEnemies.get(i).dy = -Math.sqrt(Math.pow(AllEnemies.ArchmireModel.enemySpeed, 2) - Math.pow(archmireEnemies.get(i).dx, 2));
                    } else {
                        archmireEnemies.get(i).dy = Math.sqrt(Math.pow(AllEnemies.ArchmireModel.enemySpeed, 2) - Math.pow(archmireEnemies.get(i).dx, 2));
                    }
                }
            }
        }
    }

    public static void updateArchmire() {
        setDirectionForArchmire();
        if (!archmireEnemies.isEmpty()) {
            for (int i = 0; i < archmireEnemies.size(); i++) {
                if (archmireEnemies.get(i).enemyHealth > 0) {
                    archmireEnemies.get(i).x += archmireEnemies.get(i).dx + archmireEnemies.get(i).ax;
                    archmireEnemies.get(i).y += archmireEnemies.get(i).dy + archmireEnemies.get(i).ay;

                    if (archmireEnemies.get(i).ax != 0) {
                        if (archmireEnemies.get(i).ax > 0) {
                            archmireEnemies.get(i).ax -= 0.05;
                        } else {
                            archmireEnemies.get(i).ax += 0.05;
                        }
                    }
                    if (archmireEnemies.get(i).ay != 0) {
                        if (archmireEnemies.get(i).ay > 0) {
                            archmireEnemies.get(i).ay -= 0.05;
                        } else {
                            archmireEnemies.get(i).ay += 0.05;
                        }
                    }
                }
            }
        }

    }

    public static void setTrace(AllEnemies.ArchmireModel archmire) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (archmire.enemyHealth > 0  && !GameController.pause) {
                    AllEnemies.ArchmirePoints archmirePoint = new AllEnemies.ArchmirePoints(archmire.x + ((double) AllEnemies.ArchmireModel.archmireSize / 2), archmire.y + ((double) AllEnemies.ArchmireModel.archmireSize / 2));
                    archmirePoints.add(0, archmirePoint);
                    setTimerForPoint(archmirePoint);
                }
//                if (stopWave) {
//                    timer.cancel();
//                }
            }

        };
        timer.scheduleAtFixedRate(task, 0, 500);
    }


    public static void setTimerForPoint(AllEnemies.ArchmirePoints archmirePoint) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!GameController.pause) {
                    archmirePoint.archmirePointTimer--;
                }

//                if (stopWave) {
//                    timer.cancel();
//                }
            }

        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


}
