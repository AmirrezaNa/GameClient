package offlineGame.controller.game.collisions.bossFight;

import offlineGame.controller.game.Impact;
import model.entity.BallModel;

import static offlineGame.controller.game.GameController.*;
import static offlineGame.view.gameLoop.phase2.finalBoss.EpsilonFrame.epsilonFrame;

public class FrameCollisionBossFight {


    public static void checkBossFightFrameCollisions() {
        checkBulletCollisions();
        checkBallCollisions();
    }


    public static void checkBulletCollisions() {
        // bullets collisions
        checkBulletHitFrame();

    }

    public static void checkBallCollisions() {
        //ball collisions
        checkBallCollisionToFrame();
    }



    // =================================================================================


    public static void checkBulletHitFrame() {
        if (!bullets.isEmpty()) {
            int size;
            if (bullets.size() > 15) {
                size = 15;
            } else {
                size = bullets.size();
            }
            for (int i = 0; i < size; i++) {
                if (bullets.get(i).bulletHealth > 0) {

                    if (!smiley.squeezeAttack) {
                        if (bullets.get(i).x > (epsilonFrame.x + epsilonFrame.width) &&
                                bullets.get(i).y > (epsilonFrame.y) && bullets.get(i).y < (epsilonFrame.y + epsilonFrame.height)) {
                            bullets.get(i).dx = 0;
                            bullets.get(i).dy = 0;
                            bullets.get(i).bulletHealth = 0;
                            epsilonFrame.width += 30;
                            epsilonFrame.x += 3;
                        }

                        else if (bullets.get(i).x < epsilonFrame.x &&
                                bullets.get(i).y > (epsilonFrame.y) && bullets.get(i).y < (epsilonFrame.y + epsilonFrame.height)) {
                            bullets.get(i).dx = 0;
                            bullets.get(i).dy = 0;
                            bullets.get(i).bulletHealth = 0;
                            epsilonFrame.x -= 40;
                            epsilonFrame.width += 30;

                        }

                    }

                }
            }
        }
    }


    public static void checkBallCollisionToFrame() {
        if ((ball.x + BallModel.ballRadius) >= (epsilonFrame.x + epsilonFrame.width)) {
            Impact.turnOnImpact(ball.x + BallModel.ballRadius,
                    ball.y,
                    ball.x + BallModel.ballRadius,
                    ball.y);
        }
        if (ball.x - BallModel.ballRadius <= epsilonFrame.x) {
            Impact.turnOnImpact(ball.x - BallModel.ballRadius,
                    ball.y,
                    ball.x - BallModel.ballRadius,
                    ball.y);
        }
        if ((ball.y + BallModel.ballRadius) >= (epsilonFrame.y + epsilonFrame.height)) {
            Impact.turnOnImpact(ball.x,
                    ball.y + BallModel.ballRadius,
                    ball.x,
                    ball.y + BallModel.ballRadius);
        }
        if (ball.y - BallModel.ballRadius <= epsilonFrame.y) {
            Impact.turnOnImpact(ball.x,
                    ball.y - BallModel.ballRadius,
                    ball.x,
                    ball.y - BallModel.ballRadius);
        }
    }

}
