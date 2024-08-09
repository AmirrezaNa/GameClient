package offlineGame.controller.game.collisions.phase1;

import offlineGame.controller.Constants;
import offlineGame.controller.data.controller.SoundEffects;
import offlineGame.controller.game.GameController;
import offlineGame.controller.game.Impact;
import model.entity.BallAngle;
import model.entity.BallModel;
import model.entity.BulletModel;
import model.entity.Collectible;
import offlineGame.view.settings.SettingsPanel;
import offlineGame.view.startPage.EnterNamePage;

import static offlineGame.controller.game.GameController.*;

public class ObjectCollision {


    // ===========  Here is where we are checking the intersections of different types of objects ===============


    public static void checkObjectsCollisions() {
        checkCollisionEnemy1Enemy2();
        checkCollisionEnemy1Enemy1();
        checkCollisionEnemy2Enemy2();

        checkCollisionBallEnemy1();
        checkCollisionBallEnemy2();
        checkCollisionBallCollectible();

        checkCollisionBulletEnemy1();
        checkCollisionBulletEnemy2();


        checkCollisionBallAngleEnemy1();
        checkCollisionBallAngleEnemy2();

    }


    // ===========  Here is where we are checking the intersections of different types of objects ===============


    // a method for checking intersections between enemy1 and enemy2

    public static void checkCollisionEnemy1Enemy2() {
        if (!enemies1.isEmpty()) {
            for (int k = 0; k < enemies1.size(); k++) {
                if (enemies1.get(k).enemyHealth > 0) {

                    double xMin1 = enemies1.get(k).xAngles[0];
                    double xMax1 = enemies1.get(k).xAngles[0];
                    double yMin1 = enemies1.get(k).yAngles[0];
                    double yMax1 = enemies1.get(k).yAngles[0];
                    for (int i = 0; i < 4; i++) {
                        if (enemies1.get(k).xAngles[i] < xMin1) {
                            xMin1 = enemies1.get(k).xAngles[i];
                        }
                        if (enemies1.get(k).xAngles[i] > xMax1) {
                            xMax1 = enemies1.get(k).xAngles[i];
                        }
                        if (enemies1.get(k).yAngles[i] < yMin1) {
                            yMin1 = enemies1.get(k).yAngles[i];
                        }
                        if (enemies1.get(k).yAngles[i] > yMax1) {
                            yMax1 = enemies1.get(k).yAngles[i];
                        }
                    }
                    for (int j = 0; j < enemies2.size(); j++) {
                        if (enemies2.get(j).enemyHealth > 0) {

                            double xMin2 = enemies2.get(j).xAngles[0];
                            double xMax2 = enemies2.get(j).xAngles[0];
                            double yMin2 = enemies2.get(j).yAngles[0];
                            double yMax2 = enemies2.get(j).yAngles[0];
                            for (int i = 0; i < 3; i++) {
                                if (enemies2.get(j).xAngles[i] < xMin2) {
                                    xMin2 = enemies2.get(j).xAngles[i];
                                }
                                if (enemies2.get(j).xAngles[i] > xMax2) {
                                    xMax2 = enemies2.get(j).xAngles[i];
                                }
                                if (enemies2.get(j).yAngles[i] < yMin2) {
                                    yMin2 = enemies2.get(j).yAngles[i];
                                }
                                if (enemies2.get(j).yAngles[i] > yMax2) {
                                    yMax2 = enemies2.get(j).yAngles[i];
                                }
                            }

                            if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {
                                enemies1.get(k).dash = false;
                                Impact.turnOnImpact(enemies1.get(k).x,
                                        enemies1.get(k).y,
                                        enemies2.get(j).x,
                                        enemies2.get(j).y);
                            }
                        }
                    }
                }
            }
        }
    }


    // ==========================================================================================


