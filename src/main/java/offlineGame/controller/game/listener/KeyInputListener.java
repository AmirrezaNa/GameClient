package offlineGame.controller.game.listener;

import offlineGame.controller.game.GameController;
import offlineGame.controller.game.Impact;
import offlineGame.controller.game.SkillTreeController;
import model.entity.BallModel;
import offlineGame.view.settings.SettingsPanel;
import offlineGame.view.startPage.EnterNamePage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static offlineGame.controller.game.GameController.ball;
import static offlineGame.controller.game.GameController.smiley;

public class KeyInputListener implements KeyListener {

    Set<Integer> pressedKeys = new HashSet<>();

    // Default key codes that can be changed based on user input
    public static int upKey = KeyEvent.VK_UP;
    public static int downKey = KeyEvent.VK_DOWN;
    public static int leftKey = KeyEvent.VK_LEFT;
    public static int rightKey = KeyEvent.VK_RIGHT;
    public static int banishKey = KeyEvent.VK_B;
    public static int writOfAresKey = KeyEvent.VK_S;
    public static int writOfCerberus = KeyEvent.VK_C;
    public static int writOfAcesoKey = KeyEvent.VK_O;
    public static int writOfProteusKey = KeyEvent.VK_P;
    public static int writOfEmpusa = KeyEvent.VK_E;
    public static int writOfDolus = KeyEvent.VK_D;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!GameController.pause) {
            pressedKeys.add(e.getKeyCode());

            if (smiley != null && smiley.quakeAttack && !GameController.pause) {
                handleKeyPressedCombinationDuringQuakeAttack();
            }
            else if (!GameController.pause){
                handleKeyPressedCombination();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.clear();
    }


    // this method is for checking which keys are being pressed at every moment ================================
    public void handleKeyPressedCombination() {
        if (pressedKeys.size() == 1) {

            if (pressedKeys.contains(upKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.y -= 2 * ball.dy;
                }

            }
            else if (pressedKeys.contains(downKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.y += 2 * ball.dy;
                }

            }
            else if (pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                }

            }
            else if (pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                }

            }
            else if (pressedKeys.contains(banishKey)) {
                Impact.banishImpact(ball.x, ball.y, ball.x, ball.y);
            }
            else if (pressedKeys.contains(writOfProteusKey)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    if (EnterNamePage.player.isWritOfProteus()) {
                        EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                        SkillTreeController.turnOnWritOfProteus();
                    }
                }
            }
            else if (pressedKeys.contains(writOfAresKey)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    if (EnterNamePage.player.isWritOfAres()) {
                        EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                        SkillTreeController.turnOnWritOfAres();
                    }

                }
            }
            else if (pressedKeys.contains(writOfAcesoKey)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    if (EnterNamePage.player.isWritOfAceso()) {
                        EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                        SkillTreeController.turnOnWritOfAceso();
                    }

                }
            }
            else if (pressedKeys.contains(writOfCerberus)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    if (EnterNamePage.player.isWritOfCerberus()) {
                        EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                        SkillTreeController.turnOnWritOfCerberus();
                    }

                }
            }
            else if (pressedKeys.contains(writOfEmpusa)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                    BallModel.ballRadius = (int) (0.9 * BallModel.ballRadius);
                }
            }
            else if (pressedKeys.contains(writOfDolus)) {
                if (EnterNamePage.player.getXP() >= 100) {
                    EnterNamePage.player.setXP(EnterNamePage.player.getXP() - 100);
                    int i = 0;
                    if (EnterNamePage.player.isWritOfEmpusa()) {
                        i++;
                        BallModel.ballRadius = (int) (0.9 * BallModel.ballRadius);
                    }
                    if (EnterNamePage.player.isWritOfChiron()) {
                        i++;
                        ball.ballChiron = true;
                    }
                    if (EnterNamePage.player.isWritOfCerberus() && i < 2) {
                        SkillTreeController.turnOnWritOfCerberus();
                    }
                    if (EnterNamePage.player.isWritOfAres() && i < 2) {
                        SkillTreeController.turnOnWritOfAres();
                    }
                }
            }

        } else {
            if (pressedKeys.contains(upKey) && pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                    ball.y -= 2 * ball.dy;
                }

            } else if (pressedKeys.contains(upKey) && pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                    ball.y -= 2 * ball.dy;
                }

            } else if (pressedKeys.contains(downKey) && pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                    ball.y += 2 * ball.dy;
                }

            } else if (pressedKeys.contains(downKey) && pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                    ball.y += 2 * ball.dy;
                }

            }
        }

    }





    //===========================       during quake attack      =============================




    public void handleKeyPressedCombinationDuringQuakeAttack() {
        if (pressedKeys.size() == 1) {

            if (pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.y -= 2 * ball.dy;
                }

            }
            else if (pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.y += 2 * ball.dy;
                }

            }
            else if (pressedKeys.contains(upKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                }

            }
            else if (pressedKeys.contains(downKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                }

            }

        } else {
            if (pressedKeys.contains(downKey) && pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                    ball.y -= 2 * ball.dy;
                }

            } else if (pressedKeys.contains(downKey) && pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                    ball.y -= ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                    ball.y -= ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                    ball.y -= 2 * ball.dy;
                }

            } else if (pressedKeys.contains(upKey) && pressedKeys.contains(rightKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x -= ball.dx/2;
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x -= ball.dx;
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x -= 2 * ball.dx;
                    ball.y += 2 * ball.dy;
                }

            } else if (pressedKeys.contains(upKey) && pressedKeys.contains(leftKey)) {
                if (SettingsPanel.sense == 1) {
                    ball.x += ball.dx/2;
                    ball.y += ball.dy/2;
                }
                if (SettingsPanel.sense == 2) {
                    ball.x += ball.dx;
                    ball.y += ball.dy;
                }
                if (SettingsPanel.sense == 3) {
                    ball.x += 2 * ball.dx;
                    ball.y += 2 * ball.dy;
                }

            }
        }

    }
}
