package offlineGame.controller.game.objectsController.finalBoss;

import static offlineGame.controller.game.GameController.rightHand;
import static offlineGame.controller.game.GameController.smiley;
import static offlineGame.view.gameLoop.phase2.finalBoss.EpsilonFrame.epsilonFrame;

public class RightHandController {

    public static void updateRightHand() {
        if (rightHand != null) {

            if (smiley.squeezeAttack) {
                if ((rightHand.x > (epsilonFrame.x + epsilonFrame.width))) {
                    rightHand.x += rightHand.dx;
                }
                else {
                    rightHand.x -= rightHand.dx;
                }

            } else if (rightHand.x > 1000) {
                rightHand.x += rightHand.dx;
            } else if (rightHand.x < 1000) {
                rightHand.x -= rightHand.dx;
            } else {
                if (rightHand.dy > 0) {
                    if (rightHand.y > 500) {
                        rightHand.dy = -rightHand.dy;
                    }
                }
                if (rightHand.dy < 0) {
                    if (rightHand.y < 200) {
                        rightHand.dy = -rightHand.dy;
                    }
                }
                rightHand.y += rightHand.dy;
            }
        }
    }


}