    // this method is for checking the intersections between enemies of type1 with each other
    public static void checkCollisionEnemy1Enemy1() {
        for (int i = 0; i < enemies1.size() - 1; i++) {
            if (enemies1.get(i).enemyHealth > 0) {

                double xMin1 = enemies1.get(i).xAngles[0];
                double xMax1 = enemies1.get(i).xAngles[0];
                double yMin1 = enemies1.get(i).yAngles[0];
                double yMax1 = enemies1.get(i).yAngles[0];
                for (int k = 0; k < 4; k++) {
                    if (xMin1 > enemies1.get(i).xAngles[k]) {
                        xMin1 = enemies1.get(i).xAngles[k];
                    }
                    if (xMax1 < enemies1.get(i).xAngles[k]) {
                        xMax1 = enemies1.get(i).xAngles[k];
                    }
                    if (yMin1 > enemies1.get(i).yAngles[k]) {
                        yMin1 = enemies1.get(i).yAngles[k];
                    }
                    if (yMax1 < enemies1.get(i).yAngles[k]) {
                        yMax1 = enemies1.get(i).yAngles[k];
                    }
                }
                for (int j = i + 1; j < enemies1.size(); j++) {
                    if (enemies1.get(j).enemyHealth > 0) {

                        double xMin2 = enemies1.get(j).xAngles[0];
                        double xMax2 = enemies1.get(j).xAngles[0];
                        double yMin2 = enemies1.get(j).yAngles[0];
                        double yMax2 = enemies1.get(j).yAngles[0];
                        for (int k = 0; k < 4; k++) {
                            if (xMin2 > enemies1.get(j).xAngles[k]) {
                                xMin2 = enemies1.get(j).xAngles[k];
                            }
                            if (xMax2 < enemies1.get(j).xAngles[k]) {
                                xMax2 = enemies1.get(j).xAngles[k];
                            }
                            if (yMin2 > enemies1.get(j).yAngles[k]) {
                                yMin2 = enemies1.get(j).yAngles[k];
                            }
                            if (yMax2 < enemies1.get(j).yAngles[k]) {
                                yMax2 = enemies1.get(j).yAngles[k];
                            }
                        }

                        if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                                || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {

                            enemies1.get(i).dash = false;
                            enemies1.get(j).dash = false;
                            Impact.turnOnImpact(enemies1.get(i).x,
                                    enemies1.get(i).y,
                                    enemies1.get(j).x,
                                    enemies1.get(j).y);

                        }
                    }
                }
            }
        }
    }

    // this method is for checking the intersections between enemies of type2 with each other

    public static void checkCollisionEnemy2Enemy2() {
        for (int i = 0; i < enemies2.size() - 1; i++) {
            if (enemies2.get(i).enemyHealth > 0) {

                double xMin1 = enemies2.get(i).xAngles[0];
                double xMax1 = enemies2.get(i).xAngles[0];
                double yMin1 = enemies2.get(i).yAngles[0];
                double yMax1 = enemies2.get(i).yAngles[0];
                for (int k = 0; k < 3; k++) {
                    if (xMin1 > enemies2.get(i).xAngles[k]) {
                        xMin1 = enemies2.get(i).xAngles[k];
                    }
                    if (xMax1 < enemies2.get(i).xAngles[k]) {
                        xMax1 = enemies2.get(i).xAngles[k];
                    }
                    if (yMin1 > enemies2.get(i).yAngles[k]) {
                        yMin1 = enemies2.get(i).yAngles[k];
                    }
                    if (yMax1 < enemies2.get(i).yAngles[k]) {
                        yMax1 = enemies2.get(i).yAngles[k];
                    }
                }
                for (int j = i + 1; j < enemies2.size(); j++) {
                    if (enemies2.get(j).enemyHealth > 0) {

                        double xMin2 = enemies2.get(j).xAngles[0];
                        double xMax2 = enemies2.get(j).xAngles[0];
                        double yMin2 = enemies2.get(j).yAngles[0];
                        double yMax2 = enemies2.get(j).yAngles[0];
                        for (int k = 0; k < 3; k++) {
                            if (xMin2 > enemies2.get(j).xAngles[k]) {
                                xMin2 = enemies2.get(j).xAngles[k];
                            }
                            if (xMax2 < enemies2.get(j).xAngles[k]) {
                                xMax2 = enemies2.get(j).xAngles[k];
                            }
                            if (yMin2 > enemies2.get(j).yAngles[k]) {
                                yMin2 = enemies2.get(j).yAngles[k];
                            }
                            if (yMax2 < enemies2.get(j).yAngles[k]) {
                                yMax2 = enemies2.get(j).yAngles[k];
                            }
                        }

                        if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                                || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {

                            Impact.turnOnImpact(enemies2.get(i).x,
                                    enemies2.get(i).y,
                                    enemies2.get(j).x,
                                    enemies2.get(j).y);

                        }
                    }
                }
            }
        }
    }


