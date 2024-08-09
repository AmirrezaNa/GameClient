package offlineGame.controller.game.objectsController.finalBoss;

import offlineGame.controller.game.GameController;
import offlineGame.controller.game.SmileyAttacksController;
import offlineGame.view.gameLoop.phase2.finalBoss.FinalBossPanel;

import static offlineGame.controller.game.GameController.smiley;

public class SmileyController {


    public static void updateSmiley() {
        if (smiley != null) {
            if (smiley.y < 100) {
                smiley.y += smiley.dy;
            } else {
                if (smiley.dx == 0) {
                    smiley.dx = 1;
                }
                if (smiley.dx > 0) {
                    if (smiley.x > 750) {
                        smiley.dx = -smiley.dx;
                    }
                }
                if (smiley.dx < 0) {
                    if (smiley.x < 600) {
                        smiley.dx = -smiley.dx;
                    }
                }
                smiley.x += smiley.dx;
            }
            if (smiley.enemyHealth < 100 && !smiley.punchExists) {
                smiley.punchExists = true;
                FinalBossPanel.punch = GameController.newPunch(550, 0);
                SmileyAttacksController.startPowerPunchAttack();
            }
        }
    }

}
