package offlineGame.controller.game.objectsController.finalBoss;

import static offlineGame.controller.game.GameController.punch;
import static offlineGame.controller.game.GameController.smiley;
import static offlineGame.view.gameLoop.phase2.finalBoss.EpsilonFrame.epsilonFrame;

public class PunchController {

    public static void updatePunch() {
        if (punch != null) {
            if (smiley.powerPunchAttack || smiley.quakeAttack || smiley.slapAttack) {
                if ((punch.y < epsilonFrame.y)) {
                    punch.y += punch.dy;
                }

            } else if (punch.y < 250) {
                punch.y += punch.dy;
            } else {
                punch.y -= punch.dy;
            }
        }
    }
}