    // a method for checking intersections between enemy1 and the ball

    public static void checkCollisionBallEnemy1() {
        double xMin1 = ball.x - BallModel.ballRadius;
        double xMax1 = ball.x + BallModel.ballRadius;
        double yMin1 = ball.y - BallModel.ballRadius;
        double yMax1 = ball.y + BallModel.ballRadius;
        for (int k = 0; k < enemies1.size(); k++) {
            if (enemies1.get(k).enemyHealth > 0) {

                double xMin2 = enemies1.get(k).xAngles[0];
                double xMax2 = enemies1.get(k).xAngles[0];
                double yMin2 = enemies1.get(k).yAngles[0];
                double yMax2 = enemies1.get(k).yAngles[0];
                for (int i = 0; i < 4; i++) {
                    if (enemies1.get(k).xAngles[i] < xMin2) {
                        xMin2 = enemies1.get(k).xAngles[i];
                    }
                    if (enemies1.get(k).xAngles[i] > xMax2) {
                        xMax2 = enemies1.get(k).xAngles[i];
                    }
                    if (enemies1.get(k).yAngles[i] < yMin2) {
                        yMin2 = enemies1.get(k).yAngles[i];
                    }
                    if (enemies1.get(k).yAngles[i] > yMax2) {
                        yMax2 = enemies1.get(k).yAngles[i];
                    }
                }

                if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                        || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                        || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                        || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {
                    boolean angleCollided = false;
                    for (int i = 0; i < 4; i++) {
                        if ((xMin1 <= enemies1.get(k).xAngles[i]) &&
                                (xMax1 >= enemies1.get(k).xAngles[i]) &&
                                (yMin1 <= enemies1.get(k).yAngles[i]) &&
                                (yMax1 >= enemies1.get(k).yAngles[i])) {
                            angleCollided = true;
                        }
                    }
                    if (angleCollided) {
                        if (SettingsPanel.level == 1) {
                            ball.HP -= 4;
                        }
                        if (SettingsPanel.level == 2) {
                            ball.HP -= 6;
                        }
                        if (SettingsPanel.level == 3) {
                            ball.HP -= 8;
                        }

                        SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                    }
                    if (EnterNamePage.player.isWritOfAstrape()) {
                        enemies1.get(k).enemyHealth -= 2;
                    }
                    if (ball.ballCerberus) {
                        enemies1.get(k).enemyHealth -= 10;
                        ball.ballCerberus = false;
                    }

                    enemies1.get(k).dash = false;
                    enemies1.get(k).dAngle = Math.PI;
                    Impact.turnOnImpact(ball.x,
                            ball.y,
                            enemies1.get(k).x,
                            enemies1.get(k).y);

                }
            }
        }
    }


    // a method for checking intersections between enemy2 and the ball

    public static void checkCollisionBallEnemy2() {
        double xMin1 = ball.x - BallModel.ballRadius;
        double xMax1 = ball.x + BallModel.ballRadius;
        double yMin1 = ball.y - BallModel.ballRadius;
        double yMax1 = ball.y + BallModel.ballRadius;
        for (int k = 0; k < enemies2.size(); k++) {
            if (enemies2.get(k).enemyHealth > 0) {

                double xMin2 = enemies2.get(k).xAngles[0];
                double xMax2 = enemies2.get(k).xAngles[0];
                double yMin2 = enemies2.get(k).yAngles[0];
                double yMax2 = enemies2.get(k).yAngles[0];
                for (int i = 0; i < 3; i++) {
                    if (enemies2.get(k).xAngles[i] < xMin2) {
                        xMin2 = enemies2.get(k).xAngles[i];
                    }
                    if (enemies2.get(k).xAngles[i] > xMax2) {
                        xMax2 = enemies2.get(k).xAngles[i];
                    }
                    if (enemies2.get(k).yAngles[i] < yMin2) {
                        yMin2 = enemies2.get(k).yAngles[i];
                    }
                    if (enemies2.get(k).yAngles[i] > yMax2) {
                        yMax2 = enemies2.get(k).yAngles[i];
                    }
                }

                if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                        || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                        || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                        || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {

                    boolean angleCollided = false;
                    for (int i = 0; i < 3; i++) {
                        if ((xMin1 <= enemies2.get(k).xAngles[i]) &&
                                (xMax1 >= enemies2.get(k).xAngles[i]) &&
                                (yMin1 <= enemies2.get(k).yAngles[i]) &&
                                (yMax1 >= enemies2.get(k).yAngles[i])) {
                            angleCollided = true;
                        }
                    }
                    if (angleCollided) {
                        if (SettingsPanel.level == 1) {
                            ball.HP -= 8;
                        }
                        if (SettingsPanel.level == 2) {
                            ball.HP -= 10;
                        }
                        if (SettingsPanel.level == 2) {
                            ball.HP -= 12;
                        }
                        SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                    }
                    if (EnterNamePage.player.isWritOfAstrape()) {
                        enemies2.get(k).enemyHealth -= 2;
                    }
                    if (ball.ballCerberus) {
                        enemies2.get(k).enemyHealth -= 10;
                        ball.ballCerberus = false;
                    }

                    enemies2.get(k).dAngle = Math.PI;
                    Impact.turnOnImpact(ball.x,
                            ball.y,
                            enemies2.get(k).x,
                            enemies2.get(k).y);

                }
            }

        }
    }

    // =================================================================================

    public static void checkCollisionBulletEnemy1() {
        if (!GameController.bullets.isEmpty()) {
            for (int j = 0; j < GameController.bullets.size(); j++) {
                if (GameController.bullets.get(j).bulletHealth > 0) {

                    double xMin1 = GameController.bullets.get(j).x;
                    double xMax1 = GameController.bullets.get(j).x + BulletModel.bulletSize;
                    double yMin1 = GameController.bullets.get(j).y;
                    double yMax1 = GameController.bullets.get(j).y + BulletModel.bulletSize;
                    for (int k = 0; k < enemies1.size(); k++) {
                        if (enemies1.get(k).enemyHealth > 0) {

                            double xMin2 = enemies1.get(k).xAngles[0];
                            double xMax2 = enemies1.get(k).xAngles[0];
                            double yMin2 = enemies1.get(k).yAngles[0];
                            double yMax2 = enemies1.get(k).yAngles[0];
                            for (int i = 0; i < 3; i++) {
                                if (enemies1.get(k).xAngles[i] < xMin2) {
                                    xMin2 = enemies1.get(k).xAngles[i];
                                }
                                if (enemies1.get(k).xAngles[i] > xMax2) {
                                    xMax2 = enemies1.get(k).xAngles[i];
                                }
                                if (enemies1.get(k).yAngles[i] < yMin2) {
                                    yMin2 = enemies1.get(k).yAngles[i];
                                }
                                if (enemies1.get(k).yAngles[i] > yMax2) {
                                    yMax2 = enemies1.get(k).yAngles[i];
                                }
                            }

                            if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {

                                GameController.bullets.get(j).bulletHealth = 0;
                                if (GameController.bulletAres) {
                                    enemies1.get(k).enemyHealth -= 7;
                                }
                                if (!GameController.bulletAres) {
                                    enemies1.get(k).enemyHealth -= 5;
                                }
                                if (ball.ballChiron) {
                                    ball.HP += 3;
                                }
                                if (BulletModel.bulletSlaughter) {
                                    enemies1.get(k).enemyHealth -= 50;
                                    BulletModel.bulletSlaughter = false;
                                }
                                SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                                if (enemies1.get(k).enemyHealth <= 0) {
                                    SoundEffects.playSound(Constants.HIT_SOUND_PATH);
                                    GameController.newCollectible(enemies1.get(k).x, enemies1.get(k).y, 5);
                                }
                                Impact.turnOnImpact(GameController.bullets.get(j).x + ((double) BulletModel.bulletSize / 2),
                                        GameController.bullets.get(j).y + ((double) BulletModel.bulletSize / 2),
                                        enemies1.get(k).x + ((double) enemies1.get(k).enemy1Size / 2),
                                        enemies1.get(k).y + ((double) enemies1.get(k).enemy1Size / 2));

                            }
                        }
                    }
                }
            }
        }
    }

    public static void checkCollisionBulletEnemy2() {
        if (!GameController.bullets.isEmpty()) {
            for (int j = 0; j < GameController.bullets.size(); j++) {
                if (GameController.bullets.get(j).bulletHealth > 0) {
                    double xMin1 = GameController.bullets.get(j).x;
                    double xMax1 = GameController.bullets.get(j).x + BulletModel.bulletSize;
                    double yMin1 = GameController.bullets.get(j).y;
                    double yMax1 = GameController.bullets.get(j).y + BulletModel.bulletSize;
                    for (int k = 0; k < enemies2.size(); k++) {
                        if (enemies2.get(k).enemyHealth > 0) {

                            double xMin2 = enemies2.get(k).xAngles[0];
                            double xMax2 = enemies2.get(k).xAngles[0];
                            double yMin2 = enemies2.get(k).yAngles[0];
                            double yMax2 = enemies2.get(k).yAngles[0];
                            for (int i = 0; i < 3; i++) {
                                if (enemies2.get(k).xAngles[i] < xMin2) {
                                    xMin2 = enemies2.get(k).xAngles[i];
                                }
                                if (enemies2.get(k).xAngles[i] > xMax2) {
                                    xMax2 = enemies2.get(k).xAngles[i];
                                }
                                if (enemies2.get(k).yAngles[i] < yMin2) {
                                    yMin2 = enemies2.get(k).yAngles[i];
                                }
                                if (enemies2.get(k).yAngles[i] > yMax2) {
                                    yMax2 = enemies2.get(k).yAngles[i];
                                }
                            }

                            if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                                    || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                                    || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {

                                GameController.bullets.get(j).bulletHealth = 0;
                                if (GameController.bulletAres) {
                                    enemies2.get(k).enemyHealth -= 7;
                                }
                                if (!GameController.bulletAres) {
                                    enemies2.get(k).enemyHealth -= 5;
                                }
                                if (ball.ballChiron) {
                                    ball.HP += 3;
                                }
                                if (BulletModel.bulletSlaughter) {
                                    enemies2.get(k).enemyHealth -= 50;
                                    BulletModel.bulletSlaughter = false;
                                }
                                SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                                if (enemies2.get(k).enemyHealth <= 0) {
                                    SoundEffects.playSound(Constants.HIT_SOUND_PATH);
                                    GameController.newCollectible(enemies2.get(k).x, enemies2.get(k).y, 5);
                                    GameController.newCollectible(enemies2.get(k).x + Collectible.collectibleSize, enemies2.get(k).y + Collectible.collectibleSize, 5);
                                }
                                Impact.turnOnImpact(GameController.bullets.get(j).x + ((double) BulletModel.bulletSize / 2),
                                        GameController.bullets.get(j).y + ((double) BulletModel.bulletSize / 2),
                                        enemies2.get(k).x + ((double) enemies2.get(k).enemy2Size / 2),
                                        enemies2.get(k).y + ((double) enemies2.get(k).enemy2Size / 2));

                            }
                        }
                    }
                }
            }
        }
    }

    // ===============================================================================


    public static void checkCollisionBallCollectible() {
        double xMin1 = ball.x - BallModel.ballRadius;
        double xMax1 = ball.x + BallModel.ballRadius;
        double yMin1 = ball.y - BallModel.ballRadius;
        double yMax1 = ball.y + BallModel.ballRadius;
        if (SettingsPanel.level == 1) {
            xMin1 = ball.x - ((double) (BallModel.ballRadius * 3) / 2);
            xMax1 = ball.x + ((double) (BallModel.ballRadius * 3) / 2);
            yMin1 = ball.y - ((double) (BallModel.ballRadius * 3) / 2);
            yMax1 = ball.y + ((double) (BallModel.ballRadius * 3) / 2);
        }

        if (!GameController.collectibles.isEmpty()) {
            for (int i = 0; i < GameController.collectibles.size(); i++) {
                if (GameController.collectibles.get(i).collectibleHealth > 0) {
                    double xMin2 = GameController.collectibles.get(i).x;
                    double xMax2 = GameController.collectibles.get(i).x + Collectible.collectibleSize;
                    double yMin2 = GameController.collectibles.get(i).y;
                    double yMax2 = GameController.collectibles.get(i).y + Collectible.collectibleSize;

                    if (SettingsPanel.level == 1) {
                        xMin2 = GameController.collectibles.get(i).x - (Collectible.collectibleSize / 2);
                        xMax2 = GameController.collectibles.get(i).x + (Collectible.collectibleSize * 3 / 2);
                        yMin2 = GameController.collectibles.get(i).y - (Collectible.collectibleSize / 2);
                        yMax2 = GameController.collectibles.get(i).y + (Collectible.collectibleSize * 3 / 2);
                    }

                    if (((xMin2 >= xMin1 && xMin2 <= xMax1) && (yMin2 >= yMin1 && yMin2 <= yMax1))
                            || ((xMin2 <= xMin1 && xMax2 >= xMin1) && (yMin2 >= yMin1 && yMin2 <= yMax1))
                            || ((xMin2 >= xMin1 && xMin2 <= xMax1) && (yMax2 >= yMin1 && yMax2 <= yMax1))
                            || ((xMin2 <= xMin1 && xMax2 >= xMin1) && (yMax2 >= yMin1 && yMax2 <= yMax1))) {
                        GameController.collectibles.get(i).collectibleHealth = 0;
                        EnterNamePage.player.setXP(EnterNamePage.player.getXP() + collectibles.get(i).xp);

                    }
                }

            }
        }
    }


    // ===============================================================================


    // a method for checking intersections between enemy1 and the ballAngle

    public static void checkCollisionBallAngleEnemy1() {
        if (GameController.ballAngle.angleExists) {

            double xMin1 = GameController.ballAngle.x - BallAngle.ballAngleRadius;
            double xMax1 = GameController.ballAngle.x + BallAngle.ballAngleRadius;
            double yMin1 = GameController.ballAngle.y - BallAngle.ballAngleRadius;
            double yMax1 = GameController.ballAngle.y + BallAngle.ballAngleRadius;
            for (int k = 0; k < enemies1.size(); k++) {
                if (enemies1.get(k).enemyHealth > 0) {

                    double xMin2 = enemies1.get(k).xAngles[0];
                    double xMax2 = enemies1.get(k).xAngles[0];
                    double yMin2 = enemies1.get(k).yAngles[0];
                    double yMax2 = enemies1.get(k).yAngles[0];
                    for (int i = 0; i < 4; i++) {
                        if (enemies1.get(k).xAngles[i] < xMin2) {
                            xMin2 = enemies1.get(k).xAngles[i];
                        }
                        if (enemies1.get(k).xAngles[i] > xMax2) {
                            xMax2 = enemies1.get(k).xAngles[i];
                        }
                        if (enemies1.get(k).yAngles[i] < yMin2) {
                            yMin2 = enemies1.get(k).yAngles[i];
                        }
                        if (enemies1.get(k).yAngles[i] > yMax2) {
                            yMax2 = enemies1.get(k).yAngles[i];
                        }
                    }

                    if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                            || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                            || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                            || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {


                        enemies1.get(k).dash = false;
                        enemies1.get(k).dAngle = Math.PI;
                        enemies1.get(k).enemyHealth -= 10;
                        if (ball.ballChiron) {
                            ball.HP += 3;
                        }
                        SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                        if (enemies1.get(k).enemyHealth <= 0) {
                            SoundEffects.playSound(Constants.HIT_SOUND_PATH);
                        }
                        Impact.turnOnImpact(ball.x,
                                ball.y,
                                enemies1.get(k).x,
                                enemies1.get(k).y);

                    }
                }
            }
        }
    }


    // a method for checking intersections between enemy2 and the ball

    public static void checkCollisionBallAngleEnemy2() {
        if (GameController.ballAngle.angleExists) {

            double xMin1 = GameController.ballAngle.x - BallAngle.ballAngleRadius;
            double xMax1 = GameController.ballAngle.x + BallAngle.ballAngleRadius;
            double yMin1 = GameController.ballAngle.y - BallAngle.ballAngleRadius;
            double yMax1 = GameController.ballAngle.y + BallAngle.ballAngleRadius;
            for (int k = 0; k < enemies2.size(); k++) {
                if (enemies2.get(k).enemyHealth > 0) {

                    double xMin2 = enemies2.get(k).xAngles[0];
                    double xMax2 = enemies2.get(k).xAngles[0];
                    double yMin2 = enemies2.get(k).yAngles[0];
                    double yMax2 = enemies2.get(k).yAngles[0];
                    for (int i = 0; i < 3; i++) {
                        if (enemies2.get(k).xAngles[i] < xMin2) {
                            xMin2 = enemies2.get(k).xAngles[i];
                        }
                        if (enemies2.get(k).xAngles[i] > xMax2) {
                            xMax2 = enemies2.get(k).xAngles[i];
                        }
                        if (enemies2.get(k).yAngles[i] < yMin2) {
                            yMin2 = enemies2.get(k).yAngles[i];
                        }
                        if (enemies2.get(k).yAngles[i] > yMax2) {
                            yMax2 = enemies2.get(k).yAngles[i];
                        }
                    }

                    if (((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                            || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMin1 >= yMin2 && yMin1 <= yMax2))
                            || ((xMin1 >= xMin2 && xMin1 <= xMax2) && (yMax1 >= yMin2 && yMax1 <= yMax2))
                            || ((xMin1 <= xMin2 && xMax1 >= xMin2) && (yMax1 >= yMin2 && yMax1 <= yMax2))) {


                        enemies2.get(k).dAngle = Math.PI;
                        enemies2.get(k).enemyHealth -= 10;
                        if (ball.ballChiron) {
                            ball.HP += 3;
                        }
                        SoundEffects.playSound(Constants.HURT_SOUND_PATH);
                        if (enemies2.get(k).enemyHealth <= 0) {
                            SoundEffects.playSound(Constants.HIT_SOUND_PATH);
                        }
                        Impact.turnOnImpact(ball.x,
                                ball.y,
                                enemies2.get(k).x,
                                enemies2.get(k).y);

                    }
                }

            }
        }
    }
}
